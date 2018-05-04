package com.example.websocket.utils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ceeety.middleware.protobuf.CeeetyProductArrivalListPb;
import com.ceeety.middleware.protobuf.CeeetyProductArrivalListPb.Arrival;
import com.ceeety.middleware.protobuf.CeeetyProductDepartureListPb;
import com.ceeety.middleware.protobuf.CeeetyProductDepartureListPb.Departure;
import com.example.websocket.client.CeeetyBasePb;
import com.rabbitmq.client.AMQP.Exchange;
import com.rabbitmq.client.AMQP.Queue;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.rabbitmq.client.ShutdownSignalException;

public class RabbitMQUtils {
	private  Logger logger = LoggerFactory.getLogger(RabbitMQUtils.class);
	public static Connection getRabbitMQConnection() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername("testing");
		factory.setPassword("testing");
		factory.setHost("192.168.11.9");
		factory.setPort(5672);
		Connection connection = factory.newConnection();
		return connection;
	}
	public Channel getRabbitMQChannel() throws IOException, TimeoutException {
		Channel channel = getRabbitMQConnection().createChannel();
		return channel;
		
	}
	public static List<Departure> getDeparturesList() throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException{
		List<Departure> list=null;
		Channel channel=getRabbitMQConnection().createChannel();
		channel.queueDeclare("weijie_test_d1", false, false, false, null);
		channel.queueBind("weijie_test_d1", "KMG_D1", "");
		channel.basicQos(1);
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume("weijie_test_d1", true, consumer);
		while (true) {
			Delivery delivery = consumer.nextDelivery();
			CeeetyBasePb.Base msg = CeeetyBasePb.Base.parseFrom(delivery.getBody());
			String type=msg.getType();
			if(type.equals("departure")) {
				CeeetyProductDepartureListPb.Info info=CeeetyProductDepartureListPb.Info.parseFrom(msg.getData().getValue());
				list=info.getDeparturesList();
				break;
			}
		}
		channel.queueDelete("weijie_test_d1");
		channel.close();
		channel.getConnection().close();
		return list;
	}
	public static List<Arrival> getArrivalsList() throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException{
		List<Arrival> list=null;
		Channel channel=getRabbitMQConnection().createChannel();
		channel.queueDeclare("weijie_test_a1", false, false, false, null);
		channel.queueBind("weijie_test_a1", "KMG_A1", "");
		channel.basicQos(1);
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume("weijie_test_a1", true, consumer);
		while (true) {
			Delivery delivery = consumer.nextDelivery();
			CeeetyBasePb.Base msg = CeeetyBasePb.Base.parseFrom(delivery.getBody());
			String type=msg.getType();
			if(type.equals("arrival")) {
				CeeetyProductArrivalListPb.Info info=CeeetyProductArrivalListPb.Info.parseFrom(msg.getData().getValue());
				list=info.getArrivalsList();
				break;
			}
		}
		channel.queueDelete("weijie_test_a1");
		channel.close();
		channel.getConnection().close();
		return list;
	}
}

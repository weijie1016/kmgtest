package com.example.websocket.client;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;


public class RabbitMQConsumerFactory {

	private RabbitMQConsumerFactory() {
	}
	public static Channel getChannel() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername("testing");
		factory.setPassword("testing");
		factory.setHost("192.168.11.9");
		factory.setPort(5672);
		Connection connection = factory.newConnection();
		Channel channel=connection.createChannel();
		return channel;
	}
	public static D1Consumer getD1Consumer() throws IOException, TimeoutException {

		Channel channel = getChannel();
		channel.queueDeclare("weijie_test_d1", false, false, true, null);
		// channel.queueBind("weijie_test_d1", "KMG","");][-2
		channel.queueBind("weijie_test_d1", "KMG_D1", "");
		// channel.queueBind("weijie_test_d1", "exchange_direct", "weijie_test_d1");
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		return new D1Consumer(channel);
	}
	
}

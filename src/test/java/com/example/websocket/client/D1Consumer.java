package com.example.websocket.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.ceeety.middleware.protobuf.CeeetyProductDepartureListPb;
import com.ceeety.middleware.protobuf.CeeetyProductDepartureListPb.Departure;
import com.ceeety.middleware.protobuf.CeeetyProductDepartureListPb.Info;
import com.example.websocket.vo.D1;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;

public class D1Consumer extends DefaultConsumer{
	private D1 d1;
	private List<D1> list=new ArrayList<D1>();
	public D1Consumer(Channel channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
			throws IOException {
		CeeetyBasePb.Base msg = CeeetyBasePb.Base.parseFrom(body);
		String type=msg.getType();
		if(type.equals("departure")) {
			Info info=CeeetyProductDepartureListPb.Info.parseFrom(msg.getData().getValue());
			List<Departure> dList = info.getDeparturesList();
			for(Departure departure:dList) {
				d1.setCounterNo(departure.getCounterNo());
				list.add(d1);
			}
		}
		
	}
	public List<D1> getD1List(){
		return list;
	}
}

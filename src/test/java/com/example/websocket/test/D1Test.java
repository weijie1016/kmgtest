package com.example.websocket.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ceeety.middleware.protobuf.CeeetyProductDepartureListPb;
import com.ceeety.middleware.protobuf.CeeetyProductDepartureListPb.Departure;
import com.example.websocket.utils.CSVDataProvider;
import com.example.websocket.utils.RabbitMQUtils;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.ShutdownSignalException;

public class D1Test extends BaseTest{
	private Logger logger = LoggerFactory.getLogger(D1Test.class);
	private int i;
	private int j;
	private List<Departure> departureList;
	@Test(dataProvider="d1")
	public void testD1(Map<String, String> data) {
		i=j++;
//		logger.info("线程：D1Test "+Thread.currentThread().getName());
		//航班号转存List<String>
		List<String> flightNoList=new ArrayList<String>();
		for(CeeetyProductDepartureListPb.FlightNoEntity f:departureList.get(i).getFlightNoEntityList()) {
			flightNoList.add(f.getFlightNo());
		}

		Assert.assertEquals(flightNoList, Arrays.asList(data.get("flightNo").split("\\|")));
		Assert.assertEquals(departureList.get(i).getToCityZH(), data.get("toCityZH"));
		Assert.assertEquals(departureList.get(i).getCounterNo(), data.get("counterNo"));
		Assert.assertEquals(departureList.get(i).getStatusZH(), data.get("statusZH"));
	}
	
	@DataProvider(name = "d1")
	public Iterator<Object[]> dataForTestMethod() {
		return new CSVDataProvider("D1");
	}
	@BeforeClass
	public void beforeClass() throws ShutdownSignalException, ConsumerCancelledException, IOException, TimeoutException, InterruptedException {
		departureList=RabbitMQUtils.getDeparturesList();
		logger.info("线程：D1 "+Thread.currentThread().getName());
	}
	@AfterClass
	public void afterClass() {

	}
}

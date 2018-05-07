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

import com.ceeety.middleware.protobuf.CeeetyProductArrivalListPb;
import com.ceeety.middleware.protobuf.CeeetyProductArrivalListPb.Arrival;
import com.example.websocket.utils.CSVDataProvider;
import com.example.websocket.utils.RabbitMQUtils;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.ShutdownSignalException;

public class A1Test extends BaseTest {
	private Logger logger = LoggerFactory.getLogger(A1Test.class);
	private int i;
	private int j;
	private List<Arrival> arrivalList;
	@Test(dataProvider = "a1")
	public void testA1(Map<String, String> data) {
		i=j++;
		// logger.info("线程：A1Test "+Thread.currentThread().getName());
		// 航班号转存List<String>
		List<String> flightNoList = new ArrayList<String>();
		for (CeeetyProductArrivalListPb.FlightNoEntity f : arrivalList.get(i).getFlightNoEntityList()) {
			flightNoList.add(f.getFlightNo());
		}

		Assert.assertEquals(flightNoList, Arrays.asList(data.get("flightNo").split("\\|")));
		Assert.assertEquals(arrivalList.get(i).getFromCityZH(), data.get("fromCityZH"));
		Assert.assertEquals(arrivalList.get(i).getExitNo(), data.get("exitNo"));
		Assert.assertEquals(arrivalList.get(i).getStatusZH(), data.get("statusZH"));
	}

	@DataProvider(name = "a1")
	public Iterator<Object[]> dataForTestMethod() {
		return new CSVDataProvider("A1");
	}

	@BeforeClass
	public void beforeClass() throws ShutdownSignalException, ConsumerCancelledException, IOException, TimeoutException,
			InterruptedException {
		arrivalList = RabbitMQUtils.getArrivalsList();
		logger.info("线程：A1 "+Thread.currentThread().getName());
	}

	@AfterClass
	public void afterClass() {

	}
}

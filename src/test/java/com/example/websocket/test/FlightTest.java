package com.example.websocket.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ceeety.middleware.protobuf.CeeetyProductArrivalListPb;
import com.ceeety.middleware.protobuf.CeeetyProductArrivalListPb.Arrival;
import com.ceeety.middleware.protobuf.CeeetyProductDepartureListPb;
import com.ceeety.middleware.protobuf.CeeetyProductDepartureListPb.Departure;
import com.example.websocket.utils.CSVFileReader;
import com.example.websocket.utils.RabbitMQUtils;
import com.example.websocket.vo.A1;
import com.example.websocket.vo.D1;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.ShutdownSignalException;

public class FlightTest extends BaseTest {
	private Logger logger = LoggerFactory.getLogger(FlightTest.class);

	@Test
	public void testD1() throws ShutdownSignalException, ConsumerCancelledException, IOException, TimeoutException,
			InterruptedException {
		List<D1> resultList = new ArrayList<D1>();
		List<D1> expectedList = new ArrayList<D1>();
		
		// 取实际结果
		for (Departure d : RabbitMQUtils.getDeparturesList()) {
//			logger.info("线程：D1-" + Thread.currentThread().getName());
			D1 d1 = new D1();
			// logger.info(d.getToCityZH());
			d1.setToCityZH(d.getToCityZH());
			d1.setCounterNo(d.getCounterNo());
			d1.setStatusZH(d.getStatusZH());
			List<String> flightNoList=new ArrayList<String>();
			for(CeeetyProductDepartureListPb.FlightNoEntity flightNo:d.getFlightNoEntityList()) {
				String f=flightNo.getFlightNo().toString();
				flightNoList.add(f);
			}
			d1.setFlightNo(flightNoList);
			resultList.add(d1);
		}
		// 取预期结果
		List<String> lines=CSVFileReader.readCSVFile(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\D1.csv");
		for(String line:lines) {
			String[] fields=line.split(",");
			D1 d1=new D1();
			List<String> flightNoList=Arrays.asList(fields[0].split("\\|"));
			d1.setFlightNo(flightNoList);
			d1.setToCityZH(fields[1]);
			d1.setCounterNo(fields[2]);
			d1.setStatusZH(fields[3]);
			expectedList.add(d1);
		}
		
		// 比较
		Assert.assertEquals(resultList.size(), 7, "出港航班数与预期不等");
		for(int i=0;i<expectedList.size();i++) {
			Assert.assertEquals(resultList.get(i).getFlightNo(), expectedList.get(i).getFlightNo());
			Assert.assertEquals(resultList.get(i).getToCityZH(), expectedList.get(i).getToCityZH());
			Assert.assertEquals(resultList.get(i).getCounterNo(), expectedList.get(i).getCounterNo());
			Assert.assertEquals(resultList.get(i).getStatusZH(), expectedList.get(i).getStatusZH());
		}
	}

	@Test
	public void testA1() throws ShutdownSignalException, ConsumerCancelledException, IOException, TimeoutException,
			InterruptedException {
		List<A1> resultList = new ArrayList<A1>();
		List<A1> expectedList = new ArrayList<A1>();
		
		// 取实际结果
		for (Arrival a : RabbitMQUtils.getArrivalsList()) {
//			logger.info("线程：A1-" + Thread.currentThread().getName());
			A1 a1 = new A1();
			// logger.info(a.getFromCityZH());
			a1.setFromCityZH(a.getFromCityZH());
			a1.setExitNo(a.getExitNo());
			a1.setStatusZH(a.getStatusZH());
			List<String> flightNoList=new ArrayList<String>();
			for(CeeetyProductArrivalListPb.FlightNoEntity flightNo:a.getFlightNoEntityList()) {
				String f=flightNo.getFlightNo().toString();
				flightNoList.add(f);
			}
			a1.setFlightNo(flightNoList);
			resultList.add(a1);
		}
		// 取预期结果
		List<String> lines=CSVFileReader.readCSVFile(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\A1.csv");
		for(String line:lines) {
			String[] fields=line.split(",");
			A1 a1=new A1();
			List<String> flightNoList=Arrays.asList(fields[0].split("\\|"));
			a1.setFlightNo(flightNoList);
			a1.setFromCityZH(fields[1]);
			a1.setExitNo(fields[2]);
			a1.setStatusZH(fields[3]);
			expectedList.add(a1);
		}
		// 比较
		Assert.assertEquals(resultList.size(), 2, "到港航班数与预期不等");
		for(int i=0;i<expectedList.size();i++) {
			Assert.assertEquals(resultList.get(i).getFlightNo(), expectedList.get(i).getFlightNo());
			Assert.assertEquals(resultList.get(i).getFromCityZH(), expectedList.get(i).getFromCityZH());
			Assert.assertEquals(resultList.get(i).getExitNo(), expectedList.get(i).getExitNo());
			Assert.assertEquals(resultList.get(i).getStatusZH(), expectedList.get(i).getStatusZH());
		}
	}
}

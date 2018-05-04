package com.example.websocket.test;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.ceeety.middleware.protobuf.CeeetyProductArrivalListPb.Arrival;
import com.ceeety.middleware.protobuf.CeeetyProductDepartureListPb.Departure;
import com.example.websocket.client.WebSocketClientFactory;
import com.example.websocket.utils.ExcelUtils;
import com.example.websocket.utils.JSONUtils;
import com.example.websocket.utils.RabbitMQUtils;
import com.example.websocket.vo.A1;
import com.example.websocket.vo.D1;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.ShutdownSignalException;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.java_websocket.WebSocket.READYSTATE;
import org.java_websocket.client.WebSocketClient;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	@BeforeTest
	public void beforeTest() throws EncryptedDocumentException, ClassNotFoundException, InvalidFormatException, SQLException, IOException {
		ExcelUtils.importData("data\\FlightTest");
		//初始化出港航班数据
	}
	@AfterTest
	public void afterTest() {
	}
//	protected static String dataVersion = "";
//	private WebSocketClient client;
//
//	public String getWebSocketMessage(String req, String res) {
//		String msg = "";
//		String jsonData = "";
//		try {
//			client = WebSocketClientFactory.getClient();
//			client.connect();
//			while (!client.getReadyState().equals(READYSTATE.OPEN)) {
//				System.out.println("还没有打开");
//				Thread.sleep(500);
//			}
//			System.out.println("打开了");
//			// client.send("40/product-departure");
//			client.send(req);
//			String version = dataVersion;
//
//			while (true) {
//				client.send("42/viewcmd,[\"data\",true]");
//				
//				msg = WebSocketClientFactory.message;
//				
//				jsonData=msg.substring(msg.indexOf("{"), msg.lastIndexOf("}") + 1);
//				if (msg.contains(res)) {
//					dataVersion = JSONUtils.getJSONDataVersion(jsonData);
//					if (!dataVersion.equals(version)) {
//						break;
//					} else {
//						continue;
//					}
//
//				}
//				Thread.sleep(500);
//			}
//
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (client != null) {
//				client.close();
//			}
//		}
//		return msg;
//	}
	
}

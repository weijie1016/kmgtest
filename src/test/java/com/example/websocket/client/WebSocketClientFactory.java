package com.example.websocket.client;

import java.net.URI;
import java.net.URISyntaxException;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

public class WebSocketClientFactory {
	public static String message = null;

	private WebSocketClientFactory() {
	}
	
	public static WebSocketClient getClient() throws URISyntaxException {
		return  new WebSocketClient(new URI("ws://192.168.11.236:3001/socket.io/?EIO=3&transport=websocket"),
				new Draft_6455()) {
			@Override
			public void onOpen(ServerHandshake arg0) {
				System.out.println("打开链接");
			}

			@Override
			public void onMessage(String arg0) {
				// System.out.println("收到消息" + arg0);
				message = arg0;
			}

			@Override
			public void onError(Exception arg0) {
				arg0.printStackTrace();
				System.out.println("发生错误已关闭");
			}

			@Override
			public void onClose(int arg0, String arg1, boolean arg2) {
				System.out.println("链接已关闭");
			}
		};
	}
	
}

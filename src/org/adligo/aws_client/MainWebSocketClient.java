package org.adligo.aws_client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;

import org.adligo.i.util.client.I_Event;
import org.adligo.i.util.client.I_Listener;

public class MainWebSocketClient {

	public static void main(String [] args) {
		try {
			HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("key1", "value1");
			headers.put("key2", "value2");

			WebSocketClientConfig config = new WebSocketClientConfig();
			//config.setUrl(new URI("ws://localhost:8088/debug/"));
			config.setUrl(new URI("ws://localhost:8088/ws_server_demo/debug/a"));
			//config.setUrl(new URI("ws://localhost:8088/ws_server_demo/count/a"));
			config.setHeaders(headers);
			
			final I_WebSocketClient ws = new WebSocketClient(config);
			ws.addListener(new I_Listener() {
				@Override
				public void onEvent(I_Event p) {
					System.out.println("got event " + p);
					Object val = p.getValue();
					if (p.threwException()) {
						p.getException().printStackTrace();
						ws.disconnect();
					} else {
						Integer num = Integer.parseInt((String) val);
						if (num > 20) {
							ws.disconnect();
						}
					} 
				}
			});
			ws.connect();

			System.out.println("calling server ");
			sendFile(ws);
			/*
			ws.send("request 1");
			Thread.sleep(500);
			ws.send("request 2");
			Thread.sleep(5000);
			ws.send("request 3");
			Thread.sleep(500);
			ws.send("request 4");
			Thread.sleep(5000);
			ws.send("request 5");
			Thread.sleep(500);
			*/
			System.out.println("disconnecting from server ");
			ws.disconnect();
			System.out.println("disconnected from server ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void sendFile(I_WebSocketClient ws)
			throws IOException {
		InputStream in = WebSocketClient.class.getResourceAsStream(
				"/org/adligo/aws_client/EmailList2.xml");
		StringBuffer sb = new StringBuffer();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte [] bytes = new byte[1];
		while (in.read(bytes) != -1) {
			baos.write(bytes);
		}
		String file = baos.toString("UTF-8");
		ws.send(file);
	}
}

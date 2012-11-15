package org.adligo.aws_client;

import org.adligo.aws_client.WebSocketClientConfig.OUTPUT_FORMAT;
import org.adligo.tests.ATest;

public class WebSocketClientConfigTests extends ATest {

	public void testConfig() {
		WebSocketClientConfig config = new WebSocketClientConfig();
		config.setOutputFormat(OUTPUT_FORMAT.UTF8_STRING);
		assertEquals(OUTPUT_FORMAT.UTF8_STRING, config.getOutputFormat());
	}
}

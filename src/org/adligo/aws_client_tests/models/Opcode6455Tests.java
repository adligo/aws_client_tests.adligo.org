package org.adligo.aws_client_tests.models;

import org.adligo.aws_client.models.Opcode6455;
import org.adligo.tests.ATest;

public class Opcode6455Tests extends ATest {

	public void testOnesAndZeros() {
		assertEquals("0000", Opcode6455.CONTINUATION.getOnesAndZeros());
		assertEquals("0001", Opcode6455.TEXT.getOnesAndZeros());
		assertEquals("0010", Opcode6455.BINARY.getOnesAndZeros());
		assertEquals("0011", Opcode6455.NON_CONTROL_3.getOnesAndZeros());
		
		assertEquals("0100", Opcode6455.NON_CONTROL_4.getOnesAndZeros());
		assertEquals("0101", Opcode6455.NON_CONTROL_5.getOnesAndZeros());
		assertEquals("0110", Opcode6455.NON_CONTROL_6.getOnesAndZeros());
		assertEquals("0111", Opcode6455.NON_CONTROL_7.getOnesAndZeros());
		
		assertEquals("1000", Opcode6455.CLOSE.getOnesAndZeros());
		assertEquals("1001", Opcode6455.PING.getOnesAndZeros());
		assertEquals("1010", Opcode6455.PONG.getOnesAndZeros());
		assertEquals("1011", Opcode6455.CONTROL_11.getOnesAndZeros());
		
		assertEquals("1100", Opcode6455.CONTROL_12.getOnesAndZeros());
		assertEquals("1101", Opcode6455.CONTROL_13.getOnesAndZeros());
		assertEquals("1110", Opcode6455.CONTROL_14.getOnesAndZeros());
		assertEquals("1111", Opcode6455.CONTROL_15.getOnesAndZeros());
	}
}

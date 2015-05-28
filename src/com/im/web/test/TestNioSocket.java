package com.im.web.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.im.test.base.UnitTestBase;
import com.im.web.nio.XmppIoHandler;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestNioSocket extends UnitTestBase {

	public TestNioSocket() {
		super("classpath:spring/ApplicationContext-nio.xml");
	}

	@Test
	public void testSay(){
		XmppIoHandler handler = super.getBean("xmppHandler");
		System.out.println("handler: " + handler.hashCode());
	}
}

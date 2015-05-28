package com.im.web.nio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class XmppIoHandler implements IoHandler {
	
	private static final Log log = LogFactory.getLog(XmppIoHandler.class);
	
	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		log.debug("exceptionCaught is run..");
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String s = (String) message;
		session.write("server answer :" + s);
		log.debug("messageReceived is run..");
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		log.debug("messageSent is run..");
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		log.debug("sessionClosed is run..");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		log.debug("sessionCreated is run..");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		log.debug("sessionIdle is run..");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		log.debug("sessionOpened is run..");
		log.debug("remoteAddress=" + session.getRemoteAddress());
	}

}

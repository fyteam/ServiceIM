package com.im.web.nio;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class XmppEncoder implements ProtocolEncoder {
	
	private final Log log = LogFactory.getLog(XmppEncoder.class);

	@Override
	public void dispose(IoSession arg0) throws Exception {
		 log.debug("dispose()...");
	}

	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out)
			throws Exception {
		 log.debug("encode()...");
		 String s = null;
		 if(message instanceof String){
			s = (String) message;
		 }
		 CharsetEncoder charsetEncoder = (CharsetEncoder) session.getAttribute("encoder");
		 if(charsetEncoder == null){
			 charsetEncoder = Charset.defaultCharset().newEncoder();
			 session.setAttribute("encoder", charsetEncoder);
		 }
		 IoBuffer ioBuffer = IoBuffer.allocate(s.length());
		 ioBuffer.setAutoExpand(true);
		 ioBuffer.putString(s, charsetEncoder);
		 ioBuffer.flip();
		 out.write(ioBuffer);
	}

}

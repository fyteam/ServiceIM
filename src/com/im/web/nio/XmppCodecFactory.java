package com.im.web.nio;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class XmppCodecFactory implements ProtocolCodecFactory {

	private XmppEncoder encoder;
	private XmppDecoder decoder;

	/**
	 * Constructor.
	 */
	public XmppCodecFactory() {
		encoder = new XmppEncoder();
		decoder = new XmppDecoder();
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
		return decoder;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
		return encoder;
	}

}

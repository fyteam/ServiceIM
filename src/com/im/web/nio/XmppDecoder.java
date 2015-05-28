package com.im.web.nio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class XmppDecoder extends CumulativeProtocolDecoder {
	private final Log log = LogFactory.getLog(XmppDecoder.class);

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in,
			ProtocolDecoderOutput out) throws Exception {
		log.debug("doDecode(...)...");
		
		int startPosition = in.position();
		while(in.hasRemaining()){
			byte b = in.get();
			if(b == '\n'){
				int currentPosition = in.position();
				int limit = in.limit();
				in.position(startPosition);
				in.limit(currentPosition);
				IoBuffer buf = in.slice();
				byte [] dest = new byte [buf.limit()];
				buf.get(dest);
				String s = new String(dest);
				out.write(s);
				in.position(currentPosition);
				in.limit(limit);
				return true;
			}
		}
		in.position(startPosition);
		return false;
	}

}

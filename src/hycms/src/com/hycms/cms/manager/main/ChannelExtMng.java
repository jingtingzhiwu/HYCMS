package com.hycms.cms.manager.main;

import com.hycms.cms.entity.main.Channel;
import com.hycms.cms.entity.main.ChannelExt;

public interface ChannelExtMng {
	public ChannelExt save(ChannelExt ext, Channel channel);

	public ChannelExt update(ChannelExt ext);
}
package com.hycms.cms.dao.main;

import com.hycms.cms.entity.main.ChannelExt;
import com.hycms.common.hibernate3.Updater;

public interface ChannelExtDao {
	public ChannelExt save(ChannelExt bean);

	public ChannelExt updateByUpdater(Updater<ChannelExt> updater);
}
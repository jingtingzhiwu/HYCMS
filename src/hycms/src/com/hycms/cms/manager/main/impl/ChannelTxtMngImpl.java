package com.hycms.cms.manager.main.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hycms.cms.dao.main.ChannelTxtDao;
import com.hycms.cms.entity.main.Channel;
import com.hycms.cms.entity.main.ChannelTxt;
import com.hycms.cms.manager.main.ChannelTxtMng;
import com.hycms.common.hibernate3.Updater;

/**
 * 栏目文本Manager实现
 * 
 * @author 
 * 
 */
@Service
@Transactional
public class ChannelTxtMngImpl implements ChannelTxtMng {
	/**
	 * @see ChannelTxtMng#save(ChannelTxt, Channel)
	 */
	public ChannelTxt save(ChannelTxt txt, Channel channel) {
		if (txt.isAllBlank()) {
			return null;
		} else {
			txt.setChannel(channel);
			txt.init();
			dao.save(txt);
			return txt;
		}
	}

	/**
	 * @see ChannelTxtMng#update(ChannelTxt, Channel)
	 */
	public ChannelTxt update(ChannelTxt txt, Channel channel) {
		ChannelTxt entity = dao.findById(channel.getId());
		if (entity == null) {
			entity = save(txt, channel);
			channel.getChannelTxtSet().add(entity);
			return entity;
		} else {
			if (txt.isAllBlank()) {
				channel.getChannelTxtSet().clear();
				return null;
			} else {
				Updater<ChannelTxt> updater = new Updater<ChannelTxt>(txt);
				entity = dao.updateByUpdater(updater);
				entity.blankToNull();
				return entity;
			}
		}
	}

	private ChannelTxtDao dao;

	@Autowired
	public void setDao(ChannelTxtDao dao) {
		this.dao = dao;
	}
}
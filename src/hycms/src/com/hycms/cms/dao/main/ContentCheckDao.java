package com.hycms.cms.dao.main;

import com.hycms.cms.entity.main.ContentCheck;
import com.hycms.common.hibernate3.Updater;

public interface ContentCheckDao {
	public ContentCheck findById(Long id);

	public ContentCheck save(ContentCheck bean);

	public ContentCheck updateByUpdater(Updater<ContentCheck> updater);
}
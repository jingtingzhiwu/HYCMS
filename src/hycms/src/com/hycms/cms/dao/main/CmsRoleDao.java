package com.hycms.cms.dao.main;

import java.util.List;

import com.hycms.cms.entity.main.CmsRole;
import com.hycms.common.hibernate3.Updater;

public interface CmsRoleDao {
	public List<CmsRole> getList();

	public CmsRole findById(Integer id);

	public CmsRole save(CmsRole bean);

	public CmsRole updateByUpdater(Updater<CmsRole> updater);

	public CmsRole deleteById(Integer id);
}
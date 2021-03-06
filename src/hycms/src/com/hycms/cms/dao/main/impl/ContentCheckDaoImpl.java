package com.hycms.cms.dao.main.impl;

import org.springframework.stereotype.Repository;

import com.hycms.cms.dao.main.ContentCheckDao;
import com.hycms.cms.entity.main.ContentCheck;
import com.hycms.common.hibernate3.HibernateBaseDao;

@Repository
public class ContentCheckDaoImpl extends HibernateBaseDao<ContentCheck, Long>
		implements ContentCheckDao {
	public ContentCheck findById(Long id) {
		ContentCheck entity = get(id);
		return entity;
	}

	public ContentCheck save(ContentCheck bean) {
		getSession().save(bean);
		return bean;
	}

	@Override
	protected Class<ContentCheck> getEntityClass() {
		return ContentCheck.class;
	}
}
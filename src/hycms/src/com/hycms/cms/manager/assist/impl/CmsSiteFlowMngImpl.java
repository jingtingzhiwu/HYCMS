package com.hycms.cms.manager.assist.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hycms.cms.dao.assist.CmsSiteFlowDao;
import com.hycms.cms.entity.assist.CmsSiteFlow;
import com.hycms.cms.entity.main.CmsSite;
import com.hycms.cms.manager.assist.CmsSiteFlowMng;
import com.hycms.cms.statistic.FlowBean;
import com.hycms.common.util.DateFormatUtils;

@Service
@Transactional
public class CmsSiteFlowMngImpl implements CmsSiteFlowMng {

	public CmsSiteFlow save(CmsSite site, String ip, String page,
			String sessionId) {
		CmsSiteFlow cmsSiteFlow = new CmsSiteFlow();
		Date now = new Timestamp(System.currentTimeMillis());
		cmsSiteFlow.setSite(site);
		cmsSiteFlow.setAccessIp(ip);
		cmsSiteFlow.setAccessPage(page);
		cmsSiteFlow.setAccessTime(now);
		cmsSiteFlow.setAccessDate(DateFormatUtils.formatDate(now));
		cmsSiteFlow.setSessionId(sessionId);
		return dao.save(cmsSiteFlow);
	}

	@Transactional(readOnly = true)
	public CmsSiteFlow findUniqueByProperties(Integer siteId,
			String accessDate, String sessionId, String page) {
		return dao.findUniqueByProperties(siteId, accessDate, sessionId, page);
	}

	@SuppressWarnings("unchecked")
	public int freshCacheToDB(Ehcache cache) {
		int count = 0;
		List<FlowBean> list = cache.getKeys();
		for (FlowBean bean : list) {
			Element element = cache.get(bean);
			if (element == null) {
				return count;
			}
			CmsSiteFlow cmsSiteFlow = (CmsSiteFlow) element.getValue();
			if (cmsSiteFlow.getId() == null
					&& cmsSiteFlow.getSessionId() != null) {
				dao.save(cmsSiteFlow);
			}
		}
		return count;
	}

	@Autowired
	private CmsSiteFlowDao dao;
}

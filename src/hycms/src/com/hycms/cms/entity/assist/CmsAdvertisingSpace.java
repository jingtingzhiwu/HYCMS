package com.hycms.cms.entity.assist;

import com.hycms.cms.entity.assist.base.BaseCmsAdvertisingSpace;



public class CmsAdvertisingSpace extends BaseCmsAdvertisingSpace {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsAdvertisingSpace () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsAdvertisingSpace (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsAdvertisingSpace (
		java.lang.Integer id,
		com.hycms.cms.entity.main.CmsSite site,
		java.lang.String name,
		java.lang.Boolean enabled) {

		super (
			id,
			site,
			name,
			enabled);
	}

/*[CONSTRUCTOR MARKER END]*/


}
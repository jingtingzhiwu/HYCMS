package com.hycms.common.web.freemarker;

import freemarker.template.TemplateModelException;

/**
 * 非布尔参数异常
 * 
 * @author 
 * 
 */
@SuppressWarnings("serial")
public class MustDateException extends TemplateModelException {
	public MustDateException(String paramName) {
		super("The \"" + paramName + "\" parameter must be a date.");
	}
}

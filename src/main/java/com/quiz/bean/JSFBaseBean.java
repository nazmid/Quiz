package com.quiz.bean;

import org.apache.log4j.Logger;


public abstract class JSFBaseBean {
	
	private static final Logger logger = Logger.getLogger(JSFBaseBean.class);

	public JSFBaseBean() {
		logger.info("Instantiating " + getClass() + " objects");
	}
	
}

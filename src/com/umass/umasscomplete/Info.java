package com.umass.umasscomplete;

import java.io.Serializable;

public class Info implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	//int pos;
	//long id;
	//public transient Context con;
	//public transient View v;
	String name;
	
	
	public Info() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}

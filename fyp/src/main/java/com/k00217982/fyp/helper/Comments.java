package com.k00217982.fyp.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mull
 *
 */
public class Comments {
	private String description;
	private String author;
	private String returns;
	private List<String> params = new ArrayList<String>();
	
	public Comments() {}

	/**
	 * @param description description of a method / class
	 * @param author author of this method / class
	 * @param returns
	 * @param params
	 */
	public Comments(String description, String author, String returns, List<String> params) {
		super();
		this.description = description;
		this.author = author;
		this.returns = returns;
		this.params = params;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return
	 */
	public String getReturns() {
		return returns;
	}

	/**
	 * @param returns
	 */
	public void setReturns(String returns) {
		this.returns = returns;
	}

	/**
	 * @return
	 */
	public List<String> getParams() {
		return params;
	}

	/**
	 * @param params
	 */
	public void setParams(List<String> params) {
		this.params = params;
	}
	
	
}

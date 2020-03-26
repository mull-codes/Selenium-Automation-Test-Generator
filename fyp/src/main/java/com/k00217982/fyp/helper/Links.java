package com.k00217982.fyp.helper;

public class Links {
	private String key;
	private String value;
	private boolean isUsed;
	
	public Links() {}

	public Links(String key, String value, boolean isUsed) {
		super();
		this.key = key;
		this.value = value;
		this.isUsed = isUsed;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	
	boolean exists(String value) {
		if(this.value.equals(value)) {
			return true;
		}else {
			return false;
		}
	}
	
}
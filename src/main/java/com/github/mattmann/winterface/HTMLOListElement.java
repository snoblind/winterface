package com.github.mattmann.winterface;

public interface HTMLOListElement extends HTMLElement {

	boolean isCompact();
	void setCompact(boolean compact);

	long getStart();
	void setStart(long start);

	String getType();
	void setType(String type);
}

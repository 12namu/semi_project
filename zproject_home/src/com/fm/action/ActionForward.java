package com.fm.action;

public class ActionForward {
	private boolean isRedirect; //true면 포워드 아니면 리다이렉트
	private String path; //경로 
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}

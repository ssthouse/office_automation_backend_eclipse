package com.ssthouse.officeautomation.controller.bean;

public class TokenResultBean {
	
	 /**
     * ok : false
     * token : 
     */

    private boolean ok;
    private String token;
    
    public TokenResultBean(boolean ok, String token) {
		super();
		this.ok = ok;
		this.token = token;
	}

	public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

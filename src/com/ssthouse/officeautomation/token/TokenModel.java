package com.ssthouse.officeautomation.token;

public class TokenModel {

	// 作为 key, 在 radis 中保存数据
	private long userId;
	
	// jwt 生成的 token
	private String token;
	
	public TokenModel(long userId, String token) {
		super();
		this.userId = userId;
		this.token = token;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}

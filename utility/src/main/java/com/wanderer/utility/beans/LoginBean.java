/**
 * 
 */
package com.wanderer.utility.beans;

/**
 * @author anupam babar
 * @desc This class represents the information used for login activity.
 */
public class LoginBean {

	private String username;
	private String password;
	private String sessionId;
	private String token;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + ", sessionId=" + sessionId + ", token=" + token + "]";
	}

}

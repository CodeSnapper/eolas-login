package org.eolas.model;




public class User {
 private String userId;
 private String enable;
 private String credentialNotExpired;
 private String accountNotLocked;
 private String accountExpired;
 private String userName;
 private String password;
 private String roleId;
@Override
public String toString() {
	return "User [userId=" + userId + ", enable=" + enable + ", credentialNotExpired=" + credentialNotExpired
			+ ", accountNotLocked=" + accountNotLocked + ", accountExpired=" + accountExpired + ", userName=" + userName
			+ ", password=" + password + ", roleId=" + roleId + "]";
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getEnable() {
	return enable;
}
public void setEnable(String enable) {
	this.enable = enable;
}
public String getCredentialNotExpired() {
	return credentialNotExpired;
}
public void setCredentialNotExpired(String credentialNotExpired) {
	this.credentialNotExpired = credentialNotExpired;
}
public String getAccountNotLocked() {
	return accountNotLocked;
}
public void setAccountNotLocked(String accountNotLocked) {
	this.accountNotLocked = accountNotLocked;
}
public String getAccountExpired() {
	return accountExpired;
}
public void setAccountExpired(String accountExpired) {
	this.accountExpired = accountExpired;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRoleId() {
	return roleId;
}
public void setRoleId(String roleId) {
	this.roleId = roleId;
}
 
}

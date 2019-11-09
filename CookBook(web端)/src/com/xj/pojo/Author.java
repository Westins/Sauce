package com.xj.pojo;

public class Author {
	private int aId, state;
	private String aName, aPetName, aHead, aSex, aPhone, aEmail, aPwd;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getaPwd() {
		return aPwd;
	}

	public void setaPwd(String aPwd) {
		this.aPwd = aPwd;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaPetName() {
		return aPetName;
	}

	public void setaPetName(String aPetName) {
		this.aPetName = aPetName;
	}

	public String getaHead() {
		return aHead;
	}

	public void setaHead(String aHead) {
		this.aHead = aHead;
	}

	public String getaSex() {
		return aSex;
	}

	public void setaSex(String aSex) {
		this.aSex = aSex;
	}

	public String getaPhone() {
		return aPhone;
	}

	public void setaPhone(String aPhone) {
		this.aPhone = aPhone;
	}

	public String getaEmail() {
		return aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	@Override
	public String toString() {
		return "Author [aId=" + aId + ", state=" + state + ", aName=" + aName + ", aPetName=" + aPetName + ", aHead="
				+ aHead + ", aSex=" + aSex + ", aPhone=" + aPhone + ", aEmail=" + aEmail + ", aPwd=" + aPwd + "]";
	}
}

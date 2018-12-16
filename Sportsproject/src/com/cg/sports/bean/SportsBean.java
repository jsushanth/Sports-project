package com.cg.sports.bean;

public class SportsBean {

	private int sportsId;
	private String sportsName;
	private float sportsCost;
	private String sportsBrand;
	private int sportsQuantity;
	public int getSportsId() {
		return sportsId;
	}
	public void setSportsId(int sportsId) {
		this.sportsId = sportsId;
	}
	public String getSportsName() {
		return sportsName;
	}
	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}
	public float getSportsCost() {
		return sportsCost;
	}
	public void setSportsCost(float sportsCost) {
		this.sportsCost = sportsCost;
	}
	public String getSportsBrand() {
		return sportsBrand;
	}
	public void setSportsBrand(String sportsBrand) {
		this.sportsBrand = sportsBrand;
	}
	public int getSportsQuantity() {
		return sportsQuantity;
	}
	public void setSportsQuantity(int sportsQuantity) {
		this.sportsQuantity = sportsQuantity;
	}
	@Override
	public String toString() {
		return "SportsBean [sportsId=" + sportsId + ", sportsName="
				+ sportsName + ", sportsCost=" + sportsCost + ", sportsBrand="
				+ sportsBrand + ", sportsQuantity=" + sportsQuantity + "]";
	}
	
	
	




	
	
	
}

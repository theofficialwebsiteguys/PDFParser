package com.pat.parser.objs;

public class ExcelObj {
	
	private String model;
	private String upc;
	private String unitL;
	private String unitW;
	private String unitH;
	private String unitWeight;
	
	
	@Override
	public String toString() {
		return "ExcelObj [model=" + model + ", upc=" + upc + ", unitL=" + unitL + ", unitW=" + unitW + ", unitH="
				+ unitH + ", unitWeight=" + unitWeight + "]";
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getUnitL() {
		return unitL;
	}
	public void setUnitL(String unitL) {
		this.unitL = unitL;
	}
	public String getUnitW() {
		return unitW;
	}
	public void setUnitW(String unitW) {
		this.unitW = unitW;
	}
	public String getUnitH() {
		return unitH;
	}
	public void setUnitH(String unitH) {
		this.unitH = unitH;
	}
	public String getUnitWeight() {
		return unitWeight;
	}
	public void setUnitWeight(String unitWeight) {
		this.unitWeight = unitWeight;
	}
	
	

}

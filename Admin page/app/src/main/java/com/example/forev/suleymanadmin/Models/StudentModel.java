package com.example.forev.suleymanadmin.Models;

public class StudentModel{
	private String ogrAd;
	private String ogrSoyad;
	private String ogrNo;

	public void setOgrAd(String ogrAd){
		this.ogrAd = ogrAd;
	}

	public String getOgrAd(){
		return ogrAd;
	}

	public void setOgrSoyad(String ogrSoyad){
		this.ogrSoyad = ogrSoyad;
	}

	public String getOgrSoyad(){
		return ogrSoyad;
	}

	public void setOgrNo(String ogrNo){
		this.ogrNo = ogrNo;
	}

	public String getOgrNo(){
		return ogrNo;
	}

	@Override
 	public String toString(){
		return 
			"StudentModel{" + 
			"ogrAd = '" + ogrAd + '\'' + 
			",ogrSoyad = '" + ogrSoyad + '\'' + 
			",ogrNo = '" + ogrNo + '\'' + 
			"}";
		}
}

package com.example.forev.suleyman.Models;

public class LoginModel{
	private String ogrAd;
	private boolean tf;
	private String ogrSoyad;
	private String pass;
	private String ogrNo;
	private String id;
	private String text;

	public void setOgrAd(String ogrAd){
		this.ogrAd = ogrAd;
	}

	public String getOgrAd(){
		return ogrAd;
	}

	public void setTf(boolean tf){
		this.tf = tf;
	}

	public boolean isTf(){
		return tf;
	}

	public void setOgrSoyad(String ogrSoyad){
		this.ogrSoyad = ogrSoyad;
	}

	public String getOgrSoyad(){
		return ogrSoyad;
	}

	public void setPass(String pass){
		this.pass = pass;
	}

	public String getPass(){
		return pass;
	}

	public void setOgrNo(String ogrNo){
		this.ogrNo = ogrNo;
	}

	public String getOgrNo(){
		return ogrNo;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"LoginModel{" + 
			"ogrAd = '" + ogrAd + '\'' + 
			",tf = '" + tf + '\'' + 
			",ogrSoyad = '" + ogrSoyad + '\'' + 
			",pass = '" + pass + '\'' + 
			",ogrNo = '" + ogrNo + '\'' + 
			",id = '" + id + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}

package com.example.forev.suleyman.Models;

public class AllWeekModel{
	private String id;
	private String haftaIsim;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setHaftaIsim(String haftaIsim){
		this.haftaIsim = haftaIsim;
	}

	public String getHaftaIsim(){
		return haftaIsim;
	}

	@Override
 	public String toString(){
		return 
			"AllWeekModel{" + 
			"id = '" + id + '\'' + 
			",haftaIsim = '" + haftaIsim + '\'' + 
			"}";
		}
}

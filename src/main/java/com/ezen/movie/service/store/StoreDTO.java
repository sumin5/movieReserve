package com.ezen.movie.service.store;

import org.apache.ibatis.type.Alias;


@Alias("storeDTO")
public class StoreDTO {
	
	private int menuUid;
	private String menuName;
	private String menuInfo;
	private int menuPrice;
	private String menuPicture;
	private String menuUploadDate;
	
	public int getMenuUid() {
		return menuUid;
	}
	public void setMenuUid(int menuUid) {
		this.menuUid = menuUid;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuInfo() {
		return menuInfo;
	}
	public void setMenuInfo(String menuInfo) {
		this.menuInfo = menuInfo;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getMenuPicture() {
		return menuPicture;
	}
	public void setMenuPicture(String menuPicture) {
		this.menuPicture = menuPicture;
	}
	public String getMenuUploadDate() {
		return menuUploadDate;
	}
	public void setMenuUploadDate(String menuUploadDate) {
		this.menuUploadDate = menuUploadDate;
	}
	
	
}

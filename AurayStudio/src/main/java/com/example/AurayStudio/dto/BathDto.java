package com.example.AurayStudio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BathDto {
	private String userid;
	private String y_no;
	private String bath_name;
	private String style;
	private String pro_kind;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getY_no() {
		return y_no;
	}
	public void setY_no(String y_no) {
		this.y_no = y_no;
	}
	public String getBath_name() {
		return bath_name;
	}
	public void setBath_name(String bath_name) {
		this.bath_name = bath_name;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPro_kind() {
		return pro_kind;
	}
	public void setPro_kind(String pro_kind) {
		this.pro_kind = pro_kind;
	}
	
}

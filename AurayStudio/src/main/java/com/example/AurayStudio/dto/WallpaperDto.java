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
public class WallpaperDto {
	private String y_no;
	public String getY_no() {
		return y_no;
	}
	public void setY_no(String y_no) {
		this.y_no = y_no;
	}
	public String getW_name() {
		return w_name;
	}
	public void setW_name(String w_name) {
		this.w_name = w_name;
	}
	public String getPro_kind() {
		return pro_kind;
	}
	public void setPro_kind(String pro_kind) {
		this.pro_kind = pro_kind;
	}
	public String getY_img() {
		return y_img;
	}
	public void setY_img(String y_img) {
		this.y_img = y_img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private String w_name;
	private String pro_kind;
	private String y_img;
	private String content;
}

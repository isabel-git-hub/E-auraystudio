package com.example.AurayStudio.dto;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemDto {
	private String y_no;
	private String y_name;
	private String pro_kind;
	private String style;
	private String content;
}

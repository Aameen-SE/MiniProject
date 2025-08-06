package com.mongoFile.File.Upload.MongoDb.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserFiles implements Serializable{
	
	private static final long serialVersionUID = 2l;

	@Id
	private String id;
	
	private String fileName;
	private String contentType;
	private byte[] data;
	
	
	
	public String getId() {
		return id;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	
	public String toString() {
		return "ID : "+id+"\nFileName : "+fileName+"\nContentType : "+contentType+"\nData :"+data;
	}
	
}

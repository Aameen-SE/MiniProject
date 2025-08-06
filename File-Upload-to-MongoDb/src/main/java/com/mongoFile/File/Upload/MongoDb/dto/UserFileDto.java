package com.mongoFile.File.Upload.MongoDb.dto;

public class UserFileDto {

	  private String id;
	    private String fileName;
	    private String contentType;

	    public UserFileDto(String id, String fileName, String contentType) {
	        this.id = id;
	        this.fileName = fileName;
	        this.contentType = contentType;
	    }

	    // Getters
	    public String getId() {
	        return id;
	    }

	    public String getFileName() {
	        return fileName;
	    }

	    public String getContentType() {
	        return contentType;
	    }
}

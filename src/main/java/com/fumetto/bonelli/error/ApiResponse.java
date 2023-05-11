package com.fumetto.bonelli.error;

import org.springframework.core.io.FileSystemResource;

public class ApiResponse {
	
	private String message;
    private FileSystemResource resource;

    // Getters and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FileSystemResource getResource() {
        return resource;
    }

    public void setResource(FileSystemResource resource) {
        this.resource = resource;
    }

}

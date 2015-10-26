package com.bug.exeption;

/**
 * Created by vita on 10/26/15.
 */
public class ProjectException extends Exception{
    public ProjectException() {
    }
    private String message;

    public ProjectException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ProjectException{" +
                "message='" + message + '\'' +
                '}';
    }
}

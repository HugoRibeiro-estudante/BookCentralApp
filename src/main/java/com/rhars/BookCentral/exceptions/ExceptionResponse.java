package com.rhars.BookCentral.exceptions;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ExceptionResponse implements Serializable {

    private Date timestamp;
    private String message;
    private String datails;

    public ExceptionResponse(){
    }

    public ExceptionResponse(Date timestamp, String message, String datails) {
        this.timestamp = timestamp;
        this.message = message;
        this.datails = datails;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDatails() {
        return datails;
    }

    public void setDatails(String datails) {
        this.datails = datails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExceptionResponse that = (ExceptionResponse) o;
        return Objects.equals(timestamp, that.timestamp) && Objects.equals(message, that.message) && Objects.equals(datails, that.datails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, message, datails);
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", datails='" + datails + '\'' +
                '}';
    }

}

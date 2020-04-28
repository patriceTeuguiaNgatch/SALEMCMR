package org.salem.controller.account.dto;

public class ResponseDto {

    private String httpStatus;
    private Object data;
    private Object errorDetail;

    public ResponseDto() {
    }

    public ResponseDto(String httpStatus, Object data, Object errorDetail) {
        this.httpStatus = httpStatus;
        this.data = data;
        this.errorDetail = errorDetail;
    }

    public String getHttpStatus() {
        return this.httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getErrorDetail() {
        return this.errorDetail;
    }

    public void setErrorDetail(Object errorDetail) {
        this.errorDetail = errorDetail;
    }

}
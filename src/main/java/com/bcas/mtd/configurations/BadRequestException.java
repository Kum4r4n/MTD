package com.bcas.mtd.configurations;

public class BadRequestException extends Exception {

    public BadRequestException(){
        super();
    }

    public BadRequestException(Exception ex){
        super(ex);
    }

    public BadRequestException(String text){
        super(text);
    }

    public BadRequestException(String text, Exception ex){
        super(text, ex);
    }
}

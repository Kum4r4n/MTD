package com.bcas.mtd.configurations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

public class BaseController {

    public ResponseEntity<Object> Ok(@Nullable Object data){
        return new ResponseEntity<Object>(data, HttpStatus.OK);
    }

    public ResponseEntity<Object> BadRequest(String text){
        return new ResponseEntity<Object>(text, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> InterlServerError(Exception ex){
        return new ResponseEntity<Object>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

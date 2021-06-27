package com.bcas.mtd.configurations;

import com.bcas.mtd.configurations.result.MError;
import com.bcas.mtd.configurations.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

import javax.sound.midi.Track;

public class BaseController {

    public ResponseEntity<Object> Ok(@Nullable Object data){

        Result result = new Result();
        result.setIsError(false);
        result.setResult(data);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

    public ResponseEntity<Object> BadRequest(String text){
        Result result = new Result();
        result.setIsError(true);
        MError error = new MError();
        error.setTitle(text);
        result.setError(error);
        return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> InternalServerError(Exception ex){
        Result result = new Result();
        result.setIsError(true);
        MError error = new MError();
        error.setTitle("Internal server error");
        error.setException(ex);
        result.setError(error);
        return new ResponseEntity<Object>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

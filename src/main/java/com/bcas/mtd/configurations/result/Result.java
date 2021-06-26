package com.bcas.mtd.configurations.result;

import org.springframework.stereotype.Component;

@Component
public class Result {

    private boolean isError;
    private Object result;
    private MError error;

    public Result() {
    }

    public Result(boolean isError, Object result, MError error) {
        this.isError = isError;
        this.result = result;
        this.error = error;
    }

    public boolean getIsError() {
        return isError;
    }

    public void setIsError(boolean error) {
        this.isError = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public MError getError() {
        return error;
    }

    public void setError(MError error) {
        this.error = error;
    }


}



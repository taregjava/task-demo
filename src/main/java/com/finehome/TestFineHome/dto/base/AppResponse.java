package com.finehome.TestFineHome.dto.base;

import java.util.ArrayList;
import java.util.List;

public abstract class AppResponse {
    private Boolean success;
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public AppResponse() {

    }

    protected AppResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}


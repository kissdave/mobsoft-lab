package com.example.mobsoft.mobilsoftwarelab.interactor.cart.events;

/**
 * Created by mobsoft on 2017. 05. 15..
 */

public class RemoveFromCartEvent {
    private int code;
    private Throwable throwable;

    public RemoveFromCartEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
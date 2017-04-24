package com.example.mobsoft.mobilsoftwarelab.interactor.user.events;

import com.example.mobsoft.mobilsoftwarelab.model.User;

/**
 * Created by dkiss on 2017. 04. 24..
 */

public class SaveSettingsEvent {
    private int code;
    private User user;
    private Throwable throwable;

    public SaveSettingsEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

package com.example.mobsoft.mobilsoftwarelab.mock.interceptors;

import okhttp3.Request;
import okhttp3.Response;

import static com.example.mobsoft.mobilsoftwarelab.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

public class OrderMock {
    public static Response process(Request request) {

        // TODO

        return makeResponse(request, headers, responseCode, responseString);
    }
}

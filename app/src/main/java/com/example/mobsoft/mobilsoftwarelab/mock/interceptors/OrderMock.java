package com.example.mobsoft.mobilsoftwarelab.mock.interceptors;

import android.net.Uri;

import com.example.mobsoft.mobilsoftwarelab.network.NetworkConfig;
import com.example.mobsoft.mobilsoftwarelab.repository.MemoryRepository;
import com.example.mobsoft.mobilsoftwarelab.utils.GsonHelper;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.mobsoft.mobilsoftwarelab.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

public class OrderMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Orders") && request.method().equals("POST")) {
            responseString = "";
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Orders") && request.method().equals("Get")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getOrders());
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }
        return makeResponse(request, headers, responseCode, responseString);
    }
}

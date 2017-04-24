package com.example.mobsoft.mobilsoftwarelab.mock;

import com.example.mobsoft.mobilsoftwarelab.network.NetworkModule;
import com.example.mobsoft.mobilsoftwarelab.network.OrderApi;
import com.example.mobsoft.mobilsoftwarelab.network.ProductApi;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

@Module
public class MockNetworkModule {
    private NetworkModule networkModule = new NetworkModule();

    @Provides
	@Singleton
	public OkHttpClient.Builder provideOkHttpClientBuilder() {
		return networkModule.provideOkHttpClientBuilder();
	}


	@Provides
	@Singleton
	public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {

		builder.interceptors().add(3, new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				Request request = chain.request();
				return MockHttpServer.call(request);
			}
		});

		return builder.build();
	}

	@Provides
	@Singleton
	public Retrofit provideRetrofit(OkHttpClient client) {
		return networkModule.provideRetrofit(client);
	}

	@Provides
	@Singleton
	public OrderApi provideOrderApi(Retrofit retrofit) {
		return networkModule.provideOrderApi(retrofit);
	}

    @Provides
    @Singleton
    public ProductApi provideProductApi(Retrofit retrofit) {
        return networkModule.provideProductApi(retrofit);
    }
}

package com.example.retrofittestjava;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.retrofittestjava.MainActivity.apiUrl;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static ApiService apiService = null;

    public static ApiService getApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        if (apiService == null) {
            apiService = retrofit.create(ApiService.class);
        }

        return apiService;
    }

}

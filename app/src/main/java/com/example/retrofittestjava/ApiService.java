package com.example.retrofittestjava;

import com.example.retrofittestjava.Data.DA;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    Call<DA> getBoxOffice(@Query("key") String key, @Query("targetDt") String targetDt);

}

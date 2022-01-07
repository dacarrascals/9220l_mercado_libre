package com.example.a9220l_mercado_libre.Rest;

import com.example.a9220l_mercado_libre.Interfaces.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    public ApiAdapter() {
    }

    public static ApiService apiService;

    public static ApiService getApiService() {

        if(apiService==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(EndPoint.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiService= retrofit.create(ApiService.class);
        }


        return apiService;
    }
}

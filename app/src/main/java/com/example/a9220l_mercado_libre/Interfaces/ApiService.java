package com.example.a9220l_mercado_libre.Interfaces;

import com.example.a9220l_mercado_libre.Modelo.Producto;
import com.example.a9220l_mercado_libre.Rest.EndPoint;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET(EndPoint.SEARCH)
    Call<Producto> obtenerProductos(@Query("q") String q);
}

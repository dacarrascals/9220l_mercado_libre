package com.example.a9220l_mercado_libre.Modelo;

import com.example.a9220l_mercado_libre.Interfaces.ApiService;
import com.example.a9220l_mercado_libre.Interfaces.BuscarInterface;
import com.example.a9220l_mercado_libre.Rest.ApiAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuscarInteractor implements BuscarInterface.Interactor {

    private BuscarInterface.Presenter viewPresenter;

    public BuscarInteractor(BuscarInterface.Presenter viewPresenter) {
        this.viewPresenter = viewPresenter;
    }

    @Override
    public void recibirBusqueda(String q) {


        Call<Producto> call=ApiAdapter.getApiService().obtenerProductos(q);

        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {

                if(!response.isSuccessful()){
                    System.out.println("Proceso fallido!");
                    return;
                }

                Producto datosProducto= response.body();
                ArrayList<ProductoResults> productos = datosProducto.getResults();

                if(datosProducto!=null){
                    respuestaExitosa(productos);
                    System.out.println("Proceso exitoso!");

                }

            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {

            }
        });

    }

    @Override
    public void respuestaExitosa(ArrayList<ProductoResults> productos) {
        viewPresenter.respuestaExitosa(productos);
    }
}

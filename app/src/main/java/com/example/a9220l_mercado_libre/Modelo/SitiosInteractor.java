package com.example.a9220l_mercado_libre.Modelo;

import com.example.a9220l_mercado_libre.Interfaces.SitiosInterface;
import com.example.a9220l_mercado_libre.Rest.ApiAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SitiosInteractor implements SitiosInterface.Interactor {

    private SitiosInterface.Presenter presenter;

    public SitiosInteractor(SitiosInterface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void recibirBusqueda() {

        Call<List<Sitios>> call= ApiAdapter.getApiService().obtenerSitios();

        call.enqueue(new Callback<List<Sitios>>() {
            @Override
            public void onResponse(Call<List<Sitios>> call, Response<List<Sitios>> response) {

                if(!response.isSuccessful()){
                    System.out.println("Proceso fallido!");
                    return;
                }

                List<Sitios> datosSitios = response.body();

                if(datosSitios!=null){
                    respuestaExitosa(datosSitios);
                    System.out.println("Proceso exitoso!");

                }

            }

            @Override
            public void onFailure(Call<List<Sitios>> call, Throwable t) {

            }
        });

    }

    @Override
    public void respuestaExitosa(List<Sitios> sites) {
        presenter.respuestaExitosa(sites);

    }
}

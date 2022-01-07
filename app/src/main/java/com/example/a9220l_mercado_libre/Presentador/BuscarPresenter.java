package com.example.a9220l_mercado_libre.Presentador;

import com.example.a9220l_mercado_libre.Interfaces.BuscarInterface;
import com.example.a9220l_mercado_libre.Modelo.BuscarInteractor;
import com.example.a9220l_mercado_libre.Modelo.ProductoResults;

import java.util.ArrayList;

public class BuscarPresenter implements BuscarInterface.Presenter {

    private BuscarInterface.Vista viewBuscar;
    private BuscarInterface.Interactor interactor;

    public BuscarPresenter(BuscarInterface.Vista viewBuscar) {
        this.viewBuscar = viewBuscar;
        this.interactor =  new BuscarInteractor(this);
    }


    @Override
    public void recibirBusqueda(String q) {
        interactor.recibirBusqueda(q);
    }

    @Override
    public void respuestaExitosa(ArrayList<ProductoResults> productos) {
        viewBuscar.respuestaExitosa(productos);
    }
}
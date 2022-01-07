package com.example.a9220l_mercado_libre.Interfaces;

import com.example.a9220l_mercado_libre.Modelo.ProductoResults;

import java.util.ArrayList;

public interface BuscarInterface {

    interface Presenter{

        void recibirBusqueda(String q);
        void respuestaExitosa(ArrayList<ProductoResults> productos);


    }
    interface Interactor{

        void recibirBusqueda(String q);
        void respuestaExitosa(ArrayList<ProductoResults> productos);

    }
    interface Vista{

        void enviarBusqueda(String q);
        void respuestaExitosa(ArrayList<ProductoResults> productos);

    }


}

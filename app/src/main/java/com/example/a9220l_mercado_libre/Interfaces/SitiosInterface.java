package com.example.a9220l_mercado_libre.Interfaces;

import com.example.a9220l_mercado_libre.Modelo.Sitios;

import java.util.ArrayList;
import java.util.List;

public interface SitiosInterface {


    interface Presenter{

        void recibirBusqueda();
        void respuestaExitosa(List<Sitios> sites);


    }
    interface Interactor{

        void recibirBusqueda();
        void respuestaExitosa(List<Sitios> sites);

    }
    interface Vista{

        void enviarBusqueda();
        void respuestaExitosa(List<Sitios> sites);

    }

}

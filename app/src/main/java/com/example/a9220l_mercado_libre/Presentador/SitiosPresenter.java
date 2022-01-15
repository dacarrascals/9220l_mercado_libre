package com.example.a9220l_mercado_libre.Presentador;

import com.example.a9220l_mercado_libre.Interfaces.SitiosInterface;
import com.example.a9220l_mercado_libre.Modelo.Sitios;
import com.example.a9220l_mercado_libre.Modelo.SitiosInteractor;

import java.util.ArrayList;
import java.util.List;

public class SitiosPresenter implements SitiosInterface.Presenter {

    private SitiosInterface.Vista vistaSitios;
    private SitiosInterface.Interactor interactorSitios;

    public SitiosPresenter(SitiosInterface.Vista vistaSitios) {
        this.vistaSitios = vistaSitios;
        this.interactorSitios = new SitiosInteractor(this);
    }

    @Override
    public void recibirBusqueda() {
        interactorSitios.recibirBusqueda();
    }

    @Override
    public void respuestaExitosa(List<Sitios> sites) {
        vistaSitios.respuestaExitosa(sites);

    }
}

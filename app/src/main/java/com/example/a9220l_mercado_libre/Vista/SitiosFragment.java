package com.example.a9220l_mercado_libre.Vista;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a9220l_mercado_libre.Adaptadores.BuscarAdapter;
import com.example.a9220l_mercado_libre.Adaptadores.SitiosAdapter;
import com.example.a9220l_mercado_libre.Interfaces.SitiosInterface;
import com.example.a9220l_mercado_libre.Modelo.ProductoResults;
import com.example.a9220l_mercado_libre.Modelo.Sitios;
import com.example.a9220l_mercado_libre.Presentador.SitiosPresenter;
import com.example.a9220l_mercado_libre.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SitiosFragment extends Fragment implements SitiosInterface.Vista {

    private SitiosInterface.Presenter presenter;
    private RecyclerView recyclerViewSitios;
    private SitiosAdapter sitiosAdapter;
    private TextView npais;
    private static List<Sitios> mantenerResultadosPaises;
    private static int cont=0;


    public SitiosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_sitios, container, false);
        recyclerViewSitios= root.findViewById(R.id.recyclerSitios);
        npais= root.findViewById(R.id.nombrepais);
        presenter = new SitiosPresenter(this);
        if(cont==0)
        enviarBusqueda();
        if(mantenerResultadosPaises!=null){
            sitiosAdapter = new SitiosAdapter(mantenerResultadosPaises,getContext());
            recyclerViewSitios.setLayoutManager(new GridLayoutManager(getContext(),2));
            recyclerViewSitios.setAdapter(sitiosAdapter);
            recyclerViewSitios.setVisibility(View.VISIBLE);

        }
        return root;
    }

    @Override
    public void enviarBusqueda() {
    presenter.recibirBusqueda();
    }

    @Override
    public void respuestaExitosa(List<Sitios> sites) {
        addBandera(sites);
        mantenerResultadosPaises=sites;
        sitiosAdapter = new SitiosAdapter(sites,getContext());
        recyclerViewSitios.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerViewSitios.setAdapter(sitiosAdapter);
        recyclerViewSitios.setVisibility(View.VISIBLE);
        cont++;

    }

public void addBandera (List<Sitios> sites ){
    for (int i = 0; i < sites.size() ; i++) {
        String nombre= sites.get(i).getName();
        if(nombre.equals("Colombia"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.colombia));
        else if(nombre.equals("Uruguay"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.uruguay));
        else if (nombre.equals("Brasil"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.brasil));
        else if (nombre.equals("Cuba"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.cuba));
        else if (nombre.equals("Guatemala"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.guatemala));
        else if (nombre.equals("Perú"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.peru));
        else if (nombre.equals("Honduras"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.honduras));
        else if (nombre.equals("Venezuela"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.venezuela));
        else if (nombre.equals("Mexico"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.mexico));
        else if (nombre.equals("Nicaragua"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.nicaragua));
        else if (nombre.equals("Costa Rica"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.costarica));
        else if (nombre.equals("Paraguay"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.paraguay));
        else if (nombre.equals("Panamá"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.panama));
        else if (nombre.equals("Chile"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.chile));
        else if (nombre.equals("Ecuador"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.ecuador));
        else if (nombre.equals("Argentina"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.argentina));
        else if (nombre.equals("Bolivia"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.bolivia));
        else if (nombre.equals("Dominicana"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.republicadominicana));
        else if (nombre.equals("El Salvador"))
            sites.get(i).setFoto(getResources().getDrawable(R.drawable.elsalvador));
    }

}

}
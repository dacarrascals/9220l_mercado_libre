package com.example.a9220l_mercado_libre.Vista;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a9220l_mercado_libre.Adaptadores.BuscarAdapter;
import com.example.a9220l_mercado_libre.Interfaces.BuscarInterface;
import com.example.a9220l_mercado_libre.Modelo.ProductoResults;
import com.example.a9220l_mercado_libre.Presentador.BuscarPresenter;
import com.example.a9220l_mercado_libre.R;

import java.util.ArrayList;


public class BuscarFragment extends Fragment implements SearchView.OnQueryTextListener, BuscarInterface.Vista {

     private BuscarInterface.Presenter presenter;
    androidx.appcompat.widget.SearchView search;
    private RecyclerView recyclerView;
    private BuscarAdapter buscarAdapter;

    public BuscarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_buscar, container, false);
        recyclerView= root.findViewById(R.id.recyclerBuscar);
        search= root.findViewById(R.id.search);
        search.setOnQueryTextListener(this);
        presenter= new BuscarPresenter(this);
        return root;
    }

    @Override
    public boolean onQueryTextSubmit(String q) {
        enviarBusqueda(q);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void enviarBusqueda(String q) {
        presenter.recibirBusqueda(q);
        search.clearFocus();
    }

    @Override
    public void respuestaExitosa(ArrayList<ProductoResults> productos) {
        buscarAdapter = new BuscarAdapter(productos,getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(buscarAdapter);
        recyclerView.setVisibility(View.VISIBLE);
        System.out.println("DIEGO: Llegaron los productos");

    }
}
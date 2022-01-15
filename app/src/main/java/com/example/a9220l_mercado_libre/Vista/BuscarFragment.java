package com.example.a9220l_mercado_libre.Vista;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a9220l_mercado_libre.Adaptadores.BuscarAdapter;
import com.example.a9220l_mercado_libre.Interfaces.BuscarInterface;
import com.example.a9220l_mercado_libre.Modelo.ProductoResults;
import com.example.a9220l_mercado_libre.Presentador.BuscarPresenter;
import com.example.a9220l_mercado_libre.R;

import java.util.ArrayList;

import static com.example.a9220l_mercado_libre.MainActivity.navigationView;


public class BuscarFragment extends Fragment implements SearchView.OnQueryTextListener, BuscarInterface.Vista {

     private BuscarInterface.Presenter presenter;
    androidx.appcompat.widget.SearchView search;
    private RecyclerView recyclerView;
    private BuscarAdapter buscarAdapter;
    private static ArrayList<ProductoResults> mantenerResultados;
    private LinearLayout linear;
    private FragmentContainerView fragmentContainerViewDetalleProducto;

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
        fragmentContainerViewDetalleProducto = root.findViewById(R.id.fragmentcontainer2);
        search.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                navigationView.setVisibility(View.VISIBLE);
                return false;
            }
        });
        linear = root.findViewById(R.id.l1);
        search.setOnQueryTextListener(this);
        presenter= new BuscarPresenter(this);

        if(mantenerResultados!=null){
            buscarAdapter = new BuscarAdapter(mantenerResultados,getContext());
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
            buscarAdapter.setOnClickListener(view -> {
                DetalleProducto fragment = new DetalleProducto();
                Bundle data = new Bundle();
                data.putString("titulo",mantenerResultados.get(recyclerView.getChildAdapterPosition(view)).getTitle());
                data.putString("precio",mantenerResultados.get(recyclerView.getChildAdapterPosition(view)).getPrice());
                data.putString("condicion",mantenerResultados.get(recyclerView.getChildAdapterPosition(view)).getCondition());
                data.putString("moneda",mantenerResultados.get(recyclerView.getChildAdapterPosition(view)).getCurrency_id());
                data.putString("imagen",mantenerResultados.get(recyclerView.getChildAdapterPosition(view)).getThumbnail());
                fragment.setArguments(data);
                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentcontainer2, fragment)
                        .addToBackStack(null);
                ft.commit();
                fragmentContainerViewDetalleProducto.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            });
            recyclerView.setAdapter(buscarAdapter);
            recyclerView.setVisibility(View.VISIBLE);

        }
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        search.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setVisibility(View.GONE);
            }
        });
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
        mantenerResultados=productos;
        buscarAdapter = new BuscarAdapter(productos,getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        buscarAdapter.setOnClickListener(view -> {
            DetalleProducto fragment = new DetalleProducto();
            Bundle data = new Bundle();
            data.putString("titulo",productos.get(recyclerView.getChildAdapterPosition(view)).getTitle());
            data.putString("precio",productos.get(recyclerView.getChildAdapterPosition(view)).getPrice());
            data.putString("condicion",productos.get(recyclerView.getChildAdapterPosition(view)).getCondition());
            data.putString("moneda",productos.get(recyclerView.getChildAdapterPosition(view)).getCurrency_id());
            data.putString("imagen",productos.get(recyclerView.getChildAdapterPosition(view)).getThumbnail());
            fragment.setArguments(data);
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.replace(R.id.fragmentcontainer2, fragment)
                    .addToBackStack(null);
            ft.commit();
            fragmentContainerViewDetalleProducto.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        });
        recyclerView.setAdapter(buscarAdapter);
        recyclerView.setVisibility(View.VISIBLE);
        navigationView.setVisibility(View.VISIBLE);
        System.out.println("DIEGO: Llegaron los productos");

    }
}
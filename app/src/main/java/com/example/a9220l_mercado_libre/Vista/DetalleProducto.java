package com.example.a9220l_mercado_libre.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.a9220l_mercado_libre.R;

public class DetalleProducto extends Fragment {

    ImageView imagenproducto;
    TextView titulo,precio,estado,moneda;
    Bundle datos;

    public DetalleProducto() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_detalle_producto, container, false);
        imagenproducto= root.findViewById(R.id.imagenProducto);
        datos= getArguments();
        titulo= root.findViewById(R.id.titulodetalles);
        precio= root.findViewById(R.id.preciodetalles);
        estado= root.findViewById(R.id.estadodetalles);
        moneda= root.findViewById(R.id.monedadetalles);
        imagenproducto.setImageResource(datos.getInt("imagen"));
        String imagenObtenida=datos.getString("imagen").replaceFirst("http","https");
        Glide.with(this).load(imagenObtenida).diskCacheStrategy(DiskCacheStrategy.ALL).into(imagenproducto);
        String newestado=datos.getString("condicion");
        if(newestado.equals("new"))
            estado.setText("NUEVO");
        titulo.setText(datos.getString("titulo"));
        precio.setText(datos.getString("precio"));
        moneda.setText(datos.getString("moneda"));

        return root;
    }
}
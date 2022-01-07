package com.example.a9220l_mercado_libre.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.a9220l_mercado_libre.Modelo.ProductoResults;
import com.example.a9220l_mercado_libre.R;

import java.util.ArrayList;

public class BuscarAdapter extends RecyclerView.Adapter<BuscarAdapter.ViewHolderBuscar> {

    private ArrayList<ProductoResults> results;
    private Context context;



    public BuscarAdapter(ArrayList<ProductoResults> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public BuscarAdapter.ViewHolderBuscar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_productos,null,false);
        return new ViewHolderBuscar(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuscarAdapter.ViewHolderBuscar holder, int position) {

        holder.titulo.setText(results.get(position).getTitle());
        holder.precio.setText(results.get(position).getPrice());
        holder.url = results.get(position).getThumbnail().replaceFirst("http","https");

        Glide.with(context).load(holder.url).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.foto);


    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolderBuscar extends RecyclerView.ViewHolder {

        private TextView titulo, precio;
        private ImageView foto;
        private String url;



        public ViewHolderBuscar(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            precio = itemView.findViewById(R.id.price);
            foto = itemView.findViewById(R.id.imagen);

        }
    }
}
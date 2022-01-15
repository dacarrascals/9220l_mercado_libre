package com.example.a9220l_mercado_libre.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a9220l_mercado_libre.Modelo.Sitios;
import com.example.a9220l_mercado_libre.R;

import java.util.ArrayList;
import java.util.List;

public class SitiosAdapter extends RecyclerView.Adapter<SitiosAdapter.ViewHolderSitios> {

    private List<Sitios> sites;
    private Context context;

    public SitiosAdapter(List<Sitios> sites, Context context) {
        this.sites = sites;
        this.context=context;
    }

    @NonNull
    @Override
    public SitiosAdapter.ViewHolderSitios onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_sitios,null,false);
        return new SitiosAdapter.ViewHolderSitios(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SitiosAdapter.ViewHolderSitios holder, int position) {

        holder.nombreSitio.setText(sites.get(position).getName());
        holder.imagenPais.setBackground(sites.get(position).getFoto());
        holder.idPais.setText(sites.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return sites.size();
    }

    public class ViewHolderSitios extends RecyclerView.ViewHolder {

        private TextView nombreSitio, idPais;
        private ImageView imagenPais;


        public ViewHolderSitios(@NonNull View itemView) {
            super(itemView);
            nombreSitio= itemView.findViewById(R.id.nombrepais);
            imagenPais= itemView.findViewById(R.id.imagenpais);
            idPais= itemView.findViewById(R.id.idpais);

        }
    }
}

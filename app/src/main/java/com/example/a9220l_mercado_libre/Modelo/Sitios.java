package com.example.a9220l_mercado_libre.Modelo;


import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Sitios  {

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public Drawable getFoto() {
        return foto;
    }

    public void setFoto(Drawable foto) {
        this.foto = foto;
    }

    private Drawable foto;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

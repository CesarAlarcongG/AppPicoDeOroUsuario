package com.example.apppicodeorousuario.Modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {
    private String nombre;
    private double precio;

    // Constructor, getters, and setters

    public Menu(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    protected Menu(Parcel in) {
        nombre = in.readString();
        precio = in.readDouble();
    }

    public static final Creator<Menu> CREATOR = new Creator<Menu>() {
        @Override
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        @Override
        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeDouble(precio);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

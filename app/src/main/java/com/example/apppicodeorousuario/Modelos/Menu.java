package com.example.apppicodeorousuario.Modelos;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu implements Parcelable {

    private int idMenu;
    private String nombre;
    private int cantidad;
    private double precio;

    // Constructor, getters, and setters
    public Menu(){

    }
    public Menu(int idMenu, String nombre, int cantidad,  double precio) {
        this.idMenu = idMenu;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public Menu( String nombre,  double precio) {

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

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

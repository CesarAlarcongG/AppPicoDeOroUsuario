package com.example.apppicodeorousuario.Modelos;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Parcelable {
    private List<Menu> menu;

    // Constructor, getters, and setters

    public Pedido() {
        this.menu = new ArrayList<>();
    }

    protected Pedido(Parcel in) {
        menu = in.createTypedArrayList(Menu.CREATOR);
    }

    public static final Creator<Pedido> CREATOR = new Creator<Pedido>() {
        @Override
        public Pedido createFromParcel(Parcel in) {
            return new Pedido(in);
        }

        @Override
        public Pedido[] newArray(int size) {
            return new Pedido[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(menu);
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
}

package com.example.apppicodeorousuario.Config;

import android.app.Application;
import com.example.apppicodeorousuario.Modelos.Menu;
import com.example.apppicodeorousuario.Modelos.Mesa;
import com.example.apppicodeorousuario.Modelos.Pedido;

import java.util.List;

public class InstanciasGenerales extends Application {
    private Pedido pedido;
    private Mesa mesa;
    private List<Menu> menu;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public void elimiminarDatosDeIntanciasGenerales(){
        pedido = null;
        mesa = null;
        menu.clear();
        System.gc();
    }
}

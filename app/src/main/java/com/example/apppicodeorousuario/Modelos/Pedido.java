package com.example.apppicodeorousuario.Modelos;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.example.apppicodeorousuario.Config.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Parcelable {

    private int idPedido;
    private int idEstadoPedido;
    private List<Menu> menu;
    private Mesa mesa;

    // Constructor, getters, and setters


    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

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

    public  int getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(int idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }


    //Método que genera un nuevo id-----------------------------------------------------------------------------------------------------------------
    public void generarNuevoId(Pedido pedido){

        try{
            Connection connection = new ConexionBD().getConnection();
            String sql = "SELECT MAX(idPedido) FROM pedidos;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
               pedido.setIdPedido(resultSet.getInt("idPedido") + 1);

            }else{
                pedido.setIdPedido(1);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    //Método que envia todos los datos a la base de datos -----------------------------------------------------------------------------------------
    public void almacenarPedido(Pedido pedido){
        almacenarMenu(pedido);
        try{
            Mesa mesa = pedido.getMesa();

            Connection connection = new ConexionBD().getConnection();
            String sql = "INSERT INTO Pedido (idPedido, idEstadoPedido, idMesa) VALUES (?, ?, ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, pedido.getIdPedido());
            preparedStatement.setInt(2, pedido.getIdEstadoPedido());
            preparedStatement.setInt(3, mesa.getIdMesa());

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void almacenarMenu(Pedido pedido){
        try{
            List<Menu> menu = pedido.getMenu();
            int idPedido = pedido.getIdPedido();

            Connection connection = new ConexionBD().getConnection();
            for (int i = 0; i<menu.size();i++){
                Menu menuEnviar = menu.get(i);

                String sql = "INSERT INTO DetallePedido (idPedido, idMenu, cantidad, costo) VALUES (?, ?, ?, ?, ?);";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setInt(1, idPedido);
                preparedStatement.setInt(2, menuEnviar.getIdMenu());
                preparedStatement.setInt(3, menuEnviar.getCantidad());
                preparedStatement.setDouble(4, menuEnviar.getPrecio());

                ResultSet resultSet = preparedStatement.executeQuery();

                resultSet.close();
                preparedStatement.close();
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //Cancelar Pedido --------------------------------------------------------------------------------------------------
    public Pedido cancelarPedido(Pedido pedido){
        pedido = null;
        return pedido;
    }

}

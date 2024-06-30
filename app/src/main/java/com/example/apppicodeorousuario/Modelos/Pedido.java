package com.example.apppicodeorousuario.Modelos;


import com.example.apppicodeorousuario.Config.ConexionBD;

import java.sql.*;
import java.time.LocalDateTime;


public class Pedido {

    private int idPedido;
    /*Estados
    * 1. NuevoPedido
    * 2. Cocinandoce
    * 3. Entregado
    * 4. Pagado
    * 5. Cancelado
    * */
    private int idEstadoPedido;
    private LocalDateTime fechaHoraInicio;
    private int idMesa;


    // Getters y setters---------------------------------------------------------------------
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(int idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

//Pantalla1***********************************************************************************************************

    //Método que genera un nuevo Pedido
    public void iniciarPedido(){
        generarNuevoId();
        try{
            //Obtenemos la fecha y hora exacta
            LocalDateTime fechaHora1 = LocalDateTime.now();
            String fechaHora = String.valueOf(fechaHora1);

            Connection connection = new ConexionBD().getConnection();
            String sql = "INSERT INTO Pedido (idPedido, idEstadoPedido, fecha_hora) VALUES (?, ?, ?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, idPedido);
            preparedStatement.setInt(2, 1);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(fechaHora) );


            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void generarNuevoId(){

        try{
            Connection connection = new ConexionBD().getConnection();
            String sql = "SELECT MAX(idPedido) FROM pedidos;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
               idPedido = resultSet.getInt("idPedido") + 1;

            }else{
                idPedido=1;
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



//Pantalla4***********************************************************************************************************
    public void cancelarPedido() {
        try{
            Connection connection = new ConexionBD().getConnection();
            String sql = "UPDATE Pedido SET idEstadoPedido = ? WHERE idPedido = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 5);
            preparedStatement.setInt(2, idPedido);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}

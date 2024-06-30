package com.example.apppicodeorousuario.Modelos;

import com.example.apppicodeorousuario.Config.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mesa {
    private  int idMesa;
    /*
    * 0. false - no disponible
    * 1. verdaro - estadisponible
    * */
    private int esatadoMesa;

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getEsatadoMesa() {
        return esatadoMesa;
    }

    public void setEsatadoMesa(int esatadoMesa) {
        this.esatadoMesa = esatadoMesa;
    }

    public List<Mesa> listadoDeMEsasDisponibles(){

    }

    public void actualizarEstadoMesa(int idMesa){
        try{
            Connection connection = new ConexionBD().getConnection();
            String sql = "UPDATE Mesa SET idEstadoMesa = ? WHERE idMesa = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, idMesa);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}

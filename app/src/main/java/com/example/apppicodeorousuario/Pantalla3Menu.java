package com.example.apppicodeorousuario;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.apppicodeorousuario.Modelos.Pedido;

public class Pantalla3Menu extends AppCompatActivity {
    Pedido pedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3_menu);
        pedido = getIntent().getParcelableExtra("pedido");
    }
}
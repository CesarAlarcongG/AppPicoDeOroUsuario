package com.example.apppicodeorousuario;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.apppicodeorousuario.Modelos.Pedido;

public class Pantalla2Mesas extends AppCompatActivity {
    Pedido pedido;
   // Button btnMesa1, btnMesa2, btnMesa3, btnMesa4, btnMesa5, btnMesa6, btnMesa7, btnMesa8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2_mesas);
        //pedido = getIntent().getParcelableExtra("pedido");
    }

}
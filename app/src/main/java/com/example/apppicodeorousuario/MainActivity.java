package com.example.apppicodeorousuario;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.apppicodeorousuario.Modelos.Menu;
import com.example.apppicodeorousuario.Modelos.Pedido;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Button iniciarPedido;
    private Pedido pedido;
    private List<Menu> menus = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarPedido = findViewById(R.id.btnIniciarPedido);

        pedido = new Pedido();

        iniciarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //generamos unid
                pedido.generarNuevoId(pedido);

                Intent intent = new Intent(MainActivity.this, Pantalla2Mesas.class);
                intent.putExtra("pedido", pedido);
                startActivity(intent);

            }
        });
    }

}
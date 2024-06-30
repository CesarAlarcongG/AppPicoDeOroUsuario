package com.example.apppicodeorousuario;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.apppicodeorousuario.Config.InstanciasGenerales;
import com.example.apppicodeorousuario.Modelos.Menu;
import com.example.apppicodeorousuario.Modelos.Mesa;
import com.example.apppicodeorousuario.Modelos.Pedido;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Button iniciarPedido;
    private Pedido pedido = new Pedido();
    private Mesa mesa = new Mesa();
    private List<Menu> menu = new ArrayList<Menu>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarPedido = findViewById(R.id.btnIniciarPedido);



        iniciarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Iniciamos datos idPedido = max+1 y estadoPedido = 1
                pedido.iniciarPedido();

                //---
                menu.add(new Menu("Pollo a la braza", 40));
                menu.add(new Menu("Braza", 70.78));
                //Hacemos que la instancia pedido sea una instancia general (todas las clases pueden usarlo)
                InstanciasGenerales instancia = (InstanciasGenerales) getApplicationContext();
                instancia.setPedido(pedido);
                instancia.setMenu(menu);
                instancia.setMesa(mesa);

                //Se pasa a la siguiente pantalla de mesas
                Intent intent = new Intent(MainActivity.this, Pantalla4Envio.class);
                startActivity(intent);

            }
        });
    }

}
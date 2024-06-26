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
                menus.clear();

                menus.add(new Menu("Pollo a la brasa", 18));
                menus.add(new Menu("Tallarines verdes", 15));
                menus.add(new Menu("Ceviche", 20));
                menus.add(new Menu("Arroz con mariscos", 25));
                menus.add(new Menu("Lomo saltado", 22));
                menus.add(new Menu("Ají de gallina", 18));
                menus.add(new Menu("Pachamanca", 40));
                menus.add(new Menu("Seco de cordero", 35));
                menus.add(new Menu("Chaufa de pollo", 16));
                menus.add(new Menu("Causa rellena", 14));
                pedido.setMenu(menus);

                Intent intent = new Intent(MainActivity.this, Pantalla4Envio.class);
                intent.putExtra("pedido", pedido);
                startActivity(intent);
            }
        });
    }

}
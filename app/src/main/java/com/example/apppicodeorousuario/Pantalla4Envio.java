package com.example.apppicodeorousuario;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.apppicodeorousuario.Config.AdaptadorVistaMenu;
import com.example.apppicodeorousuario.Config.InstanciasGenerales;
import com.example.apppicodeorousuario.Modelos.Menu;
import com.example.apppicodeorousuario.Modelos.Pedido;
import java.util.List;

public class Pantalla4Envio extends AppCompatActivity {

    AdaptadorVistaMenu adaptadorVistaMenu;
    InstanciasGenerales instanciasGenerales;
    Pedido pedido;
    List<Menu> menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla4_envio);

        instanciasGenerales = (InstanciasGenerales) getApplicationContext();
        pedido = instanciasGenerales.getPedido();
        menu = instanciasGenerales.getMenu();

        if (menu != null) {
            ListView listView = findViewById(R.id.lvMenu);
            adaptadorVistaMenu = new AdaptadorVistaMenu(this, menu);
            listView.setAdapter(adaptadorVistaMenu);
        } else {
            System.out.println("Error en la lista de menus");
        }

        // Configurar el botón Agregar para añadir elementos (si es necesario)
        Button btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(v -> {
            finish(); //Actualiza la actividad de esta pantalla y vulve a la anterior
        });

        //Cuando se precione el boton Enviar se enviará todos los datos que se almaceno en el objeto pedido directo a la Base de datos-------------------------------
        Button btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(v -> {


        });

        // Configurar el botón Cancelar para cancelar la operación (si es necesario)
        Button btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(v -> {
            //Actualizamos dato de estado pedido por 5 -> Cancelado
            pedido.cancelarPedido();
            //Eliminamos datos de las instancias y liberamos espacio de memoria
            instanciasGenerales.elimiminarDatosDeIntanciasGenerales();
            //Notificar cambios en las instancias y actualizar
            adaptadorVistaMenu.notifyDataSetChanged();
            //finish(); // Finaliza la actividad actual y vuelve a la anterior
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Actualizar la lista de menús en caso de que haya cambiado
        menu = instanciasGenerales.getMenu();
        if (menu != null && adaptadorVistaMenu != null) {
            adaptadorVistaMenu.notifyDataSetChanged();
        }
    }
}

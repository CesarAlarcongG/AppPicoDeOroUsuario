package com.example.apppicodeorousuario;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.apppicodeorousuario.Config.AdaptadorVistaMenu;
import com.example.apppicodeorousuario.Modelos.Menu;
import com.example.apppicodeorousuario.Modelos.Pedido;
import java.util.List;

public class Pantalla4Envio extends AppCompatActivity {
    Pedido pedido;
    List<Menu> listaMenu;
    AdaptadorVistaMenu adaptadorVistaMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla4_envio);

        // Obtener el pedido enviado desde MainActivity
        pedido = getIntent().getParcelableExtra("pedido");

        // Validar que el pedido y la lista de menús no sean nulos
        if (pedido != null) {
            listaMenu = pedido.getMenu();

            // Validar que la lista de menús no sea nula antes de proceder
            if (listaMenu != null) {
                ListView listView = findViewById(R.id.lvMenu);
                adaptadorVistaMenu = new AdaptadorVistaMenu(this, listaMenu);
                listView.setAdapter(adaptadorVistaMenu);
            }
        }

        // Configurar el botón Agregar para añadir elementos (si es necesario)
        Button btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(v -> {
            // Aquí puedes implementar la lógica para agregar nuevos elementos a la lista
            // Puedes abrir otra actividad o fragmento para agregar nuevos elementos
        });

        // Configurar el botón Enviar para enviar el pedido (si es necesario)
        Button btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(v -> {
            // Aquí puedes implementar la lógica para enviar el pedido
            // Por ejemplo, enviar datos a través de una API o realizar alguna acción final
        });

        // Configurar el botón Cancelar para cancelar la operación (si es necesario)
        Button btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(v -> {
            // Aquí puedes implementar la lógica para cancelar y volver atrás
            finish(); // Finaliza la actividad actual y vuelve a la anterior
        });
    }
}

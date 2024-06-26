package com.example.apppicodeorousuario.Config;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.apppicodeorousuario.Modelos.Menu;
import com.example.apppicodeorousuario.R;

import java.util.List;

public class AdaptadorVistaMenu extends ArrayAdapter<Menu> {

    private Context context;
    private List<Menu> listaMenu;

    public AdaptadorVistaMenu(Context context, List<Menu> listaMenu) {
        super(context, 0, listaMenu);
        this.context = context;
        this.listaMenu = listaMenu;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.pantalla4_elementos, parent, false);
        }

        TextView tvNombreMenu = convertView.findViewById(R.id.tvNombreMenu);
        TextView tvPrecioMenu = convertView.findViewById(R.id.tvPrecioMenu);
        Button btnEliminarMenu = convertView.findViewById(R.id.btnEliminarMenu);

        final Menu menu = listaMenu.get(position);
        tvNombreMenu.setText(menu.getNombre());
        tvPrecioMenu.setText(String.valueOf(menu.getPrecio()));

        btnEliminarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaMenu.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}


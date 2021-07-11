package com.uninassau.bilu_bilu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


import com.uninassau.bilu_bilu.R;
import com.uninassau.bilu_bilu.banco.BancoControlador;
import com.uninassau.bilu_bilu.banco.CriaBanco;

import static com.uninassau.bilu_bilu.R.layout.activity_dados;

public class Dados extends AppCompat {

    private ListView listaConsulta;
    BancoControlador bd;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_dados);

        bd = new BancoControlador(Dados.this);
        cursor = bd.carregaDados();

        String[] nomeCampos = new String[] {CriaBanco.ID, CriaBanco.NOME};
        int[] idViews = new int[] {R.id.txtId, R.id.txt_nome};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(Dados.this, R.layout.activity_dados, cursor, nomeCampos, idViews, 0);
        listaConsulta = findViewById(R.id.listView);
        listaConsulta.setAdapter(adaptador);

        listaConsulta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndex(CriaBanco.ID));
                Intent intent = new Intent(Dados.this, apagar.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}


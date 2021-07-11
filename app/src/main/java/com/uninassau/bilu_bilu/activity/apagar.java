package com.uninassau.bilu_bilu.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.uninassau.bilu_bilu.R;
import com.uninassau.bilu_bilu.banco.BancoControlador;
import com.uninassau.bilu_bilu.banco.CriaBanco;

public class apagar extends AppCompat {

    private EditText edNome;
    private Button btnApagar, btnAlterar;
    private Cursor cursor;
    private BancoControlador bd;
    private String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apagar);

        Intent it = getIntent();
        codigo = it.getStringExtra("codigo");
        bd = new BancoControlador(apagar.this);

        edNome = findViewById(R.id.edNome);
        btnAlterar = findViewById(R.id.btnAlterar);
        btnApagar = findViewById(R.id.btnApagar);

        cursor = bd.carregaDadoById(Integer.parseInt(codigo));
        edNome.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.NOME)));

        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = edNome.getText().toString();
                bd.alteraRegistro(Integer.parseInt(codigo), nome);
                Intent it = new Intent(apagar.this, Dados.class);
                startActivity(it);
                finish();
            }
        });

        btnApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.deletaRegistro(Integer.parseInt(codigo));
                Intent it = new Intent(apagar.this, Dados.class);
                startActivity(it);
                finish();
            }
        });

    }
}
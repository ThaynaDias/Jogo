package com.uninassau.bilu_bilu.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.uninassau.bilu_bilu.R;
import com.uninassau.bilu_bilu.banco.BancoControlador;

public class Jogadores extends AppCompat {

    private Button imgVoltar2;
    private Button btnEntrar2;
    private EditText edNome1;
    private BancoControlador bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadores);

        bd = new BancoControlador(Jogadores.this);
        imgVoltar2 = findViewById(R.id.btnVoltar6);
        btnEntrar2 = findViewById(R.id.btnEntrar6);
        edNome1 = findViewById(R.id.edNome1);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.gota);
        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.bolha);


        btnEntrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validaCampos()) {
                    String nome = edNome1.getText().toString();
                    String msg = bd.inserir(nome);
                    LimparCampo();
                    Intent it = new Intent(Jogadores.this, Jogadores1.class); // comando para ir para outra tela
                    startActivity(it);
                    finish();
                    mp1.start();

                }
            }
        });


        imgVoltar2.setOnClickListener(new View.OnClickListener() { // a imagem irá voltar para tela de menu
            @Override
            public void onClick(View v) {
                onBackPressed(); mp.start(); // comando que irá voltar
            }
        });
    }

        private boolean validaCampos(){ // irá verificar se o campo está vázio

            boolean res = true;

            String nome = edNome1.getText().toString();

            if(nome.isEmpty()) { //verificar se os nomes estão vazio
                edNome1.setError(getResources().getString(R.string.campo)); // mensagem que irá aparecer
                res = false;
            }
            return res;
        }

    private void LimparCampo(){
        edNome1.setText("");
        edNome1.requestFocus();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        /* Ativa o modo imersivo regular.
         Para o modo "inclinar para trás", remova SYSTEM_UI_FLAG_IMMERSIVE.
         Ou para "aderência imersiva", substitua por SYSTEM_UI_FLAG_IMMERSIVE_STICKY*/
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        /* Defina o conteúdo para aparecer nas barras do sistema para que o
                         o conteúdo não é redimensionado quando as barras do sistema são ocultadas e exibidas.*/
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Oculta a barra de navegação e a barra de status
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    /* Mostra as barras do sistema removendo todos os sinalizadores
    exceto para aqueles que fazem o conteúdo aparecer nas barras do sistema.*/
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}

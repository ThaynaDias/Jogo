package com.uninassau.bilu_bilu.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uninassau.bilu_bilu.R;

public class Opções extends AppCompat {

    private Button btnDados, btnVoltar3, btnIdioma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes);

        btnVoltar3 = findViewById(R.id.btnVoltar6);
        btnIdioma = findViewById(R.id.btnIdioma);
        btnDados = findViewById(R.id.btnDados);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.gota);
        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.bolha);

        btnIdioma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Opções.this, Idiomas.class);
                startActivity(it);
                finish();
                mp1.start();
            }
        });

        btnDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Opções.this, Dados.class);
                startActivity(it);
                finish();
                mp1.start();
            }
        });

        btnVoltar3.setOnClickListener(new View.OnClickListener() { // a imagem irá voltar para tela de menu
            @Override
            public void onClick(View v) {
                onBackPressed();
                mp.start();// comando que irá voltar
            }
        });
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


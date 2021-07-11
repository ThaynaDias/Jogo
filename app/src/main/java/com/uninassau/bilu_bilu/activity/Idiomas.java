package com.uninassau.bilu_bilu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.uninassau.bilu_bilu.R;

public class Idiomas extends AppCompat {

    private Button btn_pt, btn_en, btn_es, btn_fr, btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idiomas);

        btn_pt = findViewById(R.id.btn_pt);
        btn_en = findViewById(R.id.btn_en);
        btn_es = findViewById(R.id.btn_es);
        btn_fr = findViewById(R.id.btn_fr);
        btn_voltar = findViewById(R.id.btnVoltar);
        IdiomaManager lang = new IdiomaManager(this);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.gota);
        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.bolha);

        btn_pt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent( Idiomas.this, MainActivity.class);
                lang.updateResources("pt");
                recreate();
                finish();
                startActivity(it);
                mp1.start();
            }
        });

        btn_en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent( Idiomas.this, MainActivity.class);
                lang.updateResources("en");
                recreate();
                finish();
                startActivity(it);
               mp1.start();
            }
        });
        btn_es.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent( Idiomas.this, MainActivity.class);
                lang.updateResources("es");
                recreate();
                finish();
                startActivity(it);
                mp1.start();
            }
        });
        btn_fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent( Idiomas.this, MainActivity.class);
                lang.updateResources("fr");
                recreate();
                finish();
                startActivity(it);
                mp1.start();
            }
        });

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                mp.start();
            }
        });
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

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
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
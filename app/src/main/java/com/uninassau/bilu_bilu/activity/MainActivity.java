package com.uninassau.bilu_bilu.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.uninassau.bilu_bilu.R;

public class MainActivity extends AppCompat {

    private Button btnjogar, btnjogadores, btnOpcoes, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnjogar = findViewById(R.id.btnJogar);
        btnjogadores = findViewById(R.id.btnJogadores);
        btnOpcoes = findViewById(R.id.btnOpcoes);
        btnSair = findViewById(R.id.btnSair);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.bolha);
        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.saida);

        btnjogar.setOnClickListener(new View.OnClickListener() { //  login de 1 jogador
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Jogador.class); // comando para ir para outra tela
                startActivity(it);
                mp.start();
            }
        });

        btnjogadores.setOnClickListener(new View.OnClickListener() { // login de jogadores
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Jogadores.class);
                startActivity(it);
                mp.start();
            }
        });

        btnOpcoes.setOnClickListener(new View.OnClickListener() { // tela opções
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Opções.class);
                startActivity(it);
                mp.start();
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                mp1.start();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.layout_dialogo, (ConstraintLayout) findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.dialogo_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.text));
        ((Button) view.findViewById(R.id.buttonYes)).setText(getResources().getString(R.string.sim));
        ((Button) view.findViewById(R.id.buttonNo)).setText(getResources().getString(R.string.nao));
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.autisto);

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                System.exit(0);
                finish();
            }
        });

        view.findViewById(R.id.buttonNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
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
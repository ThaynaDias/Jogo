package com.uninassau.bilu_bilu.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.uninassau.bilu_bilu.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class telaJogador extends AppCompat {

    private ImageView imageView1, imageView2, imageView3, imageView4, imageMain;
    private TextView txt_status;
    private Button btn;
    private Button btnVoltar5;

    // lista de imagens coloridas
    Integer[] imagens = {
            R.drawable.borboleta_colorida_brilho,
            R.drawable.coracao_colorido_brilho,
            R.drawable.coroa_colorida_brilho,
            R.drawable.estrela_colorida_brilho,
            R.drawable.guardachuva_colorido_brilho,
            R.drawable.lua_colorida_brilho,
            R.drawable.mao_colorida_brilho,
            R.drawable.pata_colorida_brilho,

    };

    // lista de imagens em preto e branco

    Integer[] imagens_sombras = {
            R.drawable.borboleta_sombra,
            R.drawable.coracao_sombra,
            R.drawable.coroa_sombra,
            R.drawable.estrela_sombra,
            R.drawable.guardachuva_sombra,
            R.drawable.lua_sombra,
            R.drawable.mao_sombra,
            R.drawable.pata_sombra,
    };

    // lista de números para todas as imagens / atualmente 8 imagens
    Integer[] imagens_numeros = {0,1,2,3,4,5,6,7};
    int jogada = 1;
    int respostaCorreta = 0;
    int ponto = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_jogador);

        btnVoltar5 = findViewById(R.id.btnVoltar6);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageMain = findViewById(R.id.imageMain);
        txt_status = findViewById(R.id.txt_Status);
        btn = findViewById(R.id.btn);

        MediaPlayer mp1 = MediaPlayer.create(this, R.raw.bolha);
        MediaPlayer mp2 = MediaPlayer.create(this, R.raw.gota);

        // embaralhar as imagens aleatoriamente
        Collections.shuffle(Arrays.asList(imagens_numeros));

        // definir imagens na tela
        setImagens();

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // verifique se está correto ou errado

                if(respostaCorreta == 1){
                    ponto++;
                    txt_status.setText(getResources().getString(R.string.correta));
                    txt_status.setTextColor(getResources().getColor(R.color.green));
                    btn.setVisibility(View.VISIBLE);
                    mp1.start();

                } else {
                    txt_status.setText(getResources().getString(R.string.errada));
                    txt_status.setTextColor(getResources().getColor(R.color.red));
                    btn.setVisibility(View.VISIBLE);
                    mp1.start();
                }

                // desativar imagens

                imageView1.setEnabled(false);
                imageView2.setEnabled(false);
                imageView3.setEnabled(false);
                imageView4.setEnabled(false);

            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // verifique se está correto ou errado

                if(respostaCorreta == 2){
                    ponto++;
                    txt_status.setText(getResources().getString(R.string.correta));
                    txt_status.setTextColor(getResources().getColor(R.color.green));
                    btn.setVisibility(View.VISIBLE);
                    mp1.start();

                } else {
                    txt_status.setText(getResources().getString(R.string.errada));
                    txt_status.setTextColor(getResources().getColor(R.color.red));
                    btn.setVisibility(View.VISIBLE);
                    mp1.start();
                }

                // desativar imagens

                imageView1.setEnabled(false);
                imageView2.setEnabled(false);
                imageView3.setEnabled(false);
                imageView4.setEnabled(false);

            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // verifique se está correto ou errado

                if(respostaCorreta == 3){
                    ponto++;
                    txt_status.setText(getResources().getString(R.string.correta));
                    txt_status.setTextColor(getResources().getColor(R.color.green));
                    btn.setVisibility(View.VISIBLE);
                    mp1.start();

                } else {
                    txt_status.setText(getResources().getString(R.string.errada));
                    txt_status.setTextColor(getResources().getColor(R.color.red));
                    btn.setVisibility(View.VISIBLE);
                    mp1.start();
                }

                mp1.start();

                // desativar imagens

                imageView1.setEnabled(false);
                imageView2.setEnabled(false);
                imageView3.setEnabled(false);
                imageView4.setEnabled(false);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // verifique se está correto ou errado

                if(respostaCorreta == 4){
                    ponto++;
                    txt_status.setText(getResources().getString(R.string.correta));
                    txt_status.setTextColor(getResources().getColor(R.color.green));
                    btn.setVisibility(View.VISIBLE);
                    mp1.start();

                } else {
                    txt_status.setText(getResources().getString(R.string.errada));
                    txt_status.setTextColor(getResources().getColor(R.color.red));
                    btn.setVisibility(View.VISIBLE);
                    mp1.start();
                }

                // desativar imagens

                imageView1.setEnabled(false);
                imageView2.setEnabled(false);
                imageView3.setEnabled(false);
                imageView4.setEnabled(false);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //aumentar a jogada e termina o jogo em 8 jogada

                jogada++;
                if (jogada == 8){
                    checkEnd();
                } else {
                    setImagens();
                }
                mp2.start();
            }
        });



        btnVoltar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(telaJogador.this, MainActivity.class); // comando para ir para outra tela
                startActivity(it);
                finish();
                mp2.start();
            }
        });
    }

    private void setImagens(){
        // determine qual é a resposta correta 1-4
        Random r = new Random();
        respostaCorreta = r.nextInt(4) + 1;

        // gera respostas erradas aleatórias
        int RespostaErrada1 , RespostaErrada2 , RespostaErrada3;

        do{
            RespostaErrada1  = r.nextInt(8);
        } while (RespostaErrada1  == imagens_numeros[jogada]);

        do{
            RespostaErrada2  = r.nextInt(8);
        } while (RespostaErrada2  == imagens_numeros[jogada]  || RespostaErrada2  == RespostaErrada1  );

        do{
            RespostaErrada3 = r.nextInt(8);
        } while (RespostaErrada3 == imagens_numeros[jogada] || RespostaErrada3 == RespostaErrada2  || RespostaErrada3 == RespostaErrada1  );

        switch(respostaCorreta){
            case 1:
                imageView1.setImageResource(imagens[imagens_numeros[jogada]]);
                imageView2.setImageResource(imagens[RespostaErrada1 ]);
                imageView3.setImageResource(imagens[RespostaErrada2 ]);
                imageView4.setImageResource(imagens[RespostaErrada3]);
                break;

            case 2:
                imageView1.setImageResource(imagens[RespostaErrada1 ]);
                imageView2.setImageResource(imagens[imagens_numeros[jogada]]);
                imageView3.setImageResource(imagens[RespostaErrada2 ]);
                imageView4.setImageResource(imagens[RespostaErrada3]);
                break;

            case 3:
                imageView1.setImageResource(imagens[RespostaErrada1 ]);
                imageView2.setImageResource(imagens[RespostaErrada2 ]);
                imageView3.setImageResource(imagens[imagens_numeros[jogada]]);
                imageView4.setImageResource(imagens[RespostaErrada3]);
                break;

            case 4:
                imageView1.setImageResource(imagens[RespostaErrada1 ]);
                imageView2.setImageResource(imagens[RespostaErrada2 ]);
                imageView3.setImageResource(imagens[RespostaErrada3]);
                imageView4.setImageResource(imagens[imagens_numeros[jogada]]);

                break;
        }

        // definir imagem para a questão
        imageMain.setImageResource(imagens_sombras[imagens_numeros[jogada]]);

        txt_status.setText("");
        btn.setVisibility(View.INVISIBLE);

        imageView1.setEnabled(true);
        imageView2.setEnabled(true);
        imageView3.setEnabled(true);
        imageView4.setEnabled(true);
    }

    private void checkEnd(){

            AlertDialog.Builder builder = new AlertDialog.Builder(telaJogador.this, R.style.AlertDialogTheme);
            View view = LayoutInflater.from(telaJogador.this).inflate(
                    R.layout.layout_dialogo,(ConstraintLayout) findViewById(R.id.layoutDialogContainer)
            );
            builder.setView(view);
            ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.dialogo_jogo_title));
            ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.text_pontos) + ponto);
            ((Button) view.findViewById(R.id.buttonYes)).setText(getResources().getString(R.string.jogar_novamente));
            ((Button) view.findViewById(R.id.buttonNo)).setText(getResources().getString(R.string.sair));
            ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.autisto);

            final AlertDialog alertDialog = builder.create();

            view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                    Intent it = new Intent(getApplicationContext(), telaJogador.class);
                    startActivity(it);
                    finish();
                }
            });

            view.findViewById(R.id.buttonNo).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                    Intent it = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(it);
                    finish();

                }
            });

            if(alertDialog.getWindow() != null){
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }
            alertDialog.show();
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
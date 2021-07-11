package com.uninassau.bilu_bilu.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.uninassau.bilu_bilu.R;

import java.util.Arrays;
import java.util.Collections;

public class telaJogadores extends AppCompat {
    private Button btnVoltar5;
    private TextView txt_p1, txt_p2;
    private ImageView iv11, iv12, iv13, iv14, iv21, iv22, iv23, iv24, iv31, iv32, iv33, iv34;

    // array para as imagens
    Integer[] Cartas_Array = {101, 102, 103, 104, 105, 106, 201, 202, 203, 204, 205, 206};

    // imagens reais
    int image101, image102, image103, image104, image105, image106,image201, image202, image203, image204, image205, image206;

    int primeira_carta, segunda_carta, primeira_clicada, segunda_clicada, numero_do_cartão = 1, jogada = 1, pontos_de_jogador1 = 0, pontos_de_jogador2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_jogadores);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.gota);
        btnVoltar5 = findViewById(R.id.btnVoltar6); txt_p1 = findViewById(R.id.txt_p1);
        txt_p2 = findViewById(R.id.txt_p2);

        iv11 = findViewById(R.id.iv11);
        iv12 = findViewById(R.id.iv12);
        iv13 = findViewById(R.id.iv13);
        iv14 = findViewById(R.id.iv14);
        iv21 = findViewById(R.id.iv21);
        iv22 = findViewById(R.id.iv22);
        iv23 = findViewById(R.id.iv23);
        iv24 = findViewById(R.id.iv24);
        iv31 = findViewById(R.id.iv31);
        iv32 = findViewById(R.id.iv32);
        iv33 = findViewById(R.id.iv33);
        iv34 = findViewById(R.id.iv34);

        iv11.setTag("0");
        iv12.setTag("1");
        iv13.setTag("2");
        iv14.setTag("3");
        iv21.setTag("4");
        iv22.setTag("5");
        iv23.setTag("6");
        iv24.setTag("7");
        iv31.setTag("8");
        iv32.setTag("9");
        iv33.setTag("10");
        iv34.setTag("11");

        // carrega as imagens do cartão
        Recursos_da_frente_dos_cartões();

        // Mistura as imagens
        Collections.shuffle(Arrays.asList(Cartas_Array));

        // mudando a cor do segundo jogador (inativo)
        txt_p2.setTextColor(Color.GRAY);

        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                fazerJogada(iv11, theCard);
                mp.start();

            }
        });

        iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                fazerJogada(iv12, theCard);
                mp.start();
            }
        });

        iv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                fazerJogada(iv13, theCard);
                mp.start();
            }
        });

        iv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                fazerJogada(iv14, theCard);
                mp.start();
            }
        });

        iv21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                fazerJogada(iv21, theCard);
                mp.start();
            }
        });
        iv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                fazerJogada(iv22, theCard);
                mp.start();
            }
        });

        iv23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                fazerJogada(iv23, theCard);
                mp.start();
            }
        });

        iv24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                fazerJogada(iv24, theCard);
                mp.start();
            }
        });

        iv31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                fazerJogada(iv31, theCard);
                mp.start();
            }
        });

        iv32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                fazerJogada(iv32, theCard);
                mp.start();
            }
        });

        iv33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                fazerJogada(iv33, theCard);
                mp.start();
            }
        });

        iv34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                fazerJogada(iv34, theCard);
                mp.start();
            }
        });

        btnVoltar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(telaJogadores.this, MainActivity.class); // comando para ir para outra tela
                startActivity(it);
                finish();
                mp.start();
            }
        });
    }

    private void fazerJogada(ImageView iv, int card){
        // defina a imagem correta para o imageView
        if (Cartas_Array[card] == 101){
            iv.setImageResource(image101);
        } else if (Cartas_Array[card] == 102){
            iv.setImageResource(image102);
        } else if (Cartas_Array[card] == 103){
            iv.setImageResource(image103);
        } else if (Cartas_Array[card] == 104){
            iv.setImageResource(image104);
        } else if (Cartas_Array[card] == 105){
            iv.setImageResource(image105);
        } else if (Cartas_Array[card] == 106){
            iv.setImageResource(image106);
        } else if (Cartas_Array[card] == 201){
            iv.setImageResource(image201);
        } else if (Cartas_Array[card] == 202){
            iv.setImageResource(image202);
        } else if (Cartas_Array[card] == 203){
            iv.setImageResource(image203);
        } else if (Cartas_Array[card] == 204){
            iv.setImageResource(image204);
        } else if (Cartas_Array[card] == 205){
            iv.setImageResource(image205);
        } else if (Cartas_Array[card] == 206){
            iv.setImageResource(image206);
        }

        // verifique se está selecionado e salve-o na variável temporária
        if (numero_do_cartão == 1) {
            primeira_carta = Cartas_Array[card];
            if(primeira_carta > 200){
                primeira_carta = primeira_carta - 100;
            }
            numero_do_cartão = 2;
            primeira_clicada = card;

            iv.setEnabled(false);
        } else if(numero_do_cartão == 2) {
            segunda_carta = Cartas_Array[card];

            if (segunda_carta > 200) {
                segunda_carta = segunda_carta - 100;
            }
            numero_do_cartão = 1;
            segunda_clicada = card;

            iv11.setEnabled(false);
            iv12.setEnabled(false);
            iv13.setEnabled(false);
            iv14.setEnabled(false);
            iv21.setEnabled(false);
            iv22.setEnabled(false);
            iv23.setEnabled(false);
            iv24.setEnabled(false);
            iv31.setEnabled(false);
            iv32.setEnabled(false);
            iv33.setEnabled(false);
            iv34.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // verifique se as imagens selecionadas são iguais
                    calcular_jogadas();
                }
            },1000);
        }
    }

    private void calcular_jogadas(){
        // se as imagens forem iguais, remova-as e adicione pontos
        if(primeira_carta == segunda_carta){
            if(primeira_clicada == 0){
                iv11.setVisibility(View.INVISIBLE);
            } else if(primeira_clicada == 1){
                iv12.setVisibility(View.INVISIBLE);
            } else if(primeira_clicada == 2){
                iv13.setVisibility(View.INVISIBLE);
            } else if(primeira_clicada == 3){
                iv14.setVisibility(View.INVISIBLE);
            } else if(primeira_clicada == 4){
                iv21.setVisibility(View.INVISIBLE);
            } else if(primeira_clicada == 5){
                iv22.setVisibility(View.INVISIBLE);
            } else if(primeira_clicada == 6){
                iv23.setVisibility(View.INVISIBLE);
            } else if(primeira_clicada == 7){
                iv24.setVisibility(View.INVISIBLE);
            } else if(primeira_clicada == 8){
                iv31.setVisibility(View.INVISIBLE);
            } else if(primeira_clicada == 9){
                iv32.setVisibility(View.INVISIBLE);
            } else if(primeira_clicada == 10){
                iv33.setVisibility(View.INVISIBLE);
            } else if(primeira_clicada == 11){
                iv34.setVisibility(View.INVISIBLE);
            }

            if(segunda_clicada == 0){
                iv11.setVisibility(View.INVISIBLE);
            } else if(segunda_clicada == 1){
                iv12.setVisibility(View.INVISIBLE);
            } else if(segunda_clicada == 2){
                iv13.setVisibility(View.INVISIBLE);
            } else if(segunda_clicada == 3){
                iv14.setVisibility(View.INVISIBLE);
            } else if(segunda_clicada == 4){
                iv21.setVisibility(View.INVISIBLE);
            } else if(segunda_clicada == 5){
                iv22.setVisibility(View.INVISIBLE);
            } else if(segunda_clicada == 6){
                iv23.setVisibility(View.INVISIBLE);
            } else if(segunda_clicada == 7){
                iv24.setVisibility(View.INVISIBLE);
            } else if(segunda_clicada == 8){
                iv31.setVisibility(View.INVISIBLE);
            } else if(segunda_clicada == 9){
                iv32.setVisibility(View.INVISIBLE);
            } else if(segunda_clicada == 10){
                iv33.setVisibility(View.INVISIBLE);
            } else if(segunda_clicada == 11){
                iv34.setVisibility(View.INVISIBLE);
            }

            // adiciona pontos para o jogador correto
            if(jogada == 1){
                pontos_de_jogador1++;
                txt_p1.setText("P1: " + pontos_de_jogador1);

            } else if(jogada == 2) {
                pontos_de_jogador2++;
                txt_p2.setText("P2: " + pontos_de_jogador2);
            }
        } else {

            iv11.setImageResource(R.drawable.ic_black);
            iv12.setImageResource(R.drawable.ic_black);
            iv13.setImageResource(R.drawable.ic_black);
            iv14.setImageResource(R.drawable.ic_black);
            iv21.setImageResource(R.drawable.ic_black);
            iv22.setImageResource(R.drawable.ic_black);
            iv23.setImageResource(R.drawable.ic_black);
            iv24.setImageResource(R.drawable.ic_black);
            iv31.setImageResource(R.drawable.ic_black);
            iv32.setImageResource(R.drawable.ic_black);
            iv33.setImageResource(R.drawable.ic_black);
            iv34.setImageResource(R.drawable.ic_black);

            // muda a vez do jogador
            if(jogada == 1){
                jogada = 2;
                txt_p1.setTextColor(Color.GRAY);
                txt_p2.setTextColor(Color.BLACK);

            } else if(jogada == 2) {
                jogada = 1;
                txt_p2.setTextColor(Color.GRAY);
                txt_p1.setTextColor(Color.BLACK);
            }
        }
        iv11.setEnabled(true);
        iv12.setEnabled(true);
        iv13.setEnabled(true);
        iv14.setEnabled(true);
        iv21.setEnabled(true);
        iv22.setEnabled(true);
        iv23.setEnabled(true);
        iv24.setEnabled(true);
        iv31.setEnabled(true);
        iv32.setEnabled(true);
        iv33.setEnabled(true);
        iv34.setEnabled(true);

        // verifique se o jogo acabou
        fim_do_jogo();
    }

    private void Recursos_da_frente_dos_cartões() {
        image101 = R.drawable.ic_image101;
        image102 = R.drawable.ic_image102;
        image103 = R.drawable.ic_image103;
        image104 = R.drawable.ic_image104;
        image105 = R.drawable.ic_image105;
        image106 = R.drawable.ic_image106;
        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
        image204 = R.drawable.ic_image204;
        image205 = R.drawable.ic_image205;
        image206 = R.drawable.ic_image206;
    }

    private void fim_do_jogo(){
        if(iv11.getVisibility() == View.INVISIBLE
                && iv12.getVisibility() == View.INVISIBLE
                && iv13.getVisibility() == View.INVISIBLE
                && iv14.getVisibility() == View.INVISIBLE
                && iv21.getVisibility() == View.INVISIBLE
                && iv22.getVisibility() == View.INVISIBLE
                && iv23.getVisibility() == View.INVISIBLE
                && iv24.getVisibility() == View.INVISIBLE
                && iv31.getVisibility() == View.INVISIBLE
                && iv32.getVisibility() == View.INVISIBLE
                && iv33.getVisibility() == View.INVISIBLE
                && iv34.getVisibility() == View.INVISIBLE
        ){
            AlertDialog.Builder builder = new AlertDialog.Builder(telaJogadores.this, R.style.AlertDialogTheme);
            View view = LayoutInflater.from(telaJogadores.this).inflate(
                    R.layout.layout_dialogo,(ConstraintLayout) findViewById(R.id.layoutDialogContainer)
            );
            builder.setView(view);
            ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.dialogo_jogo_title));
            ((TextView) view.findViewById(R.id.textMessage)).setText("P1: " + pontos_de_jogador1 + "\nP2: " + pontos_de_jogador2);
            ((Button) view.findViewById(R.id.buttonYes)).setText(getResources().getString(R.string.jogar_novamente));
            ((Button) view.findViewById(R.id.buttonNo)).setText(getResources().getString(R.string.sair));
            ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.autisto);

            final AlertDialog alertDialog = builder.create();

            view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                    Intent it = new Intent(getApplicationContext(), telaJogadores.class);
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
package com.uninassau.bilu_bilu.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoControlador {

    private CriaBanco banco;
    private SQLiteDatabase db;
    public BancoControlador(Context context){
        banco = new CriaBanco(context);
    }

    public String inserir(String nome){
        ContentValues valores;
        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put("nome", nome);

        long resultado = db.insert("pontos", null, valores);
        db.close();

        if (resultado == -1) {
            return "Erro ao inserir registro";

        } else {

            return "Registro Inserido com sucesso";
        }
    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.ID, banco.NOME};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {banco.ID, banco.NOME};
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA, campos, where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(int id, String nome){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();
        where = CriaBanco.ID + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.NOME, nome);

        db.update(CriaBanco.TABELA, valores, where,null);
        db.close();
    }

    public void deletaRegistro(int id){
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA, where,null);
        db.close();
    }
}


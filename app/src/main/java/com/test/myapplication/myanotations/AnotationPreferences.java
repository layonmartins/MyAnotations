package com.test.myapplication.myanotations;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotationPreferences {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private final String NOME_ARQUIVO = "anotacao.preferences";
    private final String CHAVE_NOME = "nome";

    public AnotationPreferences(Context c) {
        this.context = c;
        preferences  = context.getSharedPreferences(NOME_ARQUIVO, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void saveAnotation(String anotation){
        editor.putString(CHAVE_NOME, anotation);
        editor.commit();
    }

    public String getAnotation(){
        return preferences.getString(CHAVE_NOME, "");
    }

}

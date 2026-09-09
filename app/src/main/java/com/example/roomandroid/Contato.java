package com.example.roomandroid;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contatos")
public class Contato {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String nome;

    @NonNull
    private String telefone;

    public Contato(){

    }

    public Contato(@NonNull String nome, @NonNull String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    @NonNull
    public String getNome(){
        return nome;
    }
    public void setNome(@NonNull String nome){
        this.nome = nome;
    }

    @NonNull
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(@NonNull String telefone){
        this.telefone = telefone;
    }
}



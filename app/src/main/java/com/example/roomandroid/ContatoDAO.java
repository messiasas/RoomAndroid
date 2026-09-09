package com.example.roomandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContatoDAO {
    @Insert
    void inserir(Contato contato);
    @Update
    void atualizar(Contato contato);
    @Delete
    void deletar(Contato contato);

    @Query("SELECT * FROM contatos")
    List<Contato> listarTodos();

    @Query("SELECT * FROM contatos WHERE id = :contatosId")
    Contato buscarPorId(int contatosId);
}

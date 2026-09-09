package com.example.roomandroid;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Contato.class},version = 1)
public abstract class AppDataBase extends RoomDatabase { // RoomDatabase entende que existe o ContatoDAO como herança e assim consegue trabalhar com o CRUD
    public abstract ContatoDAO contatoDAO();
}

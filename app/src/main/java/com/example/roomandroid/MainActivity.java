package com.example.roomandroid;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AppDataBase db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "contatos-db")
                .allowMainThreadQueries() // só para teste rápido, tiramos isso depois
                .build();

        ContatoDAO dao = db.contatoDAO();

        dao.inserir(new Contato("Messias dev", "1191828292"));

        List<Contato> contatos = dao.listarTodos();
        for(Contato c: contatos){
            Log.d("ROOM-TEST","Nome: " + c.getNome() +" - Telefone: "+c.getTelefone());
        }

    }
}
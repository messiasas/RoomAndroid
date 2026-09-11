package com.example.roomandroid;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import com.example.roomandroid.databinding.ActivityMainBinding;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    private AppDataBase db;
    private ContatoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "contatos-db").build(); // Laço com o banco de dados
        dao = db.contatoDAO(); // Laço crud

        binding.recyclerViewContatos.setLayoutManager(new LinearLayoutManager(this));//Isso serve para organizar os elementos da interface(posições vertical/horizontal)

        //inserirContatosTeste();
        carregarContatos();

        /*executorService.execute(() -> {
            dao.inserir(new Contato("Messias dev", "1191828292"));

            List<Contato> contatos = dao.listarTodos();
            for(Contato c: contatos){
                Log.d("ROOM-TEST","Nome: " + c.getNome() +" - Telefone: "+c.getTelefone());
            }
        });*/
    }
    private void carregarContatos(){
        executorService.execute(() -> {

            List<Contato> listaContatos = dao.listarTodos();

            runOnUiThread(() -> {
                ContatoAdapter adapter = new ContatoAdapter(listaContatos);
                binding.recyclerViewContatos.setAdapter(adapter);
            });
        });
    }

    private void inserirContatosTeste() {
        executorService.execute(() -> {
            dao.inserir(new Contato("Ana Luiza", "11929203119"));
            dao.inserir(new Contato("Bruno Costa", "21998765432"));
            dao.inserir(new Contato("Carla Souza", "31987654321"));
        });
    }
}
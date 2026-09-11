package com.example.roomandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.ContatoAdapterHolder> {

    private List<Contato> listaContato;// Alt + insert para criar construtor

    public ContatoAdapter(List<Contato> listaContato) {
        this.listaContato = listaContato;
    }

    @NonNull
    @Override
    public ContatoAdapter.ContatoAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contato, parent, false);

        return new ContatoAdapterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContatoAdapter.ContatoAdapterHolder holder, int position) {

        Contato contatoAtual = listaContato.get(position);
        holder.textViewNome.setText(contatoAtual.getNome());
        holder.textViewTelefone.setText(contatoAtual.getTelefone());
    }

    @Override
    public int getItemCount() {
        return listaContato.size();
    }

    public static class ContatoAdapterHolder extends RecyclerView.ViewHolder{
        TextView textViewNome;
        TextView textViewTelefone;

        // clique em Alt + Insert para inserir o construtor
        public ContatoAdapterHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewNome = itemView.findViewById(R.id.textViewNome);
            this.textViewTelefone = itemView.findViewById(R.id.textViewTelefone);
        }
    }
}

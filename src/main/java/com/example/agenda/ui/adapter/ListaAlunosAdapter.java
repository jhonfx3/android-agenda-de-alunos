package com.example.agenda.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.agenda.R;
import com.example.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListaAlunosAdapter extends BaseAdapter {
    private List<Aluno> alunos = new ArrayList<>();
    private Context context;


    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int posicao) {
        return alunos.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return alunos.get(posicao).getId();
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_aluno, viewGroup, false);
        Aluno alunoDevolvido = alunos.get(posicao);
        Log.i("AlunoDevolvidoNome", alunoDevolvido.getNome());
        TextView nome = viewCriada.findViewById(R.id.item_aluno_nome);
        TextView telefone = viewCriada.findViewById(R.id.item_aluno_telefone);
        nome.setText(alunoDevolvido.getNome());
        telefone.setText(alunoDevolvido.getTelefone());
        return viewCriada;
    }

    public void clear() {
        alunos.clear();
    }

    public void addAll(List<Aluno> todos) {
        this.alunos.addAll(todos);
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
    }
}
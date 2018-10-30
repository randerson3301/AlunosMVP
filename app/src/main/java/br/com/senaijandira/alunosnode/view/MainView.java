package br.com.senaijandira.alunosnode.view;

import java.util.List;

import br.com.senaijandira.alunosnode.model.Aluno;

public interface MainView {
    void exibirProgress();

    void esconderProgress();

    void  preencherLista(List<Aluno> lstAlunos);
}

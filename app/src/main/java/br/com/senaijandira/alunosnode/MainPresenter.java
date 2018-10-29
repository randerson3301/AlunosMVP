package br.com.senaijandira.alunosnode;

import android.util.Log;

import java.util.List;

import br.com.senaijandira.alunosnode.model.Aluno;
import br.com.senaijandira.alunosnode.service.AlunosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    MainView mainView;

    AlunosService service;

    public MainPresenter(MainView mainView, AlunosService service) {
        this.mainView = mainView;

        this.service = service;
    }

    public void carregarAlunos() {

        //Chamando a API
        Call<List<Aluno>> call = service.obterAlunos();

        mainView.exibirProgress();
        //Executar a chamada da Api
        call.enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {
                List<Aluno> alunos = response.body(); // Pegando as informações da Api
                //chamando o método para a preencher a tela com alunos
                mainView.preencherLista(alunos);

                mainView.esconderProgress(); //esconde a barra

            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) { //Se falhar vem para cá
                Log.e("ALUNOS", t.getMessage()); // Pegando o erro
            }
        });

    }

}

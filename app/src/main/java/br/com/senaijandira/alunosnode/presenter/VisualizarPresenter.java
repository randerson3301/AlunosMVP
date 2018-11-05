package br.com.senaijandira.alunosnode.presenter;

import android.util.Log;

import br.com.senaijandira.alunosnode.model.Aluno;
import br.com.senaijandira.alunosnode.service.AlunosService;
import br.com.senaijandira.alunosnode.view.VisualizarView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisualizarPresenter {
    VisualizarView view;
    AlunosService service;

    public VisualizarPresenter(VisualizarView view, AlunosService service) {
        this.view = view;
        this.service = service;
    }


    public void getAlunoPorId(int idAluno) {
        Call<Aluno> call = service.obterAlunosPorId(idAluno);


        call.enqueue(new Callback<Aluno>() {
            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                Aluno aluno = response.body();

                view.preencherCampos(aluno);
            }

            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {
                Log.e("ALUNO", t.getMessage());
            }

        });


    }
}

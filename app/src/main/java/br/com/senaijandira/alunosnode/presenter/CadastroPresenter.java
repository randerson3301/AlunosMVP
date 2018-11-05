package br.com.senaijandira.alunosnode.presenter;

import br.com.senaijandira.alunosnode.model.Aluno;
import br.com.senaijandira.alunosnode.model.ApiResult;
import br.com.senaijandira.alunosnode.service.AlunosService;
import br.com.senaijandira.alunosnode.view.CadastroView;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroPresenter {
    CadastroView view;

    AlunosService service;



    public CadastroPresenter(CadastroView view, AlunosService service) {
        this.view = view;
        this.service = service;
    }

    public void cadastrarAluno(Aluno aluno){
        service.cadastrarAluno(aluno).enqueue(new Callback<ApiResult>() {

            @Override
            public void onResponse(retrofit2.Call<ApiResult> call, Response<ApiResult> response) {
                ApiResult result = response.body();

                if(result.isSucesso()) {
                    view.showMessage("Sucesso", "Sucesso");
                } else  {
                    view.showMessage("Deu não", "Foi mal Bro");
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ApiResult> call, Throwable t) {
                view.showMessage("Error", t.getMessage());
                t.printStackTrace();
            }
        });
    }
}

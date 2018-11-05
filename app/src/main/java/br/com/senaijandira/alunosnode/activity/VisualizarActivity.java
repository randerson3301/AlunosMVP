package br.com.senaijandira.alunosnode.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import br.com.senaijandira.alunosnode.R;
import br.com.senaijandira.alunosnode.model.Aluno;
import br.com.senaijandira.alunosnode.presenter.VisualizarPresenter;
import br.com.senaijandira.alunosnode.service.AlunosService;
import br.com.senaijandira.alunosnode.service.ServiceFactory;
import br.com.senaijandira.alunosnode.view.VisualizarView;

public class VisualizarActivity extends AppCompatActivity implements VisualizarView{

   TextView txtNome, txtMatricula, txtCpf, txtDataNasc;
   int idAluno;
   VisualizarPresenter presenter;
   AlunosService service;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_visualizar);
        idAluno = getIntent().getIntExtra("idAluno", 0);

        //pegando os ids do layout
        txtNome = findViewById(R.id.txtNome);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtCpf = findViewById(R.id.txtCpf);
        txtDataNasc = findViewById(R.id.txtDataNasc);

        //chamando a class Presenter do Activity
        service = ServiceFactory.create();

        presenter = new VisualizarPresenter(this, service);
        presenter.getAlunoPorId(idAluno);


        Log.d("VISUALIZAR", idAluno+"");


    }

    public void encerrar(View view) {
        finish();
    }


    @Override
    public void preencherCampos(Aluno aluno) {
        txtNome.setText(aluno.getNome());
        txtDataNasc.setText(aluno.getDataNascimento());
        txtCpf.setText(aluno.getCpf());
        txtMatricula.setText(aluno.getMatricula());
    }
}

package br.com.senaijandira.alunosnode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.senaijandira.alunosnode.adapter.AlunoAdapter;
import br.com.senaijandira.alunosnode.model.Aluno;
import br.com.senaijandira.alunosnode.service.ServiceFactory;

public class MainActivity extends AppCompatActivity implements MainView{
    ListView listView;

    AlunoAdapter adapter;
    ProgressBar pb;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        listView = findViewById(R.id.lstAluno);
        adapter = new AlunoAdapter(this);
        pb = findViewById(R.id.progBar);
        //plugando o adapter na lista
        listView.setAdapter(adapter);

        //config presenter
        presenter = new MainPresenter(this, ServiceFactory.create());

        presenter.carregarAlunos();

        }

    @Override
    public void exibirProgress(){
        pb.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);

    }
    @Override
    public void esconderProgress(){
        pb.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void preencherLista(List<Aluno> lstAlunos) {
        adapter.clear();

        adapter.addAll(lstAlunos);
    }

}

package br.com.senaijandira.alunosnode.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.senaijandira.alunosnode.R;
import br.com.senaijandira.alunosnode.adapter.AlunoAdapter;
import br.com.senaijandira.alunosnode.model.Aluno;
import br.com.senaijandira.alunosnode.presenter.MainPresenter;
import br.com.senaijandira.alunosnode.service.ServiceFactory;
import br.com.senaijandira.alunosnode.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener{

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
        //abre a activity de visualizar
        listView.setOnItemClickListener(this);

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
    protected void onResume() {
        super.onResume();
        presenter.carregarAlunos();
    }

    @Override
    public void preencherLista(List<Aluno> lstAlunos) {
        adapter.clear();

        adapter.addAll(lstAlunos);
    }

    public void openCadastro(View view) {
        startActivity(new Intent(this, CadastroActivity.class));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Aluno alunoSelecionado = adapter.getItem(position);

        Intent intent = new Intent(this, VisualizarActivity.class);

        intent.putExtra("idAluno", alunoSelecionado.getId());

        startActivity(intent);

    }
}

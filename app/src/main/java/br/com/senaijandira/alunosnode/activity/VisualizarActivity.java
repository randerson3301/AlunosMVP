package br.com.senaijandira.alunosnode.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class VisualizarActivity extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        int idAluno = getIntent().getIntExtra("idAluno", 0);

        Log.d("VISUALIZAR", idAluno+"");

    }
}

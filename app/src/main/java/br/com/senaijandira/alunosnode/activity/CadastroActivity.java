package br.com.senaijandira.alunosnode.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import br.com.senaijandira.alunosnode.R;
import br.com.senaijandira.alunosnode.model.Aluno;
import br.com.senaijandira.alunosnode.model.ApiResult;
import br.com.senaijandira.alunosnode.presenter.CadastroPresenter;
import br.com.senaijandira.alunosnode.service.AlunosService;
import br.com.senaijandira.alunosnode.service.ServiceFactory;
import br.com.senaijandira.alunosnode.util.DateUtil;
import br.com.senaijandira.alunosnode.view.CadastroView;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroActivity extends AppCompatActivity implements CadastroView {


    AlunosService service = ServiceFactory.create();
    static EditText txtNome, txtDataNasc, txtMatricula, txtCpf;
    CadastroPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        txtNome = findViewById(R.id.txtNomeAluno);
        txtDataNasc = findViewById(R.id.txtDataNasc);
        txtMatricula = findViewById(R.id.txtMatricula);
        txtCpf = findViewById(R.id.txtCpf);

        presenter = new CadastroPresenter(this, service);
    }

    public void cadastroAluno(View view) {
        String nome = txtNome.getText().toString();
        String dtNasc = txtDataNasc.getText().toString();
        String matricula = txtMatricula.getText().toString();
        String cpf = txtCpf.getText().toString();

        int dataFormatada = new DateUtil().convertToInt(dtNasc);

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setDataNascimento(dataFormatada);
        aluno.setCpf(cpf);
        aluno.setMatricula(Integer.parseInt(matricula));

        presenter.cadastrarAluno(aluno);
    }



    public void abrirCalendario(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void showMessage(String title, String msg) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(title);
        dialog.setMessage(msg);
        dialog.create();
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dialog.show();
    }

    //class para DatePicker
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            String data = String.format("%02d/%02d/%d", day, month, year);
            txtDataNasc.setText(data);
        }
    }
}

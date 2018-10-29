package br.com.senaijandira.alunosnode.service;

import java.util.List;

import br.com.senaijandira.alunosnode.model.Aluno;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AlunosService {
    /* Precisa ser uma interface */

    String URL_BASE = "http://10.0.2.2:5001/"; // String base da  API || 10.0.2.2 é o IP padrão do android para esse tipo de conexao || Quando for fazer um app mesmo colocar o ip do servidor

    @GET("/alunos") /* Assim como no banco, precisa realizar uma assinatura do método */
    Call<List<Aluno>> obterAlunos(); //Esse método não é void pois vai retornar uma chamda de lista de alunos

    //@GET("/alunos/{id}")
   // Call<List<Aluno>> obterAlunos();

}

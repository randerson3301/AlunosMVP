package br.com.senaijandira.alunosnode.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Aluno {

    private int id;
    private String nome;
    @SerializedName("data_nascimento")
    private int dataNascimento; // Como o nome deve ser identico mas no Java o padrão é camel case, temos que avisar que na api o nome está como data_nascimento
    private int matricula;
    private String cpf;
    private List<Double> notas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
}

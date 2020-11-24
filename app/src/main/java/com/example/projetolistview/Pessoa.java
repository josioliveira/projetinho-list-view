package com.example.projetolistview;

import java.io.Serializable;
import java.util.Comparator;

// Aqui é onde criei minha classe "PESSOA""

public class Pessoa implements Serializable {
    // Aqui criei as variáveis privadas.
    private String nome;
    private String sobrenome;
    private String curso;



    // construtor vazio Pessoa
    public Pessoa() {
    }
// Para criar o constructor, botão direito fora das {chaves} code/generate/constructor/select all e ok.
    public Pessoa(String nome, String sobrenome, String curso) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


    // Concatenar os dados para aparecer certo.

    public String getDados(){
        return "Nome: " +  nome + " " + sobrenome + "\nCurso: " + curso;
    }


   //Imprimir na lista esses objetos. Posso passar somente o nome caso queira.

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }
}
// Aqui vamos criar uma classe interna para ordenar os objetos.

class OrdenaPorNome implements Comparator<Pessoa>{

    // Comparar métodos. Se os obj forem iguais retorna zero.
    @Override
    public int compare(Pessoa p1, Pessoa p2) {

        return p1.getNome().compareTo(p2.getNome());
    }
}
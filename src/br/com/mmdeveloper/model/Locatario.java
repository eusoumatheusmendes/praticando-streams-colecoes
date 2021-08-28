package br.com.mmdeveloper.model;

public class Locatario {

    private String nome;
    private String cpf;

    public Locatario(String nome, String cpf){
        if(nome == null || cpf == null){
            throw new NullPointerException("Preencha todos os campos por favor!");
        }
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Locatario{" +
                "nome='" + nome + '\'' +
                '}';
    }
}

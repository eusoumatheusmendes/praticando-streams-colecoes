package br.com.mmdeveloper.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Imobiliaria {

    private String nome;
    private String cnpj;
    private Collection<Apartamento> apartamentos;

    public Imobiliaria(String nome, String cnpj){
        if(nome == null || cnpj == null){
            throw  new NullPointerException("Preencha todos os campos!");
        }
        this.nome = nome;
        this.cnpj = cnpj;
        this.apartamentos = new HashSet<>();
    }

    public void anunciarAluguelDeApartamentos(Apartamento apartamento){
        this.apartamentos.add(apartamento);
    }

    public Collection<Apartamento> getTodosOsApartamentos() {
        return Collections.unmodifiableCollection(apartamentos);
    }

    public Collection getApartamentosDisponiveisParaAluguel(){
        Stream<Apartamento> apartamentosStream = this.apartamentos.stream().filter(Apartamento::getApartamentoNãoAlugado);
        return apartamentosStream.collect(Collectors.toList());
    }

    public long getTotalDeApartamentosDisponiveisParaAluguel(){
       return this.getTodosOsApartamentos().stream().filter(Apartamento::getApartamentoNãoAlugado).count();
    }

    public double getApartamentoNaoAlugadoDeMenorValor() {
        Stream<Apartamento> apartamentoStream  = this.apartamentos.stream().filter(Apartamento::getApartamentoNãoAlugado);
        if(apartamentoStream.count() < 1){
            throw new ApartamentoIndisponivelException("No momento não temos apartamentos disponíveis");
        }
        return apartamentoStream.mapToDouble(Apartamento::getValorDoAluguel).min().getAsDouble();
    }

    public Collection<Apartamento> getApartamentosAlugados(){
       Stream<Apartamento> apartamentoStream =  this.apartamentos.stream().filter(Apartamento::isAlugado);
       return apartamentoStream.collect(Collectors.toList());
    }

    public int getTotalDeApartamentosAlugados(){
        return this.getApartamentosAlugados().size();
    }

    public double getValorMensalComAlugueis() {
        return this.getApartamentosAlugados().stream().mapToDouble(Apartamento::getValorDoAluguel).sum();
    }

    public void mostrarLocatarios(){
        this.getApartamentosAlugados().forEach(a -> System.out.println("Locatários: " +a.getLocatario()));
    }


}

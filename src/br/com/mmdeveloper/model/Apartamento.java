package br.com.mmdeveloper.model;

public class Apartamento {

    private int numero;
    private double valorDoAluguel;
    private int numeroDeQuartos;
    private double tamanhoEmMetrosQuadrados;
    private boolean alugado;
    private Locatario locatario;

    public Apartamento(int numero, double valorDoAluguel, int numeroDeQuartos, double tamanhoEmMetrosQuadrados){
        if(numero == 0 || valorDoAluguel == 0.0 || numeroDeQuartos == 0 || tamanhoEmMetrosQuadrados == 0.0 ){
            throw new IllegalArgumentException("Nenhum campo pode ter valor igual a 0. Verifique os campos.");
        }
        this.numero = numero;
        this.valorDoAluguel = valorDoAluguel;
        this.numeroDeQuartos = numeroDeQuartos;
        this.tamanhoEmMetrosQuadrados = tamanhoEmMetrosQuadrados;
    }

    @Override
    public String toString() {
        return "Descrição do apartamento: " +this.tamanhoEmMetrosQuadrados + " m2, "
                + this.numeroDeQuartos + " quartos " + " Valor do aluguel: " +this.valorDoAluguel;
    }

    public double getValorDoAluguel() {
        return valorDoAluguel;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public boolean getApartamentoNãoAlugado(){
        return !isAlugado();
    }

    public void alugar(Locatario locatario){
        this.locatario = locatario;
        this.alugado = true;
    }

    public Locatario getLocatario() {
        return locatario;
    }
}

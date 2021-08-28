package br.com.mmdeveloper.test;

import br.com.mmdeveloper.model.Apartamento;
import br.com.mmdeveloper.model.ApartamentoIndisponivelException;
import br.com.mmdeveloper.model.Imobiliaria;
import br.com.mmdeveloper.model.Locatario;

import java.util.NoSuchElementException;

public class TestaAluguel {

    public static void main(String[] args) {

        Imobiliaria imobiliaria = new Imobiliaria("Imobi", "9848480001");

        Apartamento ap1 = new Apartamento(99, 1100, 3, 60);
        Apartamento ap2 = new Apartamento(96, 1680, 2, 50);
        Apartamento ap3 = new Apartamento(69, 1500, 1, 40);

        Locatario locatario1 = new Locatario("Matheus Mendes", "04494949444");
        Locatario locatario2 = new Locatario("Ana", "455575755757");
        Locatario locatario3 = new Locatario("Marta", "567777777");

        ap1.alugar(locatario1);
        ap2.alugar(locatario2);
        ap3.alugar(locatario3);

        imobiliaria.anunciarAluguelDeApartamentos(ap1);
        imobiliaria.anunciarAluguelDeApartamentos(ap2);
        imobiliaria.anunciarAluguelDeApartamentos(ap3);

        System.out.println("Está alugado o apartamento ap1? : " +ap1.isAlugado());

        System.out.println("---------------------------------------------");
        System.out.println("Total de apartamentos disponíveis: " +imobiliaria.getTotalDeApartamentosDisponiveisParaAluguel());

        imobiliaria.getApartamentosDisponiveisParaAluguel().forEach(a -> System.out.println("Apartamentos disponíveis: " +a));

        try{
        System.out.println("Apartamento disponível de menor valor: " +imobiliaria.getApartamentoNaoAlugadoDeMenorValor());
        }catch (ApartamentoIndisponivelException ex){
            System.out.println("Não temos apartamentos disponíveis");
        }

        System.out.println("---------------------------------------------");
        System.out.println("Total de apartamentos alugados: " +imobiliaria.getTotalDeApartamentosAlugados());

        System.out.println("---------------------------------------------");
        System.out.println("Valor mensal com aluguéis: " +imobiliaria.getValorMensalComAlugueis());

    }
}

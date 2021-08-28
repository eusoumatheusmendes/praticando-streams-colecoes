package br.com.mmdeveloper.model;

public class ApartamentoIndisponivelException extends RuntimeException {

    public ApartamentoIndisponivelException(String msg) {
        super(msg);
    }
}

package br.com.soc.sistema.exception;

public class BusinessException extends RuntimeException{
	public BusinessException(String mensagem) {
		super(mensagem);
	}

	public BusinessException(String string, Exception e) {
		
	}
}

package br.com.estudoapi.api.util;

import org.springframework.http.HttpStatus;

public class ResourceException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ResourceException(HttpStatus httpStatus, String mensagem) {
        super(mensagem);
        this.httpStatus = httpStatus;
    }

}

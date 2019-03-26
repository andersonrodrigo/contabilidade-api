package br.com.memory.contabilidade.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ExceptionHandlerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> erroDeValidacaoLogin(Exception e) {

		return ResponseEntity.ok().body(null);
	}
}

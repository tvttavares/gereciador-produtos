package com.multi.gerenciadorprodutosapi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProdutoNaoEncontradoException.class)
	public ResponseEntity<?> resourceNotFoundException(ProdutoNaoEncontradoException ex, WebRequest request) {

		DetalhamentoErro errorDetails = new DetalhamentoErro(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(ProdutoNaoEncontradoException ex, WebRequest request) {

		DetalhamentoErro errorDetails = new DetalhamentoErro(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

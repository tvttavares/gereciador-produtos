package com.multi.gerenciadorprodutosapi.exception;

import java.util.Date;

import lombok.Data;

@Data
public class DetalhamentoErro {

	private Date timestamp;
	private String mensagem;
	private String detalhes;

	public DetalhamentoErro(Date timestamp, String mensagem, String detalhes) {
		super();
		this.timestamp = timestamp;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}
}

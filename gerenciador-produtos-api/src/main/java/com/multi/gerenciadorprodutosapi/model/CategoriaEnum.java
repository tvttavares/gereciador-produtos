package com.multi.gerenciadorprodutosapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoriaEnum {
	PERECIVEL("Perecivel"), NAOPERECIVEL("Nao perecivel");

	private final String descricao;
}

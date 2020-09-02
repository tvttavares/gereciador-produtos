package com.multi.gerenciadorprodutosapi.utils;

import java.math.BigDecimal;

import com.multi.gerenciadorprodutosapi.model.CategoriaEnum;
import com.multi.gerenciadorprodutosapi.model.Produto;

public class ProdutoUtils {

	private static final String NOME = "Banana";
	private static final CategoriaEnum CATEGORIA = CategoriaEnum.PERECIVEL;
	private static final BigDecimal VALOR = new BigDecimal(4.99);
	private static final long PRODUTO_ID = 50L;

	public static Produto criarEntidadeProdutoFalsa() {
		return Produto.builder().id(PRODUTO_ID).nome(NOME).categoria(CATEGORIA).valor(VALOR).build();
	}
}

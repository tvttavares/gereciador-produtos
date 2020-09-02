package com.multi.gerenciadorprodutosapi.service;

import static com.multi.gerenciadorprodutosapi.utils.ProdutoUtils.criarEntidadeProdutoFalsa;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.multi.gerenciadorprodutosapi.exception.ProdutoNaoEncontradoException;
import com.multi.gerenciadorprodutosapi.model.Produto;
import com.multi.gerenciadorprodutosapi.repository.ProdutoRepository;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

	@Mock
	private ProdutoRepository produtoRepository;

	@InjectMocks
	private ProdutoService produtoService;

	@Test
	void deveRetornarProdutoQuandoDadoUmId() throws ProdutoNaoEncontradoException {
		Produto produtoEsperado = criarEntidadeProdutoFalsa();

		when(produtoRepository.findById(produtoEsperado.getId())).thenReturn(Optional.of(produtoEsperado));
		ResponseEntity<Produto> produtoConsultado = produtoService.buscarPorId(produtoEsperado.getId());

		assertEquals(produtoConsultado.getBody().getNome(), produtoEsperado.getNome());
	}

	@Test
	void deveValidarCriacaoProduto() {
		Produto produtoEsperado = criarEntidadeProdutoFalsa();

		when(produtoRepository.save(any(Produto.class))).thenReturn(produtoEsperado);
		Produto produto = produtoService.criarProduto(produtoEsperado);

		assertEquals(produtoEsperado, produto);
	}

	@Test
	void deveFalharQuandoDadoUmIDInexistente() {
		long invalidId = 1L;
		when(produtoRepository.findById(invalidId)).thenReturn(Optional.ofNullable(any(Produto.class)));
		assertThrows(ProdutoNaoEncontradoException.class, () -> produtoService.buscarPorId(invalidId));
	}

	@Test
	public void deveFalharQuandoExcluirProdutoInexistente() {
		long invalidId = 100L;
		when(produtoRepository.findById(invalidId)).thenReturn(Optional.ofNullable(any(Produto.class)));
		assertThrows(ProdutoNaoEncontradoException.class, () -> produtoService.removerProduto(invalidId));
	}

}

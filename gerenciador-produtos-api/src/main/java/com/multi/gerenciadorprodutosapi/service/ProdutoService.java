package com.multi.gerenciadorprodutosapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.multi.gerenciadorprodutosapi.exception.ProdutoNaoEncontradoException;
import com.multi.gerenciadorprodutosapi.model.Produto;
import com.multi.gerenciadorprodutosapi.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoService {

	private ProdutoRepository produtoRepository;

	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	public ResponseEntity<Produto> buscarPorId(long produtoId) throws ProdutoNaoEncontradoException {
		Produto produto = verificaSeExiste(produtoId);
		return ResponseEntity.ok().body(produto);
	}

	public Produto criarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public ResponseEntity<Produto> atualizarProduto(Long produtoId, Produto produtoDetalhes)
			throws ProdutoNaoEncontradoException {
		Produto produto = verificaSeExiste(produtoId);
		BeanUtils.copyProperties(produtoDetalhes, produto, "id");
		final Produto produtoAtualizado = produtoRepository.save(produto);
		return ResponseEntity.ok(produtoAtualizado);
	}

	public void removerProduto(Long produtoId) throws ProdutoNaoEncontradoException {
		Produto produto = verificaSeExiste(produtoId);
		produtoRepository.delete(produto);
	}

	private Produto verificaSeExiste(Long id) throws ProdutoNaoEncontradoException {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new ProdutoNaoEncontradoException("Produto nao encontrado: " + id));
	}
}

package com.multi.gerenciadorprodutosapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.multi.gerenciadorprodutosapi.exception.ProdutoNaoEncontradoException;
import com.multi.gerenciadorprodutosapi.model.Produto;
import com.multi.gerenciadorprodutosapi.service.ProdutoService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/produtos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GerenciadorProdutosController {

	private ProdutoService produtoService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> listarProdutos() {
		return produtoService.listarProdutos();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Produto> buscarPorId(@PathVariable(value = "id") long produtoId)
			throws ProdutoNaoEncontradoException {
		return produtoService.buscarPorId(produtoId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto criarProduto(@Valid @RequestBody Produto produto) {
		return produtoService.criarProduto(produto);
	}

	@PutMapping("/{produtoId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Produto> atualizarProduto(@PathVariable Long produtoId,
			@Valid @RequestBody Produto produtoDetalhes) throws ProdutoNaoEncontradoException {
		return produtoService.atualizarProduto(produtoId, produtoDetalhes);
	}

	@DeleteMapping("/{produtoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerProduto(@PathVariable Long produtoId) throws ProdutoNaoEncontradoException {
		produtoService.removerProduto(produtoId);
	}
}

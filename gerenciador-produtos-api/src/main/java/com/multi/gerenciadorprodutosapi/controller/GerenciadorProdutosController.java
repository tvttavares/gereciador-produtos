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
import com.multi.gerenciadorprodutosapi.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/produtos")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GerenciadorProdutosController {

	private ProdutoRepository produtoRepository;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Produto> buscarPorId(@PathVariable(value = "id") long produtoId)
			throws ProdutoNaoEncontradoException {
		Produto room = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new ProdutoNaoEncontradoException("Produto nao encontrado: " + produtoId));

		return ResponseEntity.ok().body(room);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto criarProduto(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@PutMapping("/{produtoId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Produto> atualizarProduto(@PathVariable Long produtoId,
			@Valid @RequestBody Produto produtoDetalhes) throws ProdutoNaoEncontradoException {
		Produto produto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new ProdutoNaoEncontradoException("Produto nao encontrado: " + produtoId));

		final Produto updateRoom = produtoRepository.save(produtoDetalhes);

		return ResponseEntity.ok(updateRoom);
	}

	@DeleteMapping("/{roomId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerProduto(@PathVariable Long roomId) throws ProdutoNaoEncontradoException {
		Produto room = produtoRepository.findById(roomId)
				.orElseThrow(() -> new ProdutoNaoEncontradoException("Produto nao encontrado: " + roomId));

		produtoRepository.delete(room);
	}
}

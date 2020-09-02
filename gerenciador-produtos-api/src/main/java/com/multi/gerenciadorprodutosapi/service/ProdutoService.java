package com.multi.gerenciadorprodutosapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.gerenciadorprodutosapi.repository.ProdutoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoService {

	private ProdutoRepository produtoRepository;

}

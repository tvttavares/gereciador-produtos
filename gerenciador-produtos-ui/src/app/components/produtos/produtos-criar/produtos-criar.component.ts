import { ProdutoService } from './../produto.service';
import { Produto } from './../produto.module';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-produtos-criar',
  templateUrl: './produtos-criar.component.html',
  styleUrls: ['./produtos-criar.component.css']
})
export class ProdutosCriarComponent implements OnInit {

  produto: Produto = {
    nome: '',
    categoria: '',
    valor: null
  }

  constructor(
    private produtoService: ProdutoService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  criarProduto(): void {
    this.produtoService.criar(this.produto).subscribe(() => {
      this.produtoService.mensagem('Produto criado!')
      this.router.navigate(['/produtos'])
    })

  }

  cancelar(): void {
    this.router.navigate(['/produtos'])
  }
}

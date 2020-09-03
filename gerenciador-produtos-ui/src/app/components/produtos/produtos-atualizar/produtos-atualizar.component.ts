import { ProdutoService } from './../produto.service';
import { Component, OnInit } from '@angular/core';
import { Produto } from '../produto.module';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-produtos-atualizar',
  templateUrl: './produtos-atualizar.component.html',
  styleUrls: ['./produtos-atualizar.component.css']
})
export class ProdutosAtualizarComponent implements OnInit {
  produto: Produto;

  constructor(
    private produtoService: ProdutoService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.produtoService.lerPorId(id).subscribe((produto) => {
      this.produto = produto;
    });
  }

  atualizarProduto(): void {
    this.produtoService.atualizar(this.produto).subscribe(() => {
      this.produtoService.mensagem("Produto atualizado com sucesso!");
      this.router.navigate(["/produtos"]);
    });
  }

  cancelar(): void {
    this.router.navigate(["/produtos"]);
  }
}

import { ProdutoService } from './../produto.service';
import { Component, OnInit } from '@angular/core';
import { Produto } from '../produto.module';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-produtos-excluir',
  templateUrl: './produtos-excluir.component.html',
  styleUrls: ['./produtos-excluir.component.css']
})
export class ProdutosExcluirComponent implements OnInit {

  produto: Produto;

  constructor(
    private produtoService: ProdutoService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.produtoService.lerPorId(id).subscribe((product) => {
      this.produto = product;
    });
  }

  excluirProduto(): void {
    this.produtoService.excluir(this.produto.id).subscribe(() => {
      this.produtoService.mensagem("Produto excluido com sucesso!");
      this.router.navigate(["/produtos"]);
    });
  }

  cancelar(): void {
    this.router.navigate(["/produtos"]);
  }

}

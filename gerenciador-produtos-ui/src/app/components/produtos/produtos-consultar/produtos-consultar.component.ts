import { Component, OnInit } from '@angular/core';
import { Produto } from '../produto.module';
import { ProdutoService } from '../produto.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-produtos-consultar',
  templateUrl: './produtos-consultar.component.html',
  styleUrls: ['./produtos-consultar.component.css']
})
export class ProdutosConsultarComponent implements OnInit {

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

  voltar(): void {
    this.router.navigate(["/produtos"]);
  }
}

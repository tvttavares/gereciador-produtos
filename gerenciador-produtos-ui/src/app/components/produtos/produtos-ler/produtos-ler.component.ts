import { ProdutoService } from './../produto.service';
import { Component, OnInit } from '@angular/core';
import { Produto } from '../produto.module';

@Component({
  selector: 'app-produtos-ler',
  templateUrl: './produtos-ler.component.html',
  styleUrls: ['./produtos-ler.component.css']
})
export class ProdutosLerComponent implements OnInit {

  produtos: Produto[]
  displayedColumns = ['id', 'nome', 'categoria', 'valor', 'action']

  constructor(private produtoService: ProdutoService) { }

  ngOnInit(): void {
    this.produtoService.ler().subscribe(produtos => {
      this.produtos = produtos
      console.log(produtos)
    })
  }

}

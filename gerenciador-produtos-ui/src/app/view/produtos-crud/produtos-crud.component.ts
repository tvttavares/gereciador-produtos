import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-produtos-crud',
  templateUrl: './produtos-crud.component.html',
  styleUrls: ['./produtos-crud.component.css']
})
export class ProdutosCrudComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  navegarParaCriacaoProduto(): void {
    this.router.navigate(['/produtos/criar'])
  }
}

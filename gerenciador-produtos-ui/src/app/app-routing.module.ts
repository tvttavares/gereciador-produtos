import { ProdutosConsultarComponent } from './components/produtos/produtos-consultar/produtos-consultar.component';
import { ProdutosAtualizarComponent } from './components/produtos/produtos-atualizar/produtos-atualizar.component';
import { ProdutosCriarComponent } from './components/produtos/produtos-criar/produtos-criar.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './view/home/home.component';
import { ProdutosCrudComponent } from './view/produtos-crud/produtos-crud.component'

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  }, {
    path: "produtos",
    component: ProdutosCrudComponent
  },
  {
    path: "produtos/criar",
    component: ProdutosCriarComponent
  },
  {
    path: "produtos/atualizar/:id",
    component: ProdutosAtualizarComponent
  }, 
  {
    path: "produtos/consultar/:id",
    component: ProdutosConsultarComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

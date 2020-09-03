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
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

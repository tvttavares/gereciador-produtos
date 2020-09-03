import { Produto } from './produto.module';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient } from '@angular/common/http';
import { Observable, EMPTY } from 'rxjs';
import { catchError, map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  baseUrl = "http://localhost:8080/api/produtos"

  constructor(
    private snackBar: MatSnackBar,
    private http: HttpClient
  ) { }

  mensagem(msg: string, isError: boolean = false): void {
    this.snackBar.open(msg, 'X', {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass: isError ? ["msg-erro"] : ["msg-sucesso"],
    })
  }

  criar(produto: Produto): Observable<Produto> {
    return this.http.post<Produto>(this.baseUrl, produto).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  ler(): Observable<Produto[]> {
    return this.http.get<Produto[]>(this.baseUrl).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  lerPorId(id: number): Observable<Produto> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Produto>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  atualizar(produto: Produto): Observable<Produto> {
    const url = `${this.baseUrl}/${produto.id}`;
    return this.http.put<Produto>(url, produto).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  excluir(id: number): Observable<Produto> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<Produto>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  errorHandler(e: any): Observable<any> {
    this.mensagem("Ocorreu um erro!", true);
    return EMPTY;
  }
}

import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {element} from 'protractor';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [];

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>('http://localhost:3000/product');
  }

  saveProduct(product): Observable<any> {
    return this.http.post<any>('http://localhost:3000/product', product);
  }

  findById(id: number): Observable<any> {
    return this.http.get<any>('http://localhost:3000/product/' + id);
  }

  update(id: number, product: Product): Observable<any> {
    return this.http.put<any>('http://localhost:3000/product/' + id, product);
  }

  delete(id: number) {
    return this.http.delete<any>('http://localhost:3000/product/' + id);
  }

  search(value: string) {
    return this.http.get<any>('http://localhost:3000/product?name_like=' + value);
  }
}

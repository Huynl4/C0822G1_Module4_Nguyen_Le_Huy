import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../entity/product';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) {
  }

  getProductVegetable(page: number, size: number): Observable<Product[]> {
    return this.httpClient.get<Product[]>('http://localhost:8080/api/auth/listVegetable?page=' + page + '&size=' + size);
  }

  getProductFruit(page1: number, size1: number): Observable<Product[]> {
    return this.httpClient.get<Product[]>('http://localhost:8080/api/auth/listFruit?page1=' + page1 + '&size1=' + size1);
  }
}

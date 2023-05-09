import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../entity/product';
import {Observable} from 'rxjs';
import {Category} from '../entity/category';

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

  findProductById(id: number): Observable<Product> {
    return this.httpClient.get('http://localhost:8080/api/auth/findProductById/' + id);
  }

  getListSearchResults(page: number, size: number,keyword: string):Observable<Product[]> {
    return this.httpClient.get<Product[]>('http://localhost:8080/api/auth/getListSearchResults?page=' +page+ '&size=' +size+ '&keyword=' +keyword)
  }

  getAquaTypeList():Observable<Category[]> {
    return this.httpClient.get<Category[]>('http://localhost:8080/api/auth/listProductCategory')
  }

  changeListForOption(page:number,size:number,keyword: string, id: number):Observable<Product[]> {
    return this.httpClient.get<Product[]>('http://localhost:8080/api/auth/changeListForOptionList?page=' +page+ '&size=' +size+ '&keyword=' +keyword+ "&id=" +id)
  }
}

import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../entity/product';
import {Account} from '../entity/account';

@Injectable({
  providedIn: 'root'
})
export class InfoService {

  constructor(private httpClient: HttpClient) {
  }

  findByIdAccount(id: number): Observable<Account> {
    return this.httpClient.get<Account>('http://localhost:8080/api/auth/info/' + id);
  }
}

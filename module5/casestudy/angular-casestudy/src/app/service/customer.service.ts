import {Injectable} from '@angular/core';
import {Customer} from "../model/customer";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>('http://localhost:3000/customer');
  }

  saveCustomer(customer): Observable<any> {
    return this.http.post<any>('http://localhost:3000/customer', customer);
  }

  findById(id: number): Observable<any> {
    return this.http.get<any>('http://localhost:3000/customer/' + id);
  }

  update(customer: Customer): Observable<any> {
    return this.http.put<any>('http://localhost:3000/customer/' + customer.id, customer)
  }

  delete(id: number) {
    return this.http.delete<any>("http://localhost:3000/customer/" + id)
  }
}

import {Injectable} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Sanbong} from "../entity/sanbong";

@Injectable({
  providedIn: 'root'
})
export class SanbongService {

  constructor(private http: HttpClient) {
  }

  getAllList(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/sanbong')
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>('http://localhost:8080/api/sanbong/' + id);
  }

  create(sanBong: Sanbong) {
    return this.http.post('http://localhost:8080/api/sanbong/add', sanBong);
  }
}

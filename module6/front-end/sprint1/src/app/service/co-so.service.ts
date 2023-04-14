import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CoSo} from "../model/co-so";

@Injectable({
  providedIn: 'root'
})
export class CoSoService {
  URL_SEARCH = "http://localhost:8080/coso/search";

  constructor(private http: HttpClient) {
  }

  getAllList(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/coso')
  }

  getAllCoSo(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/coso/list')
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>('http://localhost:8080/coso/delete/' + id);
  }

  // http://localhost:8080/coso/search?coSoName=&coSoPerson=
  search(coSoName: string, coSoPerson: string): Observable<any> {
    return this.http.get('http://localhost:8080/coso/search?coSoName=' + coSoName + '&coSoPerson=' + coSoPerson);
  }

  add(coSo: CoSo): Observable<any> {
    return this.http.get('http://localhost:8080/coso/createCoSo' + coSo);
  }
}

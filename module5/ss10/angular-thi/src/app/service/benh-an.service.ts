import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {BenhAn} from "../model/benh-an";

@Injectable({
  providedIn: 'root'
})
export class BenhAnService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>('http://localhost:8080/benhAns');
  }

  findById(id: number): Observable<any> {
    return this.http.get<any>('http://localhost:3000/benhAn/' + id);
  }

  delete(id: number) {
    return this.http.delete<any>('http://localhost:8080/benhAns/' + id);
  }

  update(benhAn: BenhAn): Observable<any> {
    return this.http.put<any>('http://localhost:3000/benhAn/' + benhAn.id, benhAn)
  }
}

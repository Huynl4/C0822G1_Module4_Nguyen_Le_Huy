import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {TokenService} from '../service/token.service';
import {HistoryService} from '../service/history.service';
import {Oder} from '../entity/oder';
import {HistoryJson} from '../entity/history-json';
import {OrderDetail} from '../entity/order-detail';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  id = 0;
  page = 0;
  oder: Oder[] = [];
  historyPayJson!: HistoryJson;
  oderDetail: OrderDetail[] = [];

  constructor(private httpClient: HttpClient,
              private token: TokenService,
              private historyService: HistoryService) {
  }

  ngOnInit(): void {
    this.getAllHistoryPay();
  }

  getAllHistoryPay(): void {
    this.id = Number(this.token.getId());
    this.historyService.history(this.id, this.page).subscribe(next => {
      this.historyPayJson = next;
      console.log(this.historyPayJson);

    });
  }

  getAllDetail(id: number): void {
    this.historyService.detail(id).subscribe(next => {
      this.oderDetail = next;
    });
  }

  gotoPage(pageNumber: number): void {
    this.page = pageNumber;
    this.ngOnInit();
  }
}

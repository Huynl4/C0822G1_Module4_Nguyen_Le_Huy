import {Component, OnInit} from '@angular/core';
import {BenhNhan} from "../../model/benh-nhan";
import {BenhAnService} from "../../service/benh-an.service";
import {BenhAn} from "../../model/benh-an";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  benhAns: BenhAn[] = [];
  hos: BenhAn = {};

  constructor(private benhAnService: BenhAnService) {
    this.benhAnService.getAll().subscribe(next => {
      this.benhAns = next;
    })
  }

  ngOnInit(): void {
    this.benhAnService.getAll().subscribe(next => {
      this.benhAns = next;
    })
  }

  delete(id: number) {
    this.benhAnService.delete(id).subscribe(next => {
      alert("Bạn đã xóa thành công.");
      this.ngOnInit();
    })
  }

}

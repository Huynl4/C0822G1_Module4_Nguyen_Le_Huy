import {Component, OnInit} from '@angular/core';
import {SanbongService} from "../../service/sanbong.service";
import {Sanbong} from "../../entity/sanbong";
import {ManageInfoJson} from "../../entity/manage-info-json";

@Component({
  selector: 'app-san-bong',
  templateUrl: './san-bong.component.html',
  styleUrls: ['./san-bong.component.css']
})
export class SanBongComponent implements OnInit {

  sanBongList;
  // list: Sanbong[] = [];
  // nums;
  // manageInfoJson!: ManageInfoJson;
  // request = {page: 0, size: 5};
  // totalPages = 0;
  sanBong: Sanbong[] = [];
  sb: Sanbong = {};
  role = 'none';
  nums;

  constructor(private sanbongService: SanbongService) {
    this.sanbongService.getAllList().subscribe(next => {
      this.sanBong = next;
    })
  }

  ngOnInit(): void {
    this.sanbongService.getAllList().subscribe(next => {
      this.sanBong = next;
    });
    console.log("abd: " + this.sb)
  }

  delete(id: number) {
    this.sanbongService.delete(id).subscribe(next => {
      this.ngOnInit();
    })
  }

  getAll(page: number) {

  }
}

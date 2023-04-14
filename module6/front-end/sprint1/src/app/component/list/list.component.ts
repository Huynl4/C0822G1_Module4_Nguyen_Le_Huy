import {Component, OnInit} from '@angular/core';
import {CoSoService} from "../../service/co-so.service";
import {CoSo} from "../../model/co-so";
import {ICoSoDto} from "../../model/i-co-so-dto";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  coso: CoSo[] = [];
  cs: CoSo = {};
  dataList: ICoSoDto[];

  constructor(private coSoService: CoSoService) {
    // this.coSoService.getAllCoSo().subscribe(next => {
    //   this.coso = next;
    this.coSoService.getAllList().subscribe(next => {
      this.coso = next;
    })
    // })
  }

  ngOnInit(): void {
    this.coSoService.getAllCoSo().subscribe(next => {
      this.coso = next;
    })
  }

  delete(id: number) {
    console.log(id)
    this.coSoService.delete(id).subscribe(next => {
      alert("ok")
      console.log(next)
    },error => {
      alert("lỗi")
    })
  }

  searchCoSo(coSoName: string, coSoPerson: string) {
    this.coSoService.search(coSoName, coSoPerson).subscribe(next => {
      debugger
      console.log(next);
      this.dataList = next;
    })
  }
}

import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {BenhNhan} from "../../model/benh-nhan";
import {BenhAnService} from "../../service/benh-an.service";
import {Router} from "@angular/router";
import {BenhNhanService} from "../../service/benh-nhan.service";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  benhAnFrom: FormGroup
  benhNhan: BenhNhan[] = [];

  constructor(private benhAnService: BenhAnService, private router: Router, private benhNhanService: BenhNhanService) {
    this.benhAnFrom = new FormGroup({
      id: new FormControl(),
      endDate: new FormControl(),
      startDate: new FormControl(),
      method: new FormControl(),
      reason: new FormControl(),
      doctor: new FormControl(),
      benhNhan: new FormControl()
    });
    this.benhNhanService.getAllBenhNhan().subscribe(next => {
      this.benhNhan = next;
    })
  }

  ngOnInit(): void {
  }

  create() {
    if (this.benhAnFrom.valid) {
      const benhAn = this.benhAnFrom.value;
      this.benhAnService.create(benhAn).subscribe(next => {
        alert("thêm mới thành công..");
        this.router.navigateByUrl("");
      })
    }
  }
}

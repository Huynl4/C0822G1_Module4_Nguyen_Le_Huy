import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {BenhNhan} from "../../model/benh-nhan";
import {ActivatedRoute, Router} from "@angular/router";
import {BenhAnService} from "../../service/benh-an.service";
import {BenhNhanService} from "../../service/benh-nhan.service";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  id: number;
  updateFrom: FormGroup;
  benhNhan: BenhNhan[] = [];

  constructor(private activatedRoute: ActivatedRoute,
              private benhAnService: BenhAnService,
              private benhNhanService: BenhNhanService,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe(next => {
      this.id = +next.get('id');
      this.getBenhNhan(this.id);
    });
    this.benhNhanService.getAllBenhNhan().subscribe(next => {
      this.benhNhan = next;
    })
  }

  ngOnInit(): void {
  }

  getBenhNhan(number: number) {
    return this.benhAnService.findById(number).subscribe(next => {
      this.updateFrom = new FormGroup({
        id: new FormControl(next.id),
        startDate: new FormControl(next.startDate,[Validators.required]),
        endDate: new FormControl(next.endDate),
        reason: new FormControl(next.reason),
        method: new FormControl(next.method),
        doctor: new FormControl(next.doctor),
        benhNhan: new FormControl(next.benhNhan.name)
      })
    })
  }

  update() {
    const benhAn = this.updateFrom.value;
    this.benhAnService.update(benhAn).subscribe(next => {
      alert("Chỉnh sửa thành công bệnh án.");
      this.router.navigateByUrl("/list");
    })
  }
}

import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {SanbongService} from "../../service/sanbong.service";
import {Router} from "@angular/router";
import {Sanbong} from "../../entity/sanbong";
import {Khuvuc} from "../../entity/khuvuc";
import {Loaisan} from "../../entity/loaisan";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  sanBongForm: FormGroup;
  clickButton = false;
  sanBongList: Sanbong[] = [];
  khuVucList: Khuvuc[] = [];
  loaiSanList: Loaisan[] = [];

  errors = {
    name: '',
    address: '',
    khuVuc: '',
    loaiSan: '',
    time: ''
  }


  constructor(private sanbongService: SanbongService, private router: Router) {
    this.sanBongForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl("", [Validators.required]),
      address: new FormControl("", [Validators.required]),
      khuVuc: new FormControl("", [Validators.required]),
      loaiSan: new FormControl("", [Validators.required]),
      time: new FormControl("", [Validators.required]),
    });
  }

  ngOnInit(): void {
    console.log(this.khuVucList)
  }

  create() {
    if (this.sanBongForm.valid) {
      this.sanbongService.create(this.sanBongForm.value).subscribe(next => {
        this.router.navigateByUrl("");
      })
    }
  }
}

  // create() {
  //   if (this.sanBongForm.valid) {
  //     this.sanbongService.create(this.sanBongForm.value).subscribe(() => {
  //       this.router.navigateByUrl("/commodity/list")
  //       this.Swal.fire({
  //         position: 'center',
  //         title: 'Thêm mới thành công',
  //         icon: 'success',
  //         showConfirmButton: false,
  //         timer: 2000
  //       });
  //     }, error => {
  //       this.Swal.fire({
  //         position: 'center',
  //         icon: 'error',
  //         title: 'Thêm mới thất bại!',
  //         text: 'Thêm mới thất bại vui lòng điền đúng tất cả thông tin',
  //         showConfirmButton: false,
  //         timer: 2000
  //       });
  //       for (let i = 0; i < error.error.length; i++) {
  //         if (error.error && error.error[i].field === 'name') {
  //           this.errors.name = error.error[i].defaultMessage;
  //         }
  //       }
  //     })
  //   } else {
  //     this.Swal.fire({
  //       position: 'center',
  //       icon: 'error',
  //       title: 'Thêm mới thất bại!',
  //       text: 'Thêm mới thất bại vui lòng điền đúng tất cả thông tin',
  //       showConfirmButton: false,
  //       timer: 2000
  //     })
  //     this.clickButton = true;
  //   }
  // }




import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {CustomerType} from "../../../model/customer-type";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerService} from "../../../service/customer.service";
import {CustomerTypeService} from "../../../service/customer-type.service";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  id: number;
  updateForm: FormGroup;
  customerType: CustomerType[] = [];

  constructor(private activatedRoute: ActivatedRoute,
              private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe(next => {
      this.id = +next.get('id');
      this.getCustomer(this.id);
    });
    this.customerTypeService.getAllCustomertype().subscribe(next => {
      this.customerType = next;
    })
  }

  ngOnInit(): void {
  }

  getCustomer(number: number) {
    return this.customerService.findById(number).subscribe(next => {
      this.updateForm = new FormGroup({
        id: new FormControl(next.id),
        name: new FormControl(next.name),
        dateOfBirth: new FormControl(next.dateOfBirth),
        gender: new FormControl(next.gender),
        idCard: new FormControl(next.idCard),
        phoneNumber: new FormControl(next.phoneNumber),
        email: new FormControl(next.email),
        address: new FormControl(next.address),
        customerType: new FormControl(next.customerType)
      })
      // this.updateForm.patchValue(next);
    })
  }

  update() {
    const customer = this.updateForm.value;
    this.customerService.update(customer).subscribe(next => {
      alert("chỉnh sửa thành công");
      this.router.navigateByUrl("/customer")
    })
  }
  compareFun(item1, item2) {
    return item1 && item2 ? item1.id === item2.id : item1 === item2;
  }
}

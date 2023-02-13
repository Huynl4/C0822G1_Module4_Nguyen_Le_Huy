import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {CustomerType} from "../../../model/customer-type";
import {CustomerService} from "../../../service/customer.service";
import {Router} from "@angular/router";
import {CustomerTypeService} from "../../../service/customer-type.service";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customerForm: FormGroup = new FormGroup({
    name: new FormControl(),
    dateOfBirth: new FormControl(),
    gender: new FormControl(),
    idCard: new FormControl(),
    phoneNumber: new FormControl(),
    email: new FormControl(),
    address: new FormControl(),
    customerType: new FormControl()
  });
  customerType: CustomerType[] = [];

  constructor(private customerService: CustomerService, private router: Router,
              private customerTypeService: CustomerTypeService) {
    this.customerTypeService.getAllCustomertype().subscribe(next => {
      this.customerType = next;
      console.log(this.customerType);
    })
  }

  ngOnInit(): void {
  }

  submit() {
    const customer = this.customerForm.value;
    this.customerService.saveCustomer(customer).subscribe(next => {
      alert("ok");
      this.router.navigateByUrl("/customer");
    })
  }
}

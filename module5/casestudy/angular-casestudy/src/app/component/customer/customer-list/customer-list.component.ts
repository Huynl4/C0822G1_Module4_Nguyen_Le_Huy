import {Component, OnInit} from '@angular/core';
import {Customer} from "../../../model/customer";
import {CustomerService} from "../../../service/customer.service";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[] = [];
  id: number | undefined;
  cus: Customer = {};
  p = 0;

  constructor(private customerService: CustomerService) {
    this.customerService.getAll().subscribe(next => {
      this.customerList = next;
    })
  }

  ngOnInit(): void {
    this.customerService.getAll().subscribe(next => {
      this.customerList = next;
    })
  }

  delete(id: number) {
    this.customerService.delete(id).subscribe(next => {
      alert("xóa ok");
      this.ngOnInit()
    });
  }
}

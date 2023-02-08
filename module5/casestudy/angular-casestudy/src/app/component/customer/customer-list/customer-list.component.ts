import { Component, OnInit } from '@angular/core';
import {Customer} from "../../../model/customer";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
customerList: Customer[]=[
  {
    id: 1,
    name: 'Huynl4',
    dateOfBirth: '11 / 11 / 2000',
    gender: "Nam",
    idCard: 121212122,
    phoneNumber: 111111111,
    email: 'huynl4@yahoo.com',
    address: 'Canada',
    customerType: {id: 1, name: 'Nghèo'},
  },
  {
    id: 1,
    name: 'Bảo Hx',
    dateOfBirth: '11 / 11 / 2000',
    gender: "Nam",
    idCard: 121212122,
    phoneNumber: 111111111,
    email: 'huynl4@yahoo.com',
    address: 'Canada',
    customerType: {id: 1, name: 'Nghèo'},
  }
]
  constructor() { }

  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import {Facility} from "../../../model/facility";

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {
  facilityList: Facility[] = [
    {
      id: 1,
      name: "Villa Beach Front",
      area: 25000,
      cost: 1000000,
      maxPeople: 10,
      standardRoom: "vip",
      description: "Có hồ bơi",
      poolArea: 500,
      numberFloor: 4,
      facilityType: {
        id: 1,
        name: "Villa"
      },
      rentType: {
        id: 3,
        name: "Day"
      }
    },
    {
      id: 2,
      name: "House Princess 01",
      area: 14000,
      cost: 5000000,
      maxPeople: 7,
      standardRoom: "vip",
      description: "Có thêm bếp nướng",
      numberFloor: 3,
      facilityType: {
        id: 2,
        name: "House"
      },
      rentType: {
        id: 2,
        name: "Month"
      }
    }
  ];  constructor() { }

  ngOnInit(): void {
  }

}

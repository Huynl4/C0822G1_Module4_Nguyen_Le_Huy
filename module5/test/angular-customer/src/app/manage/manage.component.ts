import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user.service";
import {User} from "../model/user";

@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.css']
})
export class ManageComponent implements OnInit {
  userList;
  nums;
  ageSearch = '';
  genderSearch = '';
  private page: number;
  // temp: User = {};
  user: string = null;

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    this.getAllManageList(0);
  }

  getAllManageList(page: number) {
    this.userService.getAllManageList().subscribe(next => {
      this.userList = next;
      this.nums = Array.from(Array(next.totalPages).keys());
    });
  }

}

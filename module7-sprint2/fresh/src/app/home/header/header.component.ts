import {Component, Input, OnInit} from '@angular/core';
import {ViewportScroller} from '@angular/common';
import {TokenService} from '../../service/token.service';
import {ShareService} from '../../service/share.service';
import {LoginService} from '../../service/login.service';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  account: Account;
  isLogged = false;
  role = '';

  constructor(private scroller: ViewportScroller, private token: TokenService, private share: ShareService, private loginService: LoginService,private router: Router) {
  }

  ngOnInit(): void {
    window.scroll(0, 0);
    this.isLogged = this.token.isLogger();
    this.loadAccount();
    this.share.getClickEvent().subscribe(next => {
      this.isLogged = this.token.isLogger();
      this.loadAccount();
    });
  }

  loadAccount() {
    if (this.isLogged) {
      this.loginService.profile(this.token.getId()).subscribe(next => this.account = next);
      this.role = this.token.getRole();
    }

  }

  scrollToPosition() {
    // this.scroller.scrollToPosition([0, 800]);
  }

  logout() {
    this.token.logout();
    this.share.sendClickEvent();
    this.isLogged = false;
    Swal.fire('Đăng xuất thành công',
      '',
      'success');

  }
  @Input() searchInput: string = '';


  scrollToTopLogin() {
    window.scroll(0, 0);
  }

  onSearch() {
    this.router.navigate(['/search'],{queryParams: {'name': this.searchInput } })
  }
}

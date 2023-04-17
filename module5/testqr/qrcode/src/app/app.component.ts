import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public title = 'qrcode';
  public qrInfo = 'https://codegym.vn/tai-sao-nen-chon-codegym/?gclid=CjwKCAiA9NGfBhBvEiwAq5vSy09IdorMb5A0SsKSKbaGbVZ_HHBaStWEUzjx08bdmd0yjhwVQUI_sRoCv1kQAvD_BwE';
  public width = 300;
}

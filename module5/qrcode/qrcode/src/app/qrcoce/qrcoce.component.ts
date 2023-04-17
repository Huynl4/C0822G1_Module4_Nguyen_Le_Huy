import {Component, OnInit} from '@angular/core';
import {SafeUrl} from "@angular/platform-browser";

@Component({
  selector: 'app-qrcoce',
  templateUrl: './qrcoce.component.html',
  styleUrls: ['./qrcoce.component.css']
})
export class QrcoceComponent implements OnInit {
  public myAngularxQrCode: string = "";
  public qrCodeDownloadLink: SafeUrl = "";

  constructor() {
    this.myAngularxQrCode = 'Ready';
  }

  onChangeURL(url: SafeUrl) {
    this.qrCodeDownloadLink = url;
  }

  ngOnInit(): void {
  }

}

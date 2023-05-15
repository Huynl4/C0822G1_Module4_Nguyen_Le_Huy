import {Component, OnInit} from '@angular/core';
import {InfoService} from '../../service/info.service';
import {ProductService} from '../../service/product.service';
import {Product} from '../../entity/product';
import {ActivatedRoute} from '@angular/router';
import {Account} from '../../entity/account';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {
  idAccount: number;
  product: Product;
  account: Account[] = [];

  constructor(private info: InfoService,
              private accounts: InfoService,
              private activatedRoute: ActivatedRoute,
              private productService: ProductService) {
    this.activatedRoute.paramMap.subscribe(param => {
      this.idAccount = +param.get('id');
    });
  }

  ngOnInit(): void {
    this.accounts.findByIdAccount(this.idAccount).subscribe(next => {
      // this.account = next;
      debugger
      console.log(next);
    });
  }
}

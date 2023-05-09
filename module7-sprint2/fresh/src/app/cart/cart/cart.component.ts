import {Component, OnInit} from '@angular/core';
import {Product} from '../../entity/product';
import {CartService} from '../../service/cart.service';
import {TokenService} from '../../service/token.service';
import {Cart} from '../../entity/cart';
import Swal from 'sweetalert2';
import {ShareService} from '../../service/share.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  items: Product[] = [];
  idAccount: any;
  cartDto: Cart[] = [];
  quantity = 0;
  total = 0;
  item: any;

  constructor(private cartService: CartService,
              private tokenService: TokenService,
              private shareService: ShareService) {

  }

  ngOnInit(): void {
    this.getCartList();
  }

  // getValue(size: string) {
  //   this.total = 0;
  //   if (this.cartDto != null) {
  //     this.quantity = this.cartDto.length;
  //     for (let i = 0; i < this.cartDto.length; i++) {
  //       this.total += this.cartDto[i].product.price * this.cartDto[i].quantity;
  //     }
  //   }
  // }
  getTotal() {
    this.total = 0
    for (let i = 0; i < this.cartDto.length; i++) {
      this.total += this.cartDto[i].quantity * this.cartDto[i].product.price
    }
  }
  getValue(size: string) {
    this.total = 20000;
    if (this.cartDto != null) {
      this.quantity = this.cartDto.length;
      for (let i = 0; i < this.cartDto.length; i++) {
        if (this.cartDto[i].size == 'Một ngón' || size == 'Một ngón') {
          this.total += this.cartDto[i].product.price * this.cartDto[i].quantity;
        }
        if (this.cartDto[i].size == 'Hai ngón' || size == 'Hai ngón') {
          this.total += this.cartDto[i].product.price * this.cartDto[i].quantity + 100000 ;
        }
        if (this.cartDto[i].size == 'Ba ngón' || size == 'Ba ngón') {
          this.total += this.cartDto[i].product.price * this.cartDto[i].quantity + 250000 ;
        }
        if (this.cartDto[i].size == 'Bốn ngón' || size == 'Bốn ngón') {
          this.total += this.cartDto[i].product.price * this.cartDto[i].quantity + 500000 ;
        }
        if (this.cartDto[i].size == 'Bàn tay' || size == 'Bàn tay') {
          this.total += this.cartDto[i].product.price * this.cartDto[i].quantity + 800000 ;
        }
      }
    }
  }

  getCartList(): void {
    this.idAccount = Number(this.tokenService.getId());
    this.cartService.showAllCart(this.idAccount).subscribe(next => {
      this.cartDto = next;
      this.getTotal()
    });
  }

  setSize(size, cart: number, productId: number, productName: string) {
    for (let i = 0; i < this.cartDto.length; i++) {
      if (this.cartDto[i].size == size && this.cartDto[i].product.id == productId && this.cartDto[i].account.id == +this.tokenService.getId()) {
        Swal.fire({
          title: 'đã có size này rồi!',
          text: 'Mặt hàng: ' + '"' + productName + '"' + ' đã có size: ' + '"' + size + '"' + ' rồi nhé!',
          html: '<img src="' + this.cartDto[i].product.image + '" style="width:200px; height: 110px">',
          cancelButtonColor: '#0099FF',
          cancelButtonText: 'Đã hiểu'
        });
        this.getCartList();
        this.getValue(size);
        return;
      }
    }
    this.cartService.editCart(size, cart, productId, +this.tokenService.getId()).subscribe(next => {
      this.getCartList();
      this.getValue(size);
    });
    this.shareService.sendClickEvent();
  }

  stepUp(productId: number, size: string) {
    this.cartService.increaseQuantity(this.tokenService.getId(), productId, size).subscribe(next => {
      this.shareService.sendClickEvent();
      this.getCartList();
      this.getValue(size);
      this.getTotal()
    });
  }

  stepDown(productId: number, size: string) {
    this.cartService.reduceQuantity(this.tokenService.getId(), productId, size).subscribe(next => {
      this.shareService.sendClickEvent();
      this.getCartList();
      this.getValue(size);
      this.getTotal()
    });
  }
  deleteCart(id) {
    this.cartService.deleteCart(id).subscribe(next => {
      this.shareService.sendClickEvent();
      this.getCartList();
      this.getTotal()
    });
  }
}

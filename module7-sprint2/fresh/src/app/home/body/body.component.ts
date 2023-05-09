import {Component, Inject, OnInit} from '@angular/core';
import Swal from 'sweetalert2';
import {Product} from '../../entity/product';
import {DOCUMENT, ViewportScroller} from '@angular/common';
import {ProductService} from '../../service/product.service';
import {CartService} from '../../service/cart.service';
import {TokenService} from '../../service/token.service';
import {ShareService} from '../../service/share.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  productList: Product[] = [];
  productList1: Product[] = [];
  hasMore = false;
  page = 0;
  size = 4;
  sizeFood = '10kg'
  hasMore1 = false;
  page1 = 0;
  size1 = 4;
  displayedCount: number = 0;
  moreFruit: boolean;
  isLogged: Boolean = false;
  constructor(@Inject(DOCUMENT) private document: any,
              private viewportScroller: ViewportScroller,
              private productService: ProductService,
              private cartService: CartService,
              private token: TokenService,
              private router: Router,
              private shareService: ShareService) {
  }

  ngOnInit(): void {
    window.scroll(0, 0);
    this.loadListVegetable();
    // this.loadListFruit();
  }

  loadListVegetable() {
    this.moreFruit = false;
    this.productList = [];
    this.page = 0;
    this.productService.getProductVegetable(this.page, this.size).subscribe(products => {
      this.productList = products;
      this.hasMore = products.length === this.size;
    });
  }

  loadListFruit() {
    this.productList = null;
    this.moreFruit=true;
    this.productList = [];
    this.page1 = 0;
    this.productService.getProductFruit(this.page1, this.size1).subscribe(products => {
      this.productList = products;
      this.hasMore1 = products.length === this.size1;
    });
  }

  loadMore() {
    this.page++;
    this.productService.getProductVegetable(this.page, this.size).subscribe(products => {
      this.productList.push(...products);
      this.hasMore = products.length === this.size;
      this.displayedCount += this.page;
    });
  }

  loadMore1() {
    this.page1++;
    this.productService.getProductFruit(this.page1, this.size1).subscribe(products => {
      this.productList.push(...products);
      this.hasMore1 = products.length === this.size1;
      debugger
      this.displayedCount += this.page1;
    });
  }

  ngOnDestroy(): void {
    this.loadListVegetable();
    this.loadListFruit();
  }
  addCart(id: number) {
    let quantity =1
    // const quantity = parseInt(value)
    if(this.isLogged==true){
      Swal.fire({
        title: 'Bạn bạn hiện tại chưa đăng nhập',
        text: 'Bạn có muốn vào trang đăng nhập không?' ,
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#0099FF',
        cancelButtonColor: '#BBBBBB',
        confirmButtonText: 'Đăng nhập',
        cancelButtonText: 'Không'
      }).then((result) => {
        if (result.isConfirmed) {
          this.shareService.sendClickEvent()
          this.router.navigateByUrl('/login')
          this.ngOnInit()
        }
      });
    }else {
      this.cartService.addCart(this.token.getId(),id,quantity, this.sizeFood).subscribe(next=>{
        debugger
        Swal.fire({
          position: 'center',
          title: 'Đã thêm vào giỏ hàng thành công',
          icon: 'success',
          showConfirmButton: false,
          timer: 1000
        });
        this.shareService.sendClickEvent()
      }, error => {
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: 'Thêm mới thất bại!',
          text: 'Thêm mới thất bại',
          showConfirmButton: false,
          timer: 2000
        });
      })
    }
  }
  // addCart(id:number) {
  //   this.cartService.addCart(this.token.getIdAccount(),id,1).subscribe(next=>{
  //   })
  //   this.cartService.showAllCart(this.token.getIdAccount()).subscribe(data => {
  //     this.shareService.setCount(data.length)
  //   })
  // }
}

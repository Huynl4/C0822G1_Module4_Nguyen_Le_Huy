import {Component, Inject, OnInit} from '@angular/core';
import Swal from 'sweetalert2';
import {Product} from '../../entity/product';
import {DOCUMENT, ViewportScroller} from '@angular/common';
import {ProductService} from '../../service/product.service';

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
  hasMore1 = false;
  page1 = 0;
  size1 = 4;
  displayedCount: number = 0;
  moreFruit: boolean;

  constructor(@Inject(DOCUMENT) private document: any, private viewportScroller: ViewportScroller, private productService: ProductService) {
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
}

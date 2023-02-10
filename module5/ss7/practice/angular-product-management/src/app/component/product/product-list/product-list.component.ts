import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {Product} from '../../../model/product';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  temp: Product = {};
  products: Product[] = [];
  id: number | undefined;

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.productService.getAll().subscribe(next => {
      this.products = next;
      console.log(this.products);
    });
  }


  delete() {
    this.productService.delete(this.id).subscribe(next => {
      this.ngOnInit();
    });
  }


  deleteProduct(id: number | undefined) {
    this.id = id;
  }

  searchNameProduct(value: string) {
    this.productService.search(value).subscribe(next => {
      this.products = next;
    });
  }
}

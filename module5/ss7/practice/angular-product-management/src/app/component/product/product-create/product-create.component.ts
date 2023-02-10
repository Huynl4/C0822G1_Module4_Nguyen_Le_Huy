import {Component, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../../service/product.service";
import {Route, Router} from "@angular/router";
import {Catelory} from "../../../model/catelory";
import {CateloryService} from "../../../service/catelory.service";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup = new FormGroup({
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
    catelory: new FormControl()
  });

  catelory: Catelory[] = [];

  constructor(private productService: ProductService, private router: Router, private cateloryService: CateloryService) {
    this.cateloryService.getAllCatelory().subscribe(next => {
      this.catelory = next;
      console.log(this.catelory)
    })
  }

  ngOnInit(): void {
  }

  submit() {
    const product = this.productForm.value;
    this.productService.saveProduct(product).subscribe(next => {
      alert("ok");
      this.router.navigateByUrl("");
    });
  }
}

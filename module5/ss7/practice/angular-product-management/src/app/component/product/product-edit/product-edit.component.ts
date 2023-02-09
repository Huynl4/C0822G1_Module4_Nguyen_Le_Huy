import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {ProductService} from "../../../service/product.service";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  updateForm: FormGroup;
  id: number;

  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService) {
    this.activatedRoute.paramMap.subscribe(data => {
      this.id = +data.get("id");
      const product = this.getProduct(this.id)
      this.updateForm = new FormGroup({
        id: new FormControl(product.id),
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        description: new FormControl(product.description)
      })
    });
  }

  ngOnInit(): void {
  }


  update(id: any) {
    const product = this.updateForm.value;
    this.productService.update(id, product);
  }

   getProduct(number: number) {
    return this.productService.findById(number);
  }
}

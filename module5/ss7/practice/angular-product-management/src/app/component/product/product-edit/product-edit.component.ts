import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../../../service/product.service';
import {Product} from '../../../model/product';
import {Catelory} from '../../../model/catelory';
import {CateloryService} from '../../../service/catelory.service';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  id: number;
  updateForm: FormGroup;
  catelory: Catelory[] = [];

  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService, private cateloryService: CateloryService, private router: Router) {
    this.activatedRoute.paramMap.subscribe(data => {
      this.id = +data.get('id');
      this.getProduct(this.id);
    });
    this.cateloryService.getAllCatelory().subscribe(next => {
      this.catelory = next;
    });

  }

  ngOnInit(): void {
  }


  update(id: any) {
    const product = this.updateForm.value;
    this.productService.update(id, product).subscribe(next => {
      alert('cập nhâp ok');
      this.router.navigateByUrl('');
    });
  }

  getProduct(number: number) {
    return this.productService.findById(number).subscribe(next => {
      this.updateForm = new FormGroup({
        id: new FormControl(next.id),
        name: new FormControl(next.name),
        price: new FormControl(next.price),
        description: new FormControl(next.description),
        catelory: new FormControl(next.catelory)
      });
    });
  }

  compareFun(item1, item2) {
    return item1 && item2 ? item1.id === item2.id : item1 === item2;
  }
}

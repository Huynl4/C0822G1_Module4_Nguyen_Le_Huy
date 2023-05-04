import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {Product} from '../../entity/product';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  infoProduct: Product;

  constructor(private activatedRoute: ActivatedRoute, private productService: ProductService) {
  }

  ngOnInit(): void {
    this.view();
    this.getId();
  }

  getId() {
    this.activatedRoute.paramMap.subscribe(data => {
      console.log(data);
      const id = data.get('id');
      if (id != null) {
        this.getDetailById(+id);
      }
    });
  }

  view(): void {
    const element = document.getElementById('form');
    if (element) {
      element.scrollIntoView();
    }
  }

  private getDetailById(id: number) {
    this.productService.findProductById(id).subscribe(data => {
      console.log(data);
      this.infoProduct = data;
    });
  }
}

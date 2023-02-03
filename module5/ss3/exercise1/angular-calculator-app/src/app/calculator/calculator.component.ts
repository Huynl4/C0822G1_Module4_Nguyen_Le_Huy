import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  number1 = 0;
  number2 = 0;
  result: any;
  constructor() { }

  ngOnInit(): void {
  }
  addition() {
    this.result = this.number1 + this.number2;
  }

  subtraction() {
    this.result = this.number1 - this.number2;
  }

  multiplication() {
    this.result = this.number1 * this.number2;
  }

  division() {
    // tslint:disable-next-line:triple-equals
    if (this.number2 == 0) {
      this.result = 'Không thể chia cho 0';
    } else {
      this.result = this.number1 / this.number2;
    }
  }
}

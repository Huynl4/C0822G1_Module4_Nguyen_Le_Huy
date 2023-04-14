import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CoSoService} from "../../service/co-so.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CoSo} from "../../model/co-so";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  coSoCreateForm: FormGroup;
  coSo: CoSo;
  formAdd: any;
  errors: any;

  constructor(private router: Router,
              private coSoService: CoSoService,
              private activatedRoute: ActivatedRoute) {
    this.coSoCreateForm = new FormGroup({
      name: new FormControl(this.coSo?.name, [Validators.required]),
      dateOpen: new FormControl(this.coSo?.dateOpen, [Validators.required]),
      address: new FormControl(this.coSo?.address, [Validators.required]),
      person: new FormControl(this.coSo?.person, [Validators.required]),
    })
  }

  ngOnInit(): void {

  }

  add() {

  }
}

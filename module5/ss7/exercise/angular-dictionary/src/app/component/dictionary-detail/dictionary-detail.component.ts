import { Component, OnInit } from '@angular/core';
import {Iword} from "../../model/iword";
import {ActivatedRoute} from "@angular/router";
import {DictionaryService} from "../../service/dictionary.service";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  word: Iword | null={id:1} ;

  constructor(private activatedRoute: ActivatedRoute, private dictionaryService: DictionaryService) {

    this.activatedRoute.paramMap.subscribe(data => {
      const id = data.get("id");
      if (id != null) {
        this.word = this.dictionaryService.findById(parseInt(id));
      }
    }, error => {
    }, () => {
    })
  }

  ngOnInit(): void {
  }
}

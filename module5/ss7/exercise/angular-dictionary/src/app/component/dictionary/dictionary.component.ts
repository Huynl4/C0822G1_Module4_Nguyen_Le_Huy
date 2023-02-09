import { Component, OnInit } from '@angular/core';
import {DictionaryService} from "../../service/dictionary.service";
import {Iword} from "../../model/iword";



@Component({
  selector: 'app-dictionary',
  templateUrl: './dictionary.component.html',
  styleUrls: ['./dictionary.component.css']
})
export class DictionaryComponent implements OnInit {
  private words: Iword[];

  constructor(private dictionaryService: DictionaryService) {
    this.words=this.dictionaryService.getAll();
  }
  ngOnInit(): void {
  }

}

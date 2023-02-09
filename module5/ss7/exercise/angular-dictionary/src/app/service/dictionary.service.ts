import {Injectable} from '@angular/core';
import {Iword} from "../model/iword";


@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  words: Iword[] = [
    {id: 1, word: "dog", mean: "chó"},
    {id: 2, word: "cat", mean: "mèo"},
    {id: 3, word: "mouse", mean: "chuột"},
    {id: 4, word: "hổ", mean: "tiger"},
    {id: 5, word: "chim", mean: "bird"},
  ]

  constructor() {
  }

  getAll() {
    return this.words;
  }

  findById(number: number): Iword | null {
    let temp = this.words.filter(data => data.id === number);
    if (temp.length == 0) {
      return null;
    }
    return temp[0];
  }
}

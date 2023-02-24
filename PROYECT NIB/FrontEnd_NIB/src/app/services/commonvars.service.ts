import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommonvarsService {

  public lang:String = "";

  constructor() {}

  getLang(){
    return this.lang;
  }

  setLang(newLang:String){
    this.lang = newLang
  }
}

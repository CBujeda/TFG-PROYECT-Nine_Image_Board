import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { CommonvarsService } from 'src/app/services/commonvars.service';

@Component({
  selector: 'app-switch-lang',
  templateUrl: './switch-lang.component.html',
  styleUrls: ['./switch-lang.component.css']
})
export class SwitchLangComponent {

  constructor(public translate: TranslateService,private vars:CommonvarsService){

  }

  public selected: String = "";

  switchLang = (lang: string) => {
    this.translate.use(lang);
    this.vars.setLang(lang);
    this.setSelected();
    console.log(this.selected);

    //console.log(this.vars.getLang());
   // console.log(this.translate.currentLang);
  }

  ngOnInit(){
    this.setSelected();

  }

  setSelected(){
    let la = this.vars.getLang();
    if(la ===""){
      this.selected  = "00";
    }else{
      this.selected = la;
    }
  }

}

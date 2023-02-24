import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-switch-lang',
  templateUrl: './switch-lang.component.html',
  styleUrls: ['./switch-lang.component.css']
})
export class SwitchLangComponent {

  constructor(public translate: TranslateService){}

  switchLang = (lang: string) => {
    this.translate.use(lang);
    console.log(this.translate.currentLang);
  }

  ngOnInit(){
    console.log(this.translate.currentLang);

  }
}

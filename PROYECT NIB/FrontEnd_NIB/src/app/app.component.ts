import { Component } from '@angular/core';

import { TranslateService } from '@ngx-translate/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FrontEnd_NIB';
  constructor(
    public translate: TranslateService
  ) {
    const lang = translate.getBrowserLang();
    translate.addLangs(["es","en","ja"]);
    if((lang !== 'es') && (lang !== 'en')){
      translate.setDefaultLang('en');
    }else if(lang === 'es'){
      translate.setDefaultLang('es');
    }else if(lang === 'en'){
      translate.setDefaultLang('en');
    }else if(lang === 'ja'){
      translate.setDefaultLang('ja');
    }


  }

}

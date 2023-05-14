import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { Router } from '@angular/router';
import { SessionTokenService } from 'src/app/services/session-token.service';

@Component({
  selector: 'app-no-found',
  templateUrl: './no-found.component.html',
  styleUrls: ['./no-found.component.css']
})
export class NoFoundComponent {

  public usagi = "../../../../assets/img/usagi.png";
  public widther = "50%";
  public text = "";
  private texts = [
    "No found 😢",
    "The rabbit no found the web page (⌐■_■)",
    "シャーロック・ホームズのウサギ (●'◡'●)",
    "No encontre la paginita 😒",
    "I don't know 😭",
    "✅ I like searching the web page",
    "Tock Tock, there is no one ┑(●'◡'●)┍"];

  private isLogin: boolean = false;

  constructor(
    public translate: TranslateService,
    private sessionService: SessionTokenService,
    private router: Router
  ) {

    let token = sessionService.readToken();
    const json = { token: token};
    this.sessionService.verifyToken(json).subscribe(
      data => {
        let isCorrect = data.value;
        this.changetext();
        this.progress();
        if(isCorrect == "true" || isCorrect == true){
          this.isLogin = true;
        }else{
          this.isLogin = false;

        }
      },
      err =>{
        console.error(err);
      }
    );
  }

  public goToHomePage() {
    if(this.isLogin == true){
        this.router.navigate(['/private/home']);
    }else{
        this.router.navigate(['/home']);
    }
  }

  private async progress() {
    let count = 0;
    while(true){
      if(count == 110){
        await this.delay(500);
        count = 0;
        this.changetext();
      }
      this.widther = count + "%";
      await this.delay(1000);
      count = count + 10;
    }
  }
  private changetext(){
    this.text = this.texts[Math.floor(Math.random()* this.texts.length)];
    console.log(this.text);
  }

  private delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }
}

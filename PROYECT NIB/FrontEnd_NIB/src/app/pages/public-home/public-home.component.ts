import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-public-home',
  templateUrl: './public-home.component.html',
  styleUrls: ['./public-home.component.css']
})
export class PublicHomeComponent {

  animatedPlaceholder = '';
  predictedList: String[] = [];

  public contList: String[] = [];
  public contbasepath ="../../../assets/contador/"
  public numberCont = 0;

  constructor(
    public translate: TranslateService
  ) {
    this.setConList();
    this.placeholderAnimator();

  }

  private setConList(){
    let numbers = String(this.numberCont);
    for(let i = 0; i < numbers.length;i++){
      this.contList.push(numbers[i]+".gif")
    }
  }


  public onChangeValue(event: String){

  }



  private addWord(wordPredict:String) {
    this.predictedList.push(""
      + "<a href = \"#\" class= \"text-decoration-none \" >"
      + "<li class=\"list-group-item\" > "+wordPredict+" </li>"
      + " </a>"
      +"")
  }

  private async placeholderAnimator() {
  let values = ["girl", "bird", "boy", "bonito", "beautiful"];
  while (true) {
    for (let i = 0; i < values.length; i++) {
      let tempHolder = "";
      for (let x = 0; x < values[i].length; x++) {
        tempHolder = tempHolder + values[i][x]
        this.animatedPlaceholder = tempHolder;
        await this.delay(200);
      }
      for (let x = 0; x < 3; x++) {
        tempHolder = tempHolder + "."
        this.animatedPlaceholder = tempHolder;
        await this.delay(100);
      }
      await this.delay(1000);
    }
  }
}

  private async sleep(ms: number) {
  //Say Hello
  console.log('Hello');
  // Say World after 2000 milliseconds
  await this.delay(ms);
  console.log('Hello2');
}


  private delay(ms: number) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

}

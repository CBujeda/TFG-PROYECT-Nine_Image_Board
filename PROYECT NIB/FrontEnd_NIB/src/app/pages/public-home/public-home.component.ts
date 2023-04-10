import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { backserv } from '../../../../config';
import axios from "axios";
import { PostsService } from 'src/app/services/posts.service';
import { ConfAPPService } from 'src/app/services/conf-app.service';
@Component({
  selector: 'app-public-home',
  templateUrl: './public-home.component.html',
  styleUrls: ['./public-home.component.css']
})
export class PublicHomeComponent {

  animatedPlaceholder = '';
  predictedList: String[] = [];

  public contList: String[] = [];
  public contbasepath = "../../../assets/contador/"
  public numberCont = "0";
  public recomendedList: String[] = [];
  public nameAPP = "";

  constructor(
    public translate: TranslateService,
    private postservice: PostsService,
    private confappsevice: ConfAPPService
  ) {
    this.setConList();
    this.setNameApp();
    this.placeholderAnimator();

  }

  private setConList() {

    this.postservice.getContPosts().subscribe(
      data => {
        let numbers = String(data);
        console.log(numbers);
        this.numberCont = numbers;
        for (let i = 0; i < numbers.length; i++) {
          this.contList.push(numbers[i] + ".gif")
        }
      },
      err =>{
        console.log(err.error());
        this.contList.push("E.gif")
      }
    );
  }

  public setNameApp(){
    this.confappsevice.getNameAPP().subscribe(
      data => {
        console.log(data)
        let nombre = String(data);
        console.log(nombre)
        this.nameAPP = nombre;
      },
      err =>{
        console.log(err.error());
      }
    );
  }


  public onChangeValue(event: String) {

  }

  private addWord(wordPredict: String) {
    this.predictedList.push(""
      + "<a href = \"#\" class= \"text-decoration-none \" >"
      + "<li class=\"list-group-item\" > " + wordPredict + " </li>"
      + " </a>"
      + "")
  }

  private async placeholderAnimator() {
    let uCont = "http://" + backserv.ipnibbackserver + ":" + backserv.portnibbackserver + "/api/public/tags/random10"
    const response = await axios.get(uCont);
    let array = await response.data;
    if(array.length > 0){
      for(let i = 0; i < array.length; i ++){
        console.log(array[i].name)
        let a = String(array[i].name)
        this.recomendedList.push(a)
      }
    }
    while (true) {
      for (let i = 0; i < this.recomendedList.length; i++) {
        let tempHolder = "";
        for (let x = 0; x < this.recomendedList[i].length; x++) {
          tempHolder = tempHolder + this.recomendedList[i][x]
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
    await this.delay(ms);
  }

  private delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
  }
}

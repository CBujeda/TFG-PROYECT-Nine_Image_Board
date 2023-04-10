import { Component } from '@angular/core';
import { ConfAPPService } from 'src/app/services/conf-app.service';
@Component({
  selector: 'app-nabar-posts',
  templateUrl: './nabar-posts.component.html',
  styleUrls: ['./nabar-posts.component.css']
})
export class NabarPostsComponent {

  public shortName: string = "";



  constructor(private confappsevice: ConfAPPService){
    this.setShortNameApp();
  }


  public setShortNameApp(){
    this.confappsevice.getNameAPP("app_short_name").subscribe(
      data => {
        console.log(data)
        let nombre = String(data);
        console.log(nombre)
        this.shortName = nombre;
      },
      err =>{
        console.log(err.error());
      }
    );
  }
}

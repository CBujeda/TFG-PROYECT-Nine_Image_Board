import { Component } from '@angular/core';
import { ConfAPPService } from 'src/app/services/conf-app.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
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

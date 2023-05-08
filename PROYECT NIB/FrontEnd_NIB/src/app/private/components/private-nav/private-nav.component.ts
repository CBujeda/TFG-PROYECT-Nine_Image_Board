import { Component } from '@angular/core';
import { ConfAPPService } from 'src/app/services/conf-app.service';
import { Router } from '@angular/router';
import { SessionTokenService } from 'src/app/services/session-token.service';
@Component({
  selector: 'app-private-nav',
  templateUrl: './private-nav.component.html',
  styleUrls: ['./private-nav.component.css']
})
export class PrivateNavComponent {
  public shortName: string = "";



  constructor(
    private confappsevice: ConfAPPService,
    private sessionService: SessionTokenService,
    private router: Router){
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


  public closeSession(){
    this.sessionService.writeToken("null");
    this.router.navigate(['/']);
  }
}

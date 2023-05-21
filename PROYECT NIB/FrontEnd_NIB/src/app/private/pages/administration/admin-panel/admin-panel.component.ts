import { Component } from '@angular/core';
import { ConfAPPService } from 'src/app/services/conf-app.service';
import { SessionTokenService } from 'src/app/services/session-token.service';
@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent {
  public nameAPP = "";
  public nameAPPshort= "";

  public enabled_admin_panel = false;

  private token;

  constructor(
    private confappsevice: ConfAPPService,
    private sessionService: SessionTokenService,
  ){
    let token = sessionService.readToken();
    this.token = token;
    const json = { token: token};
    this.sessionService.verifyAdmin(json).subscribe(
      data => {
        let isCorrect = data.value;
        if(isCorrect == "true" || isCorrect == true){
          // Inizializers
          this.setConf("app_name");
          this.setConf("app_short_name");
          this.enabled_admin_panel = true;
        }else{
          this.enabled_admin_panel = false;
        }
      },
      err =>{
        console.error(err);
      }
    );


  }

  public changeConf(){
    let nameAPP = this.nameAPP;
    let app_short_name = this.nameAPPshort;

    let json = {token:this.token, appname: nameAPP, appshortname: app_short_name}
    this.confappsevice.updateConf(json).subscribe(
      data => {
        let isCorrect = data;
        console.log(isCorrect);
      },
      err =>{
        console.error(err);
      }
    );



    console.log(JSON.stringify(json));
  }

  public setConf(str:string){
    this.confappsevice.getNameAPP(str).subscribe(
      data => {
        let dato = String(data);
        if(str == "app_name"){
          this.nameAPP = dato;
        }else if(str == "app_short_name"){
          this.nameAPPshort = dato;
        }
      },
      err =>{
        console.log(err.error());
      }
    );
  }
}

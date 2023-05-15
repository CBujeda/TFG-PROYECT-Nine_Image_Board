import { Component } from '@angular/core';
import { ConfAPPService } from 'src/app/services/conf-app.service';
@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent {
  public nameAPP = "";
  public nameAPPshort= "";
  constructor(
    private confappsevice: ConfAPPService,
  ){
    this.setConf("app_name");
    this.setConf("app_short_name");
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

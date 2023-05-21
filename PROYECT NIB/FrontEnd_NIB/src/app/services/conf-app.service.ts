import { Injectable } from '@angular/core';
import { backserv } from 'config';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConfAPPService {

  constructor(private httpClient: HttpClient) { }

  public getNameAPP(type: string){
    let apiNameApp = "http://"+backserv.ipnibbackserver+":"+backserv.portnibbackserver
                    +"/api/public/conf/get?"+`type=${type}`;
    return this.httpClient.get<any>(apiNameApp);
  }

  public updateConf(json: any){
    let apiPostsCont = "http://" + backserv.ipnibbackserver + ":" + backserv.portnibbackserver + "/api/private/conf/change";
    return this.httpClient.post<any>(apiPostsCont,json)
  }
}

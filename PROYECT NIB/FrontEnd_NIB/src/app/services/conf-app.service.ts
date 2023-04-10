import { Injectable } from '@angular/core';
import { backserv } from 'config';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConfAPPService {

  constructor(private httpClient: HttpClient) { }

  public getNameAPP(){
    let apiNameApp = "http://"+backserv.ipnibbackserver+":"+backserv.portnibbackserver
                    +"/api/public/conf/name";
    return this.httpClient.get<any>(apiNameApp);
  }
}

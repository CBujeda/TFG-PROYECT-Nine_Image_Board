import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { backserv } from 'config';
@Injectable({
  providedIn: 'root'
})
export class SessionTokenService {

  constructor(private httpClient: HttpClient) { }

  private key: string = "nib_token";

  //----------------TOKEN STORAGE ----------------

  public writeToken(token: string){
    //sessionStorage.setItem(this.key, token);
    localStorage.setItem(this.key, token);
  }
  public readToken(){
    //const miDato = sessionStorage.getItem(this.key) || null;
    const miDato = localStorage.getItem(this.key) || null;
    return miDato;
  }

  // SOLICITING TOKEN TO BACKEND ----------------

  public makeLogin(json: any){
    let apiPostsCont = "http://" + backserv.ipnibbackserver + ":" + backserv.portnibbackserver + "/api/auth/login";
    return this.httpClient.post<any>(apiPostsCont,json)
  }

  public makeRegister(json: any){
    let apiPostsCont = "http://" + backserv.ipnibbackserver + ":" + backserv.portnibbackserver + "/api/auth/register";
    return this.httpClient.post<any>(apiPostsCont,json)
  }

  // Verify token to backend     ----------------

  public verifyToken(json: any){
    let apiPostsCont = "http://" + backserv.ipnibbackserver + ":" + backserv.portnibbackserver + "/api/auth/verifyToken";
    return this.httpClient.post<any>(apiPostsCont,json)
  }

  public infoUserToken(json: any){
    let apiPostsCont = "http://" + backserv.ipnibbackserver + ":" + backserv.portnibbackserver + "/api/users/get";
    return this.httpClient.post<any>(apiPostsCont,json)
  }

  public userUpdateByToken(json: any){
    let apiPostsCont = "http://" + backserv.ipnibbackserver + ":" + backserv.portnibbackserver + "/api/users/update";
    return this.httpClient.post<any>(apiPostsCont,json)
  }

  public verifyAdmin(json: any){
    let apiPostsCont = "http://" + backserv.ipnibbackserver + ":" + backserv.portnibbackserver + "/api/auth/verifyAdmin";
    return this.httpClient.post<any>(apiPostsCont,json)
  }
}

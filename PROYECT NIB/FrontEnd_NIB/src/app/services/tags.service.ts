import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { backserv } from 'config';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TagsService {

  constructor(private httpClient: HttpClient) { } //: Observable<Any>

  public tagsPages(page:number,size:number,order:string, asc: boolean){
      let apiPostsPageURL = "http://"+backserv.ipnibbackserver+":"+backserv.portnibbackserver
                    +"/api/public/tags/tagsLimited?";
      return this.httpClient.get<any>(apiPostsPageURL + `size=${size}&page=${page}&order=${order}&asc=${asc}`)
  }
}

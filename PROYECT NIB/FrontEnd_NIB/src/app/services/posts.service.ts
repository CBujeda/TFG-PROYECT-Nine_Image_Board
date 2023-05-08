import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { backserv } from 'config';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PostsService {

  constructor(private httpClient: HttpClient) { } //: Observable<Any>

  public postsPages(page:number,size:number,order:string, asc: boolean){
    let apiPostsPageURL = "http://"+backserv.ipnibbackserver+":"+backserv.portnibbackserver
                  +"/api/public/posts/postsLimited?";
    return this.httpClient.get<any>(apiPostsPageURL + `size=${size}&page=${page}&order=${order}&asc=${asc}`)
  }

  public getContPosts(){
    let apiPostsCont = "http://" + backserv.ipnibbackserver + ":" + backserv.portnibbackserver + "/api/public/posts/count";
    return this.httpClient.get<any>(apiPostsCont)
  }

  public sendNewPost(title: string, tags: string, file: String, token: string){
    console.log("Send")
    const json = { title: title, tags: tags,base64Img:file, token: token};
    let apiPostsSave = "http://" + backserv.ipnibbackserver + ":" + backserv.portnibbackserver + "/api/private/post/postnew";
    console.log(apiPostsSave)
    return this.httpClient.post<any>(apiPostsSave, json);//, { headers: headers }
  }
}

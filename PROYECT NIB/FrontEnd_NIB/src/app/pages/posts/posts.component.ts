import { Component } from '@angular/core';
import { PostsService } from '../../services/posts.service';
import { backserv } from 'config';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent {

  public posts: String[] = [];
  public page = 0;
  public size = 18;
  public order = "date";
  public asc = true;
  public imgApi = backserv.secure+"://"+backserv.ipnibbackserver+":"+backserv.portnibbackserver+"/api/image/get/";
  public searchText = "";

  constructor(private postservice:PostsService){
    this.cargar_posts();
  }

  cargar_posts(){
    this.posts = [];
    this.postservice.postsPages(this.page,this.size,this.order,this.asc).subscribe(
      data => {
        console.log(data);
        let posts = data.content
        for (let i = 0; i < posts.length; i++) {
          console.log();
          this.posts.push(posts[i].id_post);
        }
      },
      err =>{
        console.log(err.error());
      }
    );
  }

  //Searching
  submitLogin(form:NgForm) {
    let searchdata = form.value.searchdata;
    console.log(searchdata);
    if(searchdata.length >= 1) {


    }
  }



  nextPage(){
    this.page = this.page + 1;
    this.cargar_posts();
  }
  backPage(){
    if(this.page != 0){
      this.page = this.page - 1;
      this.cargar_posts();
    }
  }

}

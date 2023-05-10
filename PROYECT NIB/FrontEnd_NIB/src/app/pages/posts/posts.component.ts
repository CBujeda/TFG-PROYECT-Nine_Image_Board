import { Component } from '@angular/core';
import { PostsService } from '../../services/posts.service';
import { backserv } from 'config';
import { TagsService } from 'src/app/services/tags.service';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent {

  public posts: String[] = [];
  public tags: String[] = [];
  public page = 0;
  public size = 18;
  public order = "date";
  public asc = true;
  public imgApi = backserv.secure+"://"+backserv.ipnibbackserver+":"+backserv.portnibbackserver+"/api/image/get/";
  public searchText = "";
  private isSearch = false;

  constructor(private postservice:PostsService,private tagsService: TagsService){
    this.cargarTags();
    this.cargar_posts();

  }

  cargarTags(){
    this.tags = [];
    this.tagsService.tagsRandom()
    .subscribe(
      tags => {
        console.log(tags);
        for(let i = 0; i < tags.length; i++){
          this.tags.push(tags[i].name);
        }
      },
      err => console.log(err)
      );
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
    searchdata = this.cleanCharacters(searchdata);
    this.page = 0;
    console.log(searchdata);
    if(searchdata.length >= 1) {
      this.searchText = searchdata;
      this.isSearch = true;
      this.cargar_postsByTag();
    }else{
      this.isSearch = false;
      this.cargar_posts();
    }
  }

  cargar_postsByTag(){
    console.log()
    this.posts = [];

    this.postservice.postsPagesByTag(this.page,this.size,this.order,this.asc,this.searchText).subscribe(
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

  cleanCharacters(str:string){
    var caracteresProblema = "/ <>{}|\\^[]` +;\"%=@&$";
    var limpio = "";

    for (var i = 0; i < str.length; i++) {
      if (caracteresProblema.indexOf(str.charAt(i)) == -1) {
        limpio += str.charAt(i);
      }
    }

    return limpio;
  }


  nextPage(){
    this.page = this.page + 1;
    if(!this.isSearch){
      this.cargar_posts();
    }else{
      this.cargar_postsByTag();
    }
  }
  backPage(){
    if(this.page != 0){
      this.page = this.page - 1;
      if(!this.isSearch){
        this.cargar_posts();
      }else{
        this.cargar_postsByTag();
      }
    }
  }

}

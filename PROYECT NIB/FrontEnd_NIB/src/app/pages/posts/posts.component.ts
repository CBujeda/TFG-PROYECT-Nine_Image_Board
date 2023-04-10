import { Component } from '@angular/core';
import { PostsService } from '../../services/posts.service';

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


  constructor(private postservice:PostsService){
    this.cargar_posts();
    for(let i = 0; i < 20; i++){
      this.posts.push("");
    }

  }

  cargar_posts(){
    this.postservice.postsPages(this.page,this.size,this.order,this.asc).subscribe(
      data => {
        console.log(data);
      },
      err =>{
        console.log(err.error());
      }
    );
  }

}

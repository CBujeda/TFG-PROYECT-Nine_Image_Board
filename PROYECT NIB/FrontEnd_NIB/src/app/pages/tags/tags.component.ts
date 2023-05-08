import { Component } from '@angular/core';
import { TagsService } from 'src/app/services/tags.service';
@Component({
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css']
})
export class TagsComponent {

  public posts: String[] = [];
  public page = 0;
  public size = 5 ;
  public order = "name";
  public asc = true;
  public totalPages = 0;
  public tagsTable: String [] = []

  constructor(private tagsService: TagsService) {
    /*
    this.cargarTags();
    for(let i = 0; i < this.tagsTable.length; i++){
      console.log(this.tagsTable[i]);
    }*/
  }


  private cargarTags() {
    this.tagsService.tagsPages(this.page, this.size, this.order, this.asc)
    .subscribe(
      tags => {
        this.tagsTable = [];
        this.totalPages = tags.totalPages;
        for(let i = 0; i < tags.content.length; i++) {
          this.tagsTable.push(tags.content[i].name)
        }


      },
      err => console.log(err)
      );
  }

  public goPage(page: number){
    this.page = page;
    this.cargarTags();
  }



  public numSequence(n: number): Array<number> {
    return Array(n);
  }
}

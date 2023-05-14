import { Component } from '@angular/core';
import { TagsService } from 'src/app/services/tags.service';
import { ChangeDetectorRef } from '@angular/core';
@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css']
})
export class TagsComponent {

  public posts: String[] = [];
  public page = 0;
  public size = 100 ;
  public order = "name";
  public asc = true;
  public totalPages = 0;
  public tagsTable: String [] = []

  constructor(
    private tagsService: TagsService,
    private cdr: ChangeDetectorRef
    ) {

    this.cargarTags();
    for(let i = 0; i < this.tagsTable.length; i++){
      console.log(this.tagsTable[i]);
    }
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

  getRandomSize(): string {
    const sizes = ['xx-small', 'x-small','small','medium','large','x-large','xx-large'];
    //const sizes = ['small', 'medium', 'large'];
    let randomSize: string = "#fff";
    //setTimeout(() => {
    let randomIndex = Math.floor(Math.random() * sizes.length);
    randomSize = sizes[randomIndex];
    //this.cdr.detectChanges();
    //});
    return randomSize;
  }


  getRandomColor(): string {
    const colors = [
      '#FFB3BA', '#FFDFBA', '#BAFFC9', '#BAE1FF',
      '#BAA5FF', '#FFBAE3', '#FFDAC1', '#B2F7EF', '#FFC3A0',
      '#FFDEA0', '#A0FFB9', '#A0D1FF', '#A085FF',
      '#FFA0D9', '#FFC8B0', '#8EF1E8', '#FFA580', '#FFCB80',
      '#80FF96', '#80B3FF', '#805DFF', '#FF80BB',
      '#FFAA85', '#76E6D9', '#FF8C67', '#FFB067'
    ];
    let randomColor = "#FFFFFF";
    //setTimeout(() => {
    //Promise.resolve().then(() => {
    const randomIndex = Math.floor(Math.random() * colors.length);
    randomColor = colors[randomIndex];
    return randomColor;
  }

  public numSequence(n: number): Array<number> {
    return Array(n);
  }
}

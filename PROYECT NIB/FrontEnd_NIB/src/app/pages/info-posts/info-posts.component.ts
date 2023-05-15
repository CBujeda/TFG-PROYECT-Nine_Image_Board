import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { backserv } from 'config';
import { Location } from '@angular/common';
import { Router } from '@angular/router';
import { SessionTokenService } from 'src/app/services/session-token.service';
import { PostsService } from 'src/app/services/posts.service';
@Component({
  selector: 'app-info-posts',
  templateUrl: './info-posts.component.html',
  styleUrls: ['./info-posts.component.css']
})
export class InfoPostsComponent {

  public id: string;
  public currentURL: string;
  public isLoggedIn: boolean = false;
  public imgApi = backserv.secure + "://" + backserv.ipnibbackserver + ":" + backserv.portnibbackserver + "/api/image/get/";
  public isPopupVisible = false;

  //Post Data
  public postName: string;
  public date:string;
  public typeImage: string;
  public tags: string[] = [];

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private router: Router,
    private sessionService: SessionTokenService,
    private postService: PostsService
    ) {
    const currentUrl = this.location.path();
    this.currentURL = backserv.secure + "://" + backserv.ipnibbackserver + ":"  + backserv.portnibbackserver + currentUrl;
    this.id = "-1";
    this.postName = "";
    this.date = "";
    this.typeImage = "";


    /*----------SECURITY-----*/
    let token = sessionService.readToken();
    const json = { token: token};
    this.sessionService.verifyToken(json).subscribe(
      data => {
        let isCorrect = data.value;
        if(isCorrect == "true" || isCorrect == true){
          this.isLoggedIn = true;
        }else{
          this.isLoggedIn = false;
        }
      },
      err =>{
        console.error(err);
      }
    );
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id'];
      // Aquí puedes realizar cualquier lógica adicional con el ID recibido

      this.postService.getInfoPost(this.id).subscribe(
        response => {
        this.postName = response.img_name;
        this.date = response.date;
        this.date = this.formmaterDate(this.date);
        this.typeImage = response.extension
        this.typeImage = this.formatertype(this.typeImage);
        console.log(response);
        this.postService.getTagsByPostID(this.id).subscribe(
          response => {
          console.log(response);
            for(let i = 0; i < response.length; i++) {
              this.tags.push(response[i].name)
            }
            console.log(this.tags);
        }, error => {
          // Lógica para manejar errores
        });

      }, error => {
        // Lógica para manejar errores
      });
    });
    let link = window.location.href;
    this.currentURL = link;
    console.log(link);
  }

  private formatertype(typeString : string){
    let type : string[] = typeString.split("/");
    if(type.length == 2){
      return type[1];
    }else{
      return "png";
    }
  }

  private formmaterDate(fechaString:string){
    //const fechaString = '2023-05-14T16:30:01.863+00:00';
    const fecha = new Date(fechaString);

    const anio = fecha.getFullYear().toString().padStart(4, '0');
    const mes = (fecha.getMonth() + 1).toString().padStart(2, '0');
    const dia = fecha.getDate().toString().padStart(2, '0');

    const fechaFormateada = `${anio}Y ${mes}M ${dia}D`;
    return fechaFormateada;
  }

  copyText() {
    const input = document.getElementById("inputShared") as HTMLInputElement;
    input.select();
    input.setSelectionRange(0, 99999);
    document.execCommand("copy");
    input.blur();
  }

  redirectTag(str:String){
    if(!this.isLoggedIn){
      this.router.navigate(['/posts/'+str]);
    }else{
      this.router.navigate(['/private/posts/'+str]);
    }
  }


  getRandomColor(): string {
   /*
    const colors = [
      '#FFDFBA', '#BAFFC9', '#BAE1FF',
      '#BAA5FF', '#FFBAE3', '#FFDAC1', '#B2F7EF', '#FFC3A0',
      '#FFDEA0', '#A0FFB9', '#A0D1FF', '#A085FF',
      '#FFA0D9', '#FFC8B0', '#8EF1E8', '#FFA580', '#FFCB80',
      '#80FF96', '#80B3FF', '#805DFF', '#FF80BB',
      '#FFAA85', '#76E6D9', '#FF8C67', '#FFB067'
    ];
    const randomIndex = Math.floor(Math.random() * colors.length);*/
    return "#FFFF";// colors[randomIndex];
  }


  back(){
    if(!this.isLoggedIn){
      this.router.navigate(['/posts']);
    }else{
      this.router.navigate(['/private/posts']);
    }
  }

  downloadImage(): void {
    const imageUrl = this.imgApi + this.id;
    const fileName = 'imagen' + this.id + "."+this.typeImage;
    fetch(imageUrl)
      .then(response => response.blob())
      .then(blob => {
        const url = URL.createObjectURL(blob);
        const link = document.createElement('a');
        link.href = url;
        link.download = fileName;
        link.click();
        URL.revokeObjectURL(url);
      });
  }


  sharePopup() {
    if (this.isPopupVisible == false) {
      this.isPopupVisible = true;
    } else {
      this.isPopupVisible = false;
    }
  }
}

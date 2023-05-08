import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { SessionTokenService } from 'src/app/services/session-token.service';
import { PostsService } from 'src/app/services/posts.service';
@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent {
  public imageUrl: string = "../../../../assets/img/image_def.png";
  private selectedFile: File | undefined;
  public titulo: string = "";
  public tags: string = "";

  public errmsg: string = "";

  constructor(
    private sessionService: SessionTokenService,
    private router: Router,
    private postService: PostsService,
  ) {
    let token = sessionService.readToken();
    const json = { token: token };
    this.sessionService.verifyToken(json).subscribe(
      data => {
        let isCorrect = data.value;
        if (isCorrect == "true" || isCorrect == true) {

        } else {
          this.router.navigate(['/unautorized']);
        }

      },
      err => {
        console.error(err);
      }
    );
  }


  onFileSelected(event: Event) {
    const file: File = (event.target as HTMLInputElement).files![0];
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {
      this.selectedFile = file;
      this.imageUrl = reader.result as string;
    };
  }

  onUpload() {
    if (!this.selectedFile) {
      console.log('No file selected!');
      return;
    }
    //console.log(this.titulo,this.tags);
    const reader = new FileReader();
    reader.readAsDataURL(this.selectedFile);
    reader.onload = () => {
      const base64 = reader.result as string;
      //console.log('Base64:', base64);
      //console.log(base64.length)
      let token = this.sessionService.readToken();
      if(base64 != undefined && token != null && token != "null"){
        this.postService.sendNewPost(this.titulo, this.tags, base64, token).subscribe((response) => {
          console.log('Respuesta:', response);
          if(response == "true" || response == true){
            this.router.navigate(['/private/posts']);
          }else{
            this.errmsg = "Error al guardar el post";
          }
        }, (error) => {
          console.log('Error:', error);
        });
      }
    };
  }
}

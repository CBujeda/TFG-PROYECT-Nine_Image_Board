import { Component } from '@angular/core';
import { SessionTokenService } from 'src/app/services/session-token.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent {


  public username: string = "";
  public nombre: string = "";
  public apellido: string = "";
  public email: string = "";
  public image: string = "";
  public imageProfileDisplay: string = "../../../../assets/img/iconProfile.png";

  constructor(private sessionService: SessionTokenService,private router: Router){
    let token = sessionService.readToken();
    const json = { token: token};
    this.sessionService.verifyToken(json).subscribe(
      data => {
        let isCorrect = data.value;
        if(isCorrect == "true" || isCorrect == true){
          this.sessionService.infoUserToken(json).subscribe(
            data => {
              let usuario = data;
              console.log(usuario)
              this.username = usuario.username;
              this.nombre = usuario.nombre;
              this.email = usuario.email;
              this.apellido = usuario.apellido;
              this.image = usuario.imgProfile;
              if(this.image != "image.png"){
                this.imageProfileDisplay = this.image;
              }
            },
            err =>{
              console.error(err);
            }
          );
        }else{
          this.router.navigate(['/unautorized']);
        }
      },
      err =>{
        console.error(err);
      }
    );

  }
}

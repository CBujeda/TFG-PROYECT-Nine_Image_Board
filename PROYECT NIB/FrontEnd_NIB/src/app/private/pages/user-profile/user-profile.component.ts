import { Component } from '@angular/core';
import { SessionTokenService } from 'src/app/services/session-token.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
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
  public newpasword:string = "";
  public imageProfileDisplay: string = "../../../../assets/img/iconProfile.png";


  private token;

  constructor(private sessionService: SessionTokenService,private router: Router){
    let token = sessionService.readToken();
    this.token = token ;
    const json = { token: token};
    this.sessionService.verifyToken(json).subscribe(
      data => {
        let isCorrect = data.value;
        if(isCorrect == "true" || isCorrect == true){
          this.updateInfo();
        }else{
          this.router.navigate(['/unautorized']);
        }
      },
      err =>{
        console.error(err);
      }
    );

  }

  updateInfo(){
    const json = { token: this.token};
    this.sessionService.infoUserToken(json).subscribe(
      data => {
        let usuario = data;
        console.log(data)
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
  }


  submitUpdate(form:NgForm) {

    let image = this.image;
    this.imageProfileDisplay = image;
    console.log(image);
    let password = this.newpasword;
    let nombre = this.nombre;
    let apellidos = this.apellido;
    let token = this.token;
    //console.log(username);
    //console.log(password);
    /*
    let clear_password = password.replace(/\s/g, '');*/
    if(password == "" || password.length <= 3){
      password = "";
    }


    const json = {
      nombre: nombre,
      apellido: apellidos,
      password: password,
      imgProfile: image,
      token: token
    }
    console.log(json)

    console.log(json)
    this.sessionService.userUpdateByToken(json).subscribe(
      data => {
        const value = data.value;
        console.log(value);

      },
      err =>{
        console.error(err);
      }
    );

  }
}

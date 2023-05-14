import { Component } from '@angular/core';

import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { NgForm } from '@angular/forms';
import { SessionTokenService } from 'src/app/services/session-token.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  public msg = "";
  public showForm = false;
  constructor(private sessionService: SessionTokenService,private router: Router) {

  }

  submitRegister(form:NgForm) {
    let nombre = form.value.nombre;
    let apellido = form.value.apellidos;
    let username = form.value.usuario;
    let email = form.value.email;
    let password = form.value.passwd;

    const json = {
      username: username,
      nombre: nombre,
      apellido: apellido,
      email: email,
      password: password,
      imgProfile: "image.png"
  };


  this.sessionService.makeRegister(json).subscribe(
    data => {
      const value = data.value;
      console.log(value);
      if(value == "ERROR"){
        this.msg  = "El usuario ya existe";
        this.sessionService.writeToken("null");
      } else if(value == "ERR://401/UNATHORIZED") {
        this.msg = "Usuario no authorizado o error 501"
        this.sessionService.writeToken("null");
      }else{
        this.sessionService.writeToken(value);
        this.router.navigate(['/login']);
      }
    },
    err =>{
      console.error(err);
    }
  );
  }
}

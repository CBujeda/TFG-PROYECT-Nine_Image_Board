import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { NgForm } from '@angular/forms';
import { SessionTokenService } from 'src/app/services/session-token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  {
  public msg = "";

  constructor(private sessionService: SessionTokenService,private router: Router) {

  }

  submitLogin(form:NgForm) {
    let username = form.value.usuario;
    let password = form.value.passwd;
    console.log(username);
    console.log(password);
    const json = { username: username, password: password };

    this.sessionService.makeLogin(json).subscribe(
      data => {
        const value = data.value;
        console.log(value);
        if(value == "ERROR"){
          this.msg  = "Usuario o contraseña Invalidos";
          this.sessionService.writeToken("null");
        } else if(value == "ERR://401/UNATHORIZED") {
          this.msg = "Usuario no authorizado o error 501"
          this.sessionService.writeToken("null");
        }else{
          this.sessionService.writeToken(value);
          this.router.navigate(['/private/home']);
        }
      },
      err =>{
        console.error(err);
      }
    );
  }
}

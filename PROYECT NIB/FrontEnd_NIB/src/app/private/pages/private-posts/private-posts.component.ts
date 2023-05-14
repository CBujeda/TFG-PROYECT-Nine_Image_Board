import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { Router } from '@angular/router';
import { SessionTokenService } from 'src/app/services/session-token.service';

@Component({
  selector: 'app-private-posts',
  templateUrl: './private-posts.component.html',
  styleUrls: ['./private-posts.component.css']
})
export class PrivatePostsComponent {

  constructor(
    public translate: TranslateService,
    private sessionService: SessionTokenService,
    private router: Router
  ) {

    let token = sessionService.readToken();
    const json = { token: token};
    this.sessionService.verifyToken(json).subscribe(
      data => {
        let isCorrect = data.value;
        if(isCorrect == "true" || isCorrect == true){
          // Inizializers
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

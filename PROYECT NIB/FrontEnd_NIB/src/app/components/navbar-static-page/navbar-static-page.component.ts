import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar-static-page',
  templateUrl: './navbar-static-page.component.html',
  styleUrls: ['./navbar-static-page.component.css']
})
export class NavbarStaticPageComponent {

  public close(){
    window.self.close();
  }
}

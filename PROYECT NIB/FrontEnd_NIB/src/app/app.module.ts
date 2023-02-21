import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { PublicHomeComponent } from './pages/public-home/public-home.component';
import { TermsAndConditionsComponent } from './pages/terms-and-conditions/terms-and-conditions.component';

const appRoutes:Routes = [
  {path:"",component:PublicHomeComponent},
 {path:"login",component:LoginComponent},
 {path:"signup",component:SignupComponent},
 {path:"terms-and-conditions",component:TermsAndConditionsComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SignupComponent,
    LoginComponent,
    PublicHomeComponent,
    TermsAndConditionsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

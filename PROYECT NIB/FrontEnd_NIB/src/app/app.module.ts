import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import {HttpClient, HttpClientModule} from '@angular/common/http';

import { NavbarComponent } from './components/navbar/navbar.component';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import { RouterModule, Routes } from '@angular/router';
import { PublicHomeComponent } from './pages/public-home/public-home.component';
import { TermsAndConditionsComponent } from './pages/terms-and-conditions/terms-and-conditions.component';
import { TagsComponent } from './pages/tags/tags.component';
import { formatCurrency } from '@angular/common';
import { SwitchLangComponent } from './components/switch-lang/switch-lang.component';
import { PostsComponent } from './pages/posts/posts.component';
import { NabarPostsComponent } from './components/nabar-posts/nabar-posts.component';
import { PostcontainerComponent } from './pages/postcontainer/postcontainer.component';
import { NoFoundComponent } from './pages/system/no-found/no-found.component';
import { CreatebyComponent } from './pages/system/createby/createby.component';
import { NavbarStaticPageComponent } from './components/navbar-static-page/navbar-static-page.component';




const appRoutes:Routes = [
  {path:"",component:PublicHomeComponent},
  {path:"posts",component:PostcontainerComponent},
 {path:"login",component:LoginComponent},
 {path:"signup",component:SignupComponent},
 {path:"terms-and-conditions",component:TermsAndConditionsComponent},
 {path:"tags",component:TagsComponent},

//SPECIAL
 {path:"creadoradenibsuperkawaiipage",component:CreatebyComponent},
 {path:"**",pathMatch:"full",component:NoFoundComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SignupComponent,
    LoginComponent,
    PublicHomeComponent,
    TermsAndConditionsComponent,
    TagsComponent,
    SwitchLangComponent,
    PostsComponent,
    NabarPostsComponent,
    PostcontainerComponent,
    NoFoundComponent,
    CreatebyComponent,
    NavbarStaticPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: httpTranslateLoader,
        deps: [HttpClient]
      }
    }),
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


export function httpTranslateLoader(http: HttpClient){
return new TranslateHttpLoader(http);
}

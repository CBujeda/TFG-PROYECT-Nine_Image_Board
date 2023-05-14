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
import { FormsModule } from '@angular/forms';
import { UserProfileComponent } from './private/pages/user-profile/user-profile.component';
import { UnautorizedComponent } from './pages/unautorized/unautorized.component';
import { PrivateHomeComponent } from './private/pages/private-home/private-home.component';
import { PrivateNavComponent } from './private/components/private-nav/private-nav.component';
import { PrivatePostsComponent } from './private/pages/private-posts/private-posts.component';
import { UploadComponent } from './private/pages/upload/upload.component';
import { ContainTagsComponent } from './pages/contain-tags/contain-tags.component';
import { PrivateTagsComponent } from './private/pages/private-tags/private-tags.component';
import { InfoPostsComponent } from './pages/info-posts/info-posts.component';

const priv = "private/"

const appRoutes:Routes = [
  {path:"",component:PublicHomeComponent},
  {path:"home",component:PublicHomeComponent},
  {path:"posts",component:PostcontainerComponent},
  {path:"posts/:id",component:PostcontainerComponent},

  {path:"login",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  {path:"terms-and-conditions",component:TermsAndConditionsComponent},
  {path:"tags",component:ContainTagsComponent},

  // public and private components
  { path: 'info/post/:id', component: InfoPostsComponent },

 //private
 {path:priv+"userprofile",component:UserProfileComponent},
 {path:priv+"home",component:PrivateHomeComponent},
 {path:priv+"posts",component:PrivatePostsComponent },
 {path:priv+"upload",component:UploadComponent },
 {path:priv+"tags",component:PrivateTagsComponent },

//SPECIAL
 {path:"creadoradenibsuperkawaiipage",component:CreatebyComponent},
 {path:"unautorized",component:UnautorizedComponent},
 {path:"**",pathMatch:"full",component:NoFoundComponent},

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
    UserProfileComponent,
    UnautorizedComponent,
    PrivateHomeComponent,
    PrivateNavComponent,
    PrivatePostsComponent,
    UploadComponent,
    ContainTagsComponent,
    PrivateTagsComponent,
    InfoPostsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
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

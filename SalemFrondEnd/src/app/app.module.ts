import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateAccoutComponent } from './account/create-accout/create-accout.component';
import { AccountListComponent } from './account/account-list/account-list.component';
import { AccountInformationsComponent } from './account/account-informations/account-informations.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { FooterComponent } from './componentReusable/footer/footer.component';
import { HeaderComponent } from './componentReusable/header/header.component';
import { DonComponent } from './don/don.component';
import { HomeComponent } from './home/home.component';
import { NoPageFoundComponent } from './no-page-found/no-page-found.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateAccoutComponent,
    AccountListComponent,
    AccountInformationsComponent,
    FooterComponent,
    HeaderComponent,
    DonComponent,
    HomeComponent,
    NoPageFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

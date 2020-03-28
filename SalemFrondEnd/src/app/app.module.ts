import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateAccoutComponent } from './account/create-accout/create-accout.component';
import { AccountListComponent } from './account/account-list/account-list.component';
import { AccountInformationsComponent } from './account/account-informations/account-informations.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FooterComponent } from './componentReusable/footer/footer.component';
import { HeaderComponent } from './componentReusable/header/header.component';
import { DonComponent } from './don/don.component';
import { HomeComponent } from './home/home.component';
import { NoPageFoundComponent } from './no-page-found/no-page-found.component';
import { DonMaterielComponent } from './don-materiel/don-materiel.component';
import { DonFinancierComponent } from './don-financier/don-financier.component';
import { RemerciementComponent } from './remerciement/remerciement.component';


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
    DonMaterielComponent,
    DonFinancierComponent,
    RemerciementComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

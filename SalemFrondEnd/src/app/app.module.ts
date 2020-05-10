import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateAccoutComponent } from './account/create-accout/create-accout.component';
import { AccountListComponent } from './account/account-list/account-list.component';
import { AccountInformationsComponent } from './account/account-informations/account-informations.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FooterComponent } from './componentReusable/footer/footer.component';
import { HeaderComponent } from './componentReusable/header/header.component';
import { DonComponent } from './don/don.component';
import { HomeComponent } from './home/home.component';
import { NoPageFoundComponent } from './no-page-found/no-page-found.component';
import { DonMaterialComponent } from './don-material/don-material.component';
import { DonFinancialComponent } from './don-financial/don-financial.component';
import { RemerciementComponent } from './remerciement/remerciement.component';
import { ContactComponent } from './contact/contact.component';
import { ModalitesUtilisationComponent } from './modalites-utilisation/modalites-utilisation.component';
import { PolitiqueConfidentialiteComponent } from './politique-confidentialite/politique-confidentialite.component';
import { MissionComponent } from './mission/mission.component';
import { EquipeComponent } from './equipe/equipe.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { ErrorIntercept } from './account/errorIntercept';
import { RequestInformationComponent } from './componentReusable/request-information/request-information.component';


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
    DonMaterialComponent,
    DonFinancialComponent,
    RemerciementComponent,
    ContactComponent,
    ModalitesUtilisationComponent,
    PolitiqueConfidentialiteComponent,
    MissionComponent,
    EquipeComponent,
    CreateAccountComponent,
    SignInComponent,
    RequestInformationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorIntercept,
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccountListComponent } from './account/account-list/account-list.component';
import { CreateAccoutComponent } from './account/create-accout/create-accout.component';
import { DonComponent } from './don/don.component';
import { HomeComponent } from './home/home.component';
import { NoPageFoundComponent } from './no-page-found/no-page-found.component';
import { DonMaterielComponent } from './don-materiel/don-materiel.component';
import { DonFinancierComponent } from './don-financier/don-financier.component';
import { RemerciementComponent } from './remerciement/remerciement.component';
import { ContactComponent } from './contact/contact.component';
import { ModalitesUtilisationComponent } from './modalites-utilisation/modalites-utilisation.component';
import { PolitiqueConfidentialiteComponent } from './politique-confidentialite/politique-confidentialite.component';
import { MissionComponent } from './mission/mission.component';
import { EquipeComponent } from './equipe/equipe.component';
import { CreateAccountComponent } from './create-account/create-account.component';
import { SignInComponent } from './sign-in/sign-in.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'accounts', component: AccountListComponent, data: { title: 'accounts list' } },
  { path: 'create', component: CreateAccoutComponent, data: { title: 'create account' } },
  { path: 'don', component: DonComponent, data: { title: 'make donation' } },
  { path: 'donMateriel', component: DonMaterielComponent, data: { title: 'donation materiel' } },
  { path: 'donFinancier', component: DonFinancierComponent, data: { title: 'donation financier' } },
  { path: 'home', component: HomeComponent, data: { title: 'home page' } },
  { path: 'remerciement', component: RemerciementComponent, data: { title: 'remerciement' } },
  { path: 'contact', component: ContactComponent, data: { title: 'contact' } },
  { path: 'modaliteUtilisation', component: ModalitesUtilisationComponent, data: { title: 'modalités utilisation' } },
  { path: 'politiqueConfidentialite', component: PolitiqueConfidentialiteComponent, data: { title: 'Politique confidentialité' } },
  { path: 'mission', component: MissionComponent, data: { title: 'mission' } },
  { path: 'equipe', component: EquipeComponent, data: { title: 'equipe' } },
  { path: 'createAccount', component: CreateAccountComponent, data: { title: 'Create account' } },
  { path: 'signIn', component: SignInComponent, data: { title: 'Sign in' } },



  { path: '**', component: NoPageFoundComponent, data: { title: 'no page found' } },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

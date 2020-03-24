import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccountListComponent } from './account/account-list/account-list.component';
import { CreateAccoutComponent } from './account/create-accout/create-accout.component';
import { DonComponent } from './don/don.component';
import { HomeComponent } from './home/home.component';
import { NoPageFoundComponent } from './no-page-found/no-page-found.component';
import { DonMaterielComponent } from './don-materiel/don-materiel.component';
import { DonFinancierComponent } from './don-financier/don-financier.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'accounts', component: AccountListComponent, data: { title: 'accounts list' } },
  { path: 'create', component: CreateAccoutComponent, data: { title: 'create account' } },
  { path: 'don', component: DonComponent, data: { title: 'make donation' } },
  { path: 'donMateriel', component: DonMaterielComponent, data: { title: 'donation materiel' } },
  { path: 'donFinancier', component: DonFinancierComponent, data: { title: 'donation financier' } },
  { path: 'home', component: HomeComponent, data: { title: 'home page' } },
  { path: '**', component: NoPageFoundComponent, data: { title: 'no page found' } },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

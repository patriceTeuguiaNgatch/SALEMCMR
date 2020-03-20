import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccountListComponent } from './account/account-list/account-list.component';
import { CreateAccoutComponent } from './account/create-accout/create-accout.component';


const routes: Routes = [
  { path: '', redirectTo: '', pathMatch: 'full' },
  { path: 'accounts', component: AccountListComponent, data: { title: 'accounts list' } },
  { path: 'create', component: CreateAccoutComponent, data: { title: 'create account' } }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

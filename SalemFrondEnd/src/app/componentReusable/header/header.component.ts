import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  aPropos = 'A propos';
  donner = 'Donner';
  acceuil = 'Accueil';
  codeEthique = 'Code éthique';
  mission = 'Mission';
  contact = 'Contact';
  don = 'Faire un don';
  imageMenu = '/assets/image/image1.png';
  signIn = 'Se connecter';
  registration = "S'inscrire";
  information = 'Information'
  logOut = 'Deconnexion';
  null = '';

  @Input() isRegistrationValue: boolean;
  @Input() isLogOutValue: boolean;
  @Input() isSignInValue: boolean;

  constructor() { }

  ngOnInit(): void {
  }
}

import { Component, OnInit, Input, ViewChild, ElementRef, HostListener } from '@angular/core';
import { Router } from '@angular/router';

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
  signIn = 'Se connecter';
  registration = "S'inscrire";
  information = 'Information'
  logOut = 'Deconnexion';
  null = '';

  @Input() isRegistrationValue: boolean;
  @Input() isLogOutValue: boolean;
  @Input() isSignInValue: boolean;

  @ViewChild('navBurger') navBurger: ElementRef;
  @ViewChild('navMenu') navMenu: ElementRef;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  toggleNavbar() {
    this.navBurger.nativeElement.classList.toggle('is-active');
    this.navMenu.nativeElement.classList.toggle('is-active');
  }

  createAccount() {
    this.router.navigate(['createAccount'])
  }
}
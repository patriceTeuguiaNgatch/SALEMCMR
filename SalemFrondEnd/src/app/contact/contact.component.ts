import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SalemInformation } from '../domain/SalemInformation';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  salemInformation = new SalemInformation();
  title = this.salemInformation.title;
  adresse = this.salemInformation.adresse;
  phoneNumber = this.salemInformation.phonNumber;
  email = this.salemInformation.email;
  siteLink = this.salemInformation.siteLink
  facebookLink = this.salemInformation.facebookLink;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  gotToHome() {
    this.router.navigate(['home']);
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SalemInformation } from '../domain/SalemInformation';

@Component({
  selector: 'app-modalites-utilisation',
  templateUrl: './modalites-utilisation.component.html',
  styleUrls: ['./modalites-utilisation.component.css']
})
export class ModalitesUtilisationComponent implements OnInit {

  constructor(private router: Router) { }
  salemInformation = new SalemInformation();
  siteName = this.salemInformation.siteName;
  title = this.salemInformation.title;

  ngOnInit(): void {
  }
  gotToHome() {
    this.router.navigate(['home']);
  }

}

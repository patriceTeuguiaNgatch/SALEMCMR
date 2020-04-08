import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SalemInformation } from '../domain/SalemInformation';

@Component({
  selector: 'app-politique-confidentialite',
  templateUrl: './politique-confidentialite.component.html',
  styleUrls: ['./politique-confidentialite.component.css']
})
export class PolitiqueConfidentialiteComponent implements OnInit {

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

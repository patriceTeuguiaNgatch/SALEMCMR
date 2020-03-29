import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SalemInformation } from '../domain/SalemInformation';

@Component({
  selector: 'app-don',
  templateUrl: './don.component.html',
  styleUrls: ['./don.component.css']
})
export class DonComponent implements OnInit {

  salemInformation = new SalemInformation();
  adresse = this.salemInformation.adresse;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  goToDonFinancier() {
    this.router.navigate(['donFinancier'])
  }

  goToDonMateriel() {
    this.router.navigate(['donMateriel'])
  }

}

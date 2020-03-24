import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-don',
  templateUrl: './don.component.html',
  styleUrls: ['./don.component.css']
})
export class DonComponent implements OnInit {

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

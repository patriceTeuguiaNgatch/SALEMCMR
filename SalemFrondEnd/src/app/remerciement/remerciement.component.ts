import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-remerciement',
  templateUrl: './remerciement.component.html',
  styleUrls: ['./remerciement.component.css']
})
export class RemerciementComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  gotToHome() {
    this.router.navigate(['home']);
  }
}

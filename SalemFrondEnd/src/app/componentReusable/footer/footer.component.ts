import { Component, OnInit } from '@angular/core';
import { SalemInformation } from 'src/app/domain/SalemInformation';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  salemInformation = new SalemInformation();
  title = this.salemInformation.title;
  adresse = this.salemInformation.adresse;
  phoneNumber = this.salemInformation.phonNumber;
  email = this.salemInformation.email;
  null = '';
  constructor() { }

  ngOnInit(): void {
  }

}

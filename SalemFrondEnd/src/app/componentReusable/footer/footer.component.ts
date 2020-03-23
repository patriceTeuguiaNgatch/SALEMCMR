import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  title = 'Salem';
  adresse = 'XX  Douala Cameroun'
  telephonNumber = '(237)XXXXXXXXXXXX';
  email = 'salem@gmail.com'
  null = '';
  constructor() { }

  ngOnInit(): void {
  }

}

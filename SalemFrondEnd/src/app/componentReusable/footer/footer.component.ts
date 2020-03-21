import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  title = 'Salem';
  town = 'Douala';
  country = 'Cameroun';
  boitePostale = 'BP : XX '
  telephonNumber1 = '(237) XXXXXXXXXXXXXX';
  email = 'salem@getMaxListeners.com'

  constructor() { }

  ngOnInit(): void {
  }

}

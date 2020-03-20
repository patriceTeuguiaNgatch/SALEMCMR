import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Salem';

  constructor(private router: Router) { }
  list() {
    console.log("dans le onclick")
    this.router.navigate(['']);
  }
}

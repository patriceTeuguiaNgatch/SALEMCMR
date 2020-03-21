import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  listImage = ["/assets/image/image0.png", "/assets/image/image1.png", "/assets/image/image2.png", "/assets/image/image3.png", "/assets/image/image4.png", "/assets/image/image5.png", "/assets/image/image6.png"]
  currentPositionImage = 0;

  constructor(private router: Router) { }
  list() {
    console.log("dans le onclick")
    this.router.navigate(['']);
  }

  onClickRight() {
    let value = this.currentPositionImage + 1;
    if (value < this.listImage.length) {
      this.currentPositionImage = value;
    } else {
      this.currentPositionImage = 0;
    }
    console.log("dans le onclick ri " + this.currentPositionImage);
  }

  onClickLeft() {
    let value = this.currentPositionImage - 1;
    if (value > 0) {
      this.currentPositionImage = value;
    } else {
      this.currentPositionImage = this.listImage.length - 1;
    }
    console.log("dans le onclick left " + this.currentPositionImage);
  }
}

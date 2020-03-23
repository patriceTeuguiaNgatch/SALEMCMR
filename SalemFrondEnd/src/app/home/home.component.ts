import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  listImage = ["/assets/image/image0.png", "/assets/image/image1.png", "/assets/image/image2.png", "/assets/image/image3.png", "/assets/image/image4.png", "/assets/image/image5.png", "/assets/image/image6.png"]
  currentPositionImage = 0;

  constructor() { }

  ngOnInit(): void {
  }
  onClickRight() {
    let value = this.currentPositionImage + 1;
    if (value < this.listImage.length) {
      this.currentPositionImage = value;
    } else {
      this.currentPositionImage = 0;
    }
  }

  onClickLeft() {
    let value = this.currentPositionImage - 1;
    if (value > 0) {
      this.currentPositionImage = value;
    } else {
      this.currentPositionImage = this.listImage.length - 1;
    }
  }
}

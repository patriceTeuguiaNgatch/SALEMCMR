import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  listPicture = ["/assets/image/image0.png", "/assets/image/image1.png", "/assets/image/image2.png", "/assets/image/image3.png", "/assets/image/image4.png", "/assets/image/image5.png", "/assets/image/image6.png"]
  listTextPicture = ["/assets/image/image0. gjhghjgjh gjhgjgjhgjhg jhgjhg jhg jhg hgfyfy t yttypng", "/assets/image/image1. gjhghjgjh gjhgjgjhgjhg jhgjhg jhg jhg hgfyfy t yttypng png", "/assets/image/image2. gjhghjgjh gjhgjgjhgjhg jhgjhg jhg jhg hgfyfy t yttypng png", "/assets/image/image3. gjhghjgjh gjhgjgjhgjhg jhgjhg jhg jhg hgfyfy t yttypng png", "/assets/image/image4 gjhghjgjh gjhgjgjhgjhg jhgjhg jhg jhg hgfyfy t yttypng .png", "/assets/image/image5 gjhghjgjh gjhgjgjhgjhg jhgjhg jhg jhg hgfyfy t yttypng .png", "/assets/image/image6. gjhghjgjh gjhgjgjhgjhg jhgjhg jhg jhg hgfyfy t yttypngpng"]

  currentPositionPicture = 0;

  constructor() { }

  ngOnInit(): void {
  }
  onClickRight() {
    let value = this.currentPositionPicture + 1;
    if (value < this.listPicture.length) {
      this.currentPositionPicture = value;
    } else {
      this.currentPositionPicture = 0;
    }
  }

  onClickLeft() {
    let value = this.currentPositionPicture - 1;
    if (value > 0) {
      this.currentPositionPicture = value;
    } else {
      this.currentPositionPicture = this.listPicture.length - 1;
    }
  }
}

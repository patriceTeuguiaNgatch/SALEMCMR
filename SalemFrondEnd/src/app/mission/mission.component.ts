import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mission',
  templateUrl: './mission.component.html',
  styleUrls: ['./mission.component.css']
})
export class MissionComponent implements OnInit {

  listPicture = ["/assets/image/image0.png", "/assets/image/image1.png", "/assets/image/image2.png", "/assets/image/image3.png", "/assets/image/image4.png", "/assets/image/image5.png", "/assets/image/image6.png"]


  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  goToDon() {
    this.router.navigate(['don'])
  }
}

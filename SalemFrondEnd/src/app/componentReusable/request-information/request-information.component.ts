import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountService } from 'src/app/account/account.service';
import { RequestInformationDto } from 'src/app/dto/requestInformationDto';

@Component({
  selector: 'app-request-information',
  templateUrl: './request-information.component.html',
  styleUrls: ['./request-information.component.css']
})
export class RequestInformationComponent implements OnInit {

  inputFirstName = 'Saisir le nom'; // Input first name
  inputLastName = 'Saisir le prenom'; //  Input last name
  inputEmail = 'Saisir le courriel';
  thisEmailIsInvalid = "S'il vous plaît entrez un courriel est invalide"; // This email is invalid
  emailIsrequired = 'Email est requis';
  comment = 'commentaires';
  inputMessage = 'Saisir le message de moins de 200 caractères'; // input message

  maximumLenghtComment: number = 200;
  minimunLenghtComment: number = 6;

  errorMessage: string;
  httpStatus: string;
  hasError: boolean = false;
  requestInformationDto: RequestInformationDto = new RequestInformationDto();

  constructor(private accountService: AccountService, private router: Router) { }

  ngOnInit(): void {
  }


  form = new FormGroup({
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    phoneNumber: new FormControl(''),
    comment: new FormControl('', [Validators.required, Validators.minLength(this.minimunLenghtComment), Validators.maxLength(this.maximumLenghtComment)]),
  });


  get validation() {
    return this.form.controls;
  }


  sendMessage() {
    this.accountService.sendRequestInformation(this.requestInformationDto).subscribe(response => {

      this.httpStatus = response.httpStatus;
      if (this.isSend()) {
        console.log(response);
        this.gotoHome();
      } else {
        this.updateErrorParamater();
      }
    },
      error => {
        console.log(error);
        this.updateErrorParamater();
      });

    this.accountService.sendMessageInformation(this.requestInformationDto).subscribe(response => {
      this.httpStatus = response.httpStatus;
      if (this.isSend()) {
        console.log(response);
      } else {
      }
    },
      error => {
        console.log(error);
      });

    this.requestInformationDto = new RequestInformationDto();

  }

  submit() {

    if (this.form.status === 'VALID') {
      this.requestInformationDto.setFirstName(this.form.value.firstName);
      this.requestInformationDto.setLastName(this.form.value.lastName);
      this.requestInformationDto.setEmail(this.form.value.email);
      this.requestInformationDto.setPhoneNumber(this.form.value.phoneNumber);
      this.requestInformationDto.setComment(this.form.value.comment);
      this.sendMessage();
    }
  }

  isSend() {
    return this.httpStatus === "201 CREATED";
  }

  gotoHome() {
    this.router.navigate(['home']);
  }

  updateErrorParamater() {
    this.hasError = true;
    this.errorMessage = "Désolé un erreur est survenue, essayez encore"
  }

}


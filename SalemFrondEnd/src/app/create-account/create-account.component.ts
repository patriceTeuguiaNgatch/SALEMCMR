import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AccountService } from '../account/account.service';
import { AccountRegistrationDto } from '../dto/accountRegistrationDto';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  inputFirstName: string = 'Saisir le nom'; // Input first name
  inputLastName: string = 'Saisir le prenom'; //  Input last name
  inputPassword: string = 'Saisir le mot de passe'; //  Input password
  inputEmail: string = 'Saisir le courriel';
  thisEmailIsInvalid: string = "S'il vous plaît entrez un courriel est invalide"; // This email is invalid
  emailIsrequired: string = 'Email est requis';

  pictureCreateAccount: string = "/assets/image/pictureCreateAccount.png"
  minimunLenghtPassword: number = 6;
  errorMessage: string;
  httpStatus: string;
  hasError: boolean = false;
  accountRegistrationDto: AccountRegistrationDto = new AccountRegistrationDto();

  constructor(private accountService: AccountService, private router: Router) { }

  ngOnInit(): void {
  }

  form = new FormGroup({
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required, Validators.minLength(this.minimunLenghtPassword)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    phoneNumber: new FormControl(''),
  });

  get validation() {
    return this.form.controls;
  }

  save() {

    this.accountService.createAccount(this.accountRegistrationDto).subscribe(response => {

      this.httpStatus = response.httpStatus;
      if (this.iscreated()) {

        this.gotoSigIn();
      } else {
        this.updateErrorParamater();
      }
    },
      error => {

        console.log(error);
        this.updateErrorParamater();
      });
    this.accountRegistrationDto = new AccountRegistrationDto();
  }

  submit() {

    if (this.form.status === 'VALID') {
      this.accountRegistrationDto.setFirstName(this.form.value.firstName);
      this.accountRegistrationDto.setLastName(this.form.value.lastName);
      this.accountRegistrationDto.setPassword(this.form.value.password);
      this.accountRegistrationDto.setEmail(this.form.value.email);
      this.accountRegistrationDto.setPhoneNumber(this.form.value.phoneNumber);
      this.save();
    }
  }

  gotoSigIn() {
    this.router.navigate(['signIn']);
  }

  iscreated() {
    return this.httpStatus === "201 CREATED";
  }

  updateErrorParamater() {
    this.hasError = true;
    this.errorMessage = "Désolé un erreur est survenue, essayez encore"
  }

}

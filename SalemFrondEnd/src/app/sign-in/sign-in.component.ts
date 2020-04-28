import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AccountService } from '../account/account.service';
import { AccountSingInDto } from '../dto/accountSingIn';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  inputPassword: string = 'Saisir le mot de passe'; //  Input password
  inputEmail: string = 'Saisir le courriel';
  thisEmailIsInvalid: string = "S'il vous plaît entrez un courriel est invalide"; // This email is invalid
  emailIsrequired: string = 'Email est requis';

  pictureCreateAccount: string = "/assets/image/pictureCreateAccount.png"
  minimunLenghtPassword: number = 6;
  errorMessage: string;
  httpStatus: string;
  hasError: boolean = false;
  accountSingIn: AccountSingInDto = new AccountSingInDto();

  constructor(private accountService: AccountService, private router: Router) { }

  ngOnInit(): void {
  }

  form = new FormGroup({
    password: new FormControl('', [Validators.required, Validators.minLength(this.minimunLenghtPassword)]),
    email: new FormControl('', [Validators.required, Validators.email]),
  });

  get validation() {
    return this.form.controls;
  }

  save() {

    this.accountService.singIn(this.accountSingIn).subscribe(response => {

      this.httpStatus = response.httpStatus;
      if (this.isPresent() || this.isExist()) {
        console.log(response);
        this.gotoHome();
      } else {
        console.log(response);
        this.updateErrorParamater();
      }
    },
      error => {

        console.log(error);
        this.updateErrorParamater();
      });
    this.accountSingIn = new AccountSingInDto();
  }

  submit() {

    if (this.form.status === 'VALID') {
      this.accountSingIn.setPassword(this.form.value.password);
      this.accountSingIn.setEmail(this.form.value.email);
      this.save();
    }
  }

  gotoHome() {
    this.router.navigate(['home']);
  }

  isPresent() {
    return this.httpStatus === "200 OK";
  }
  isExist() {
    return this.httpStatus === "302 FOUND";
  }

  updateErrorParamater() {
    this.hasError = true;
    this.errorMessage = "Désolé un erreur est survenue, essayez encore"
  }


}

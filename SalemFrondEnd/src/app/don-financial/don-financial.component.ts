import { Component, OnInit, NgZone } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountService } from '../account/account.service';
import { DonFinancialRegistrationDto } from '../dto/donFinancialRequestDto';

@Component({
  selector: 'app-don-financier',
  templateUrl: './don-financial.component.html',
  styleUrls: ['./don-financial.component.css']
})
export class DonFinancialComponent implements OnInit {

  firstName = 'Nom';
  inputFirstName = 'Saisir le nom'; // Input first name
  lastName = 'Prenom';
  inputLastName = 'Saisir le prenom'; //  Input last name
  email = 'Email';
  inputEmail = 'Saisir le courriel';
  thisEmailIsInvalid = "S'il vous plaît entrez un courriel est invalide"; // This email is invalid
  emailIsrequired = 'Email est requis';
  reason = 'Nature'; // Reason
  inputCreditCard = 'Saisir le numero de carte de credit ou débit';
  creditInformation = "Carte bancaire";
  expirationYear = "Année";
  inputYear = "Saisir l'année (AAAA)";
  expirationMonth = "Mois";
  inputMonth = "Saisir le mois (MM)"
  cvc = "CVC";
  inputCvc = "Saisir le CVC";
  value = "Montant";
  inputvalue = "Saisir le montant";
  currency = "Devise";
  inputcurrency = "Saisir la devise";
  comment = 'commentaires';
  inputMessage = 'Saisir le message de moins de 100 caractères'; // input message
  identification = 'Identification';
  informationSurLeDon = 'Information sur le don';
  confidentialite = 'Confidentialité';
  property = 'Propriété';

  isEmailInvalid = true;
  reasonList: any = ["Education des enfants", "Foire des livres",
    "Aide financiere aux demunis", "soutien morale ou phychologique"];

  currencyList: any = [{ name: "Dollar US ($)", symbol: "usd" }, { name: "Dollar CAD ($)", symbol: "cad" },
  { name: "Euro EUR (€)", symbol: "eur" }, { name: "Livre sterling GBP (£)", symbol: "gbp" },
  { name: "Yen JPY ( ¥)", symbol: "jpy" }, { name: "Yuan CNY (¥)", symbol: "cny" }];

  errorMessage: string;
  httpStatus: string;

  hasError: boolean = false;

  donFinancialRegistrationDto: DonFinancialRegistrationDto = new DonFinancialRegistrationDto();

  constructor(private accountService: AccountService, private router: Router, private ngZone: NgZone) { }


  ngOnInit(): void {
  }

  form = new FormGroup({
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    creditCard: new FormControl('', [Validators.required]),
    value: new FormControl('', [Validators.required]),
    currency: new FormControl('', [Validators.required]),
    expirationYear: new FormControl('', [Validators.required]),
    expirationMonth: new FormControl('', [Validators.required]),
    cvc: new FormControl('', [Validators.required]),
    kind: new FormControl(''),
    comment: new FormControl(''),
    isConfidential: new FormControl(false),

  });

  get validation() {
    return this.form.controls;
  }

  save() {

    this.accountService.createDonFinancial(this.donFinancialRegistrationDto).subscribe(response => {
      this.httpStatus = response.httpStatus;
      console.log("status value : " + this.httpStatus)
      if (this.isCreated()) {
        console.log(response);
        this.gotToRemerciement();
      } else {
        console.log(response);
        this.updateErrorParamater();
      }
    },
      error => {

        console.log(error);
        this.updateErrorParamater();
      });
    this.donFinancialRegistrationDto = new DonFinancialRegistrationDto();

  }

  submit() {
    if (this.form.status === 'VALID') {
      this.donFinancialRegistrationDto.setFirstName(this.form.value.firstName);
      this.donFinancialRegistrationDto.setLastName(this.form.value.lastName);
      this.donFinancialRegistrationDto.setEmail(this.form.value.email);
      this.donFinancialRegistrationDto.setValue(this.form.value.value);
      this.donFinancialRegistrationDto.setCurrency(this.convertToSymbol(this.form.value.currency));
      this.donFinancialRegistrationDto.setPhoneNumber(this.form.value.phoneNumber);
      this.donFinancialRegistrationDto.setkind(this.form.value.kind);
      this.donFinancialRegistrationDto.setComment(this.form.value.comment);
      this.donFinancialRegistrationDto.setIsConfidential(this.form.value.isConfidential);

      (<any>window).Stripe.card.createToken({
        number: this.form.value.creditCard,
        exp_month: this.form.value.expirationMonth,
        exp_year: this.form.value.expirationYear,
        cvc: this.form.value.cvc,
      }, (status: number, response: any) => {
        this.ngZone.run(() => {
          if (status === 200) {
            this.donFinancialRegistrationDto.setToken(response.id);

            console.log(this.donFinancialRegistrationDto);

            this.save();

          } else {
            console.log(response.error.message);
            this.updateErrorParamater();
          }
        })
      });

    }
  }

  gotToDon() {
    this.router.navigate(['don']);
  }

  gotToRemerciement() {
    this.router.navigate(['remerciement']);
  }

  isCreated() {
    return this.httpStatus === "201 CREATED";
  }

  updateErrorParamater() {
    this.hasError = true;
    this.errorMessage = "Désolé un erreur est survenue, essayez encore";
  }

  convertToSymbol(name: string) {

    for (let currency of this.currencyList) {
      if (currency.name === name) {
        return currency.symbol;
      }
    }
  }

}

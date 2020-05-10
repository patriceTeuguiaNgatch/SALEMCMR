import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AccountService } from '../account/account.service';
import { DonMaterialRegistrationDto } from '../dto/donRegistrationDto';

@Component({
  selector: 'app-don-material',
  templateUrl: './don-material.component.html',
  styleUrls: ['./don-material.component.css']
})
export class DonMaterialComponent implements OnInit {

  firstName = 'Nom';
  inputFirstName = 'Saisir le nom'; // Input first name
  lastName = 'Prenom';
  inputLastName = 'Saisir le prenom'; //  Input last name
  email = 'Email';
  inputEmail = 'Saisir le courriel';
  thisEmailIsInvalid = "S'il vous plaît entrez un courriel est invalide"; // This email is invalid
  emailIsrequired = 'Email est requis';
  reason = 'Nature'; // Reason
  comment = 'commentaires';
  inputMessage = 'Saisir le message de moins de 100 caractères'; // input message
  identification = 'Identification';
  adresse = 'Adresse';
  informationSurLeDon = 'Information sur le don';
  confidentialite = 'Confidentialité';
  informationAdresse = "Information"
  numeroRueAppartement = 'Numero, Rue '
  town = 'Ville';
  inputTown = 'Saisir la ville';
  postalCode = 'Code postal';
  inputPostalCode = 'Saisir le code postal';
  country = 'Pays';
  phoneNumber = 'Téléphone';
  property = 'Propriété';


  isEmailInvalid = true;
  reasonList: any = ["Education des enfants", "Foire des livres",
    "Aide financiere aux demunis", "soutien morale ou phychologique"];

  countryList: any = ["Afghanistan", "Afrique du Sud", "Albanie", "Algérie", "Allemagne",
    "Andorre", "Angola", "Anguilla", "Antigua - et - Barbuda", "Arabie saoudite",
    "Argentine", "Arménie", "Aruba", "Australie", "Autriche", "Azerbaïdjan", "Bahamas",
    "Bahreïn", "Bangladesh", "Barbade", "Belgique", "Belize", "Bénin", "Bermudes",
    "Bhoutan", "Biélorussie", "Birmanie", "Bolivie", "Bosnie - Herzégovine", "Botswana",
    "Brésil", "Brunei", "Bulgarie", "Burkina Faso", "Burundi", "Cambodge", "Cameroun",
    "Canada", "Cap - Vert", "Chili", "Chine", "Chypre", "Colombie", "Comores",
    "République démocratique du Congo", "République du Congo", "Corée du Nord",
    "Corée du Sud", "Costa Rica", "Côte d'Ivoire", "Croatie", "Cuba", "Curacao", "Danemark",
    "Djibouti", "République dominicaine", "Dominique", "Égypte", "Émirats arabes unis",
    "Équateur", "Érythrée", "Espagne", "Estonie", "États - Unis", "Éthiopie", "Îles Féroé",
    "Fidji", "Finlande", "France", "Gabon", "Gambie", "Géorgie", "Ghana", "Gibraltar", "Grèce",
    "Grenade", "Groenland", "Guadeloupe", "Guam", "Guatemala", "Guinée", "Guinée équatoriale",
    "Guinée - Bissao", "Guyana", "Guyane", "Haïti", "Honduras", "Hong Kong", "Hongrie",
    "Inde", "Indonésie", "Irak", "Iran", "Irlande", "Islande", "Israël", "Italie", "Jamaïque",
    "Japon", "Jordanie", "Kazakhstan", "Kenya", "Kirghizistan", "Kiribati", "Kosovo", "Koweït",
    "Laos", "Lesotho", "Lettonie", "Liban", "Liberia", "Libye", "Liechtenstein", "Lituanie",
    "Luxembourg", "Macao", "Macédoine", "Madagascar", "Malaisie", "Malawi", "Maldives",
    "Mali", "Malouines", "Malte", "Mariannes du Nord", "Maroc", "Îles Marshall", "Martinique",
    "Maurice", "Mauritanie", "Mayotte", "Mexique", "Micronésie", "Moldavie", "Monaco", "Mongolie",
    "Monténégro", "Montserrat", "Mozambique", "Namibie", "Nauru", "Népal", "Nicaragua", "Niger",
    "Nigeria", "Niue", "Norvège", "Nouvelle - Calédonie", "Nouvelle - Zélande", "Oman",
    "Ouganda", "Ouzbékistan", "Pakistan", "Palaos", "Palestine", "Panama",
    "Papouasie - Nouvelle - Guinée", "Paraguay", "Pays - Bas", "Pays-Bas caribéens", "Pérou",
    "Philippines", "Pays - Bas caribéens", "Pologne", "Polynésie française", "Porto Rico",
    "Portugal", "Qatar", "Pays-Bas caribéens", "Roumanie", "Royaume - Uni", "Russie",
    "Rwanda", "Saint - Christophe - et - Niévès", "Sainte-Hélène, Ascension et Tristan da Cunha",
    "Sainte - Lucie", "Saint - Marin", "Saint - Martin", "Saint - Pierre - et - Miquelon",
    "Saint - Vincent - et - les - Grenadines", "Salomon", "Salvador", "Samoa", "Samoa américaines",
    "Sao Tomé - et - Principe", "Sénégal", "Serbie", "Seychelles", "Sierra Leone", "Singapour",
    "Sint Maarten", "Slovaquie", "Slovénie", "Somalie", "Soudan", "Soudan du Sud", "Sri Lanka",
    "Suède", "Suisse", "Suriname", "Swaziland,", "Syrie", "Tadjikistan", "Tanzanie", "Taïwan ",
    "Tchad", "République tchèque", "Territoire britannique de l'Océan Indien", "Thaïlande",
    "Timor Oriental", "Togo", "Tokélaou", "Tonga", "Trinité - et - Tobago", "Tunisie", "Turkménistan",
    "Îles Turques-et-Caïques", "Turquie", "Tuvalu", "Ukraine", "Uruguay", "Vanuatu",
    "Vatican (Saint-Siège)", "Venezuela", "Îles Vierges des États-Unis", "Îles Vierges britanniques", "Viêt Nam",
    "Wake Island", "Wallis - et - Futuna", "Yémen", "Zambie", "Zimbabwe",
  ]

  errorMessage: string;
  httpStatus: string;

  hasError: boolean = false;

  donMaterialRegistrationDto: DonMaterialRegistrationDto = new DonMaterialRegistrationDto();

  constructor(private accountService: AccountService, private router: Router) { }

  ngOnInit(): void {
  }

  form = new FormGroup({
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    roadNumber: new FormControl(''),
    town: new FormControl(''),
    postalCode: new FormControl(''),
    country: new FormControl(''),
    phoneNumber: new FormControl(''),
    kind: new FormControl(''),
    comment: new FormControl(''),
    isConfidential: new FormControl(false),

  });

  get validation() {
    return this.form.controls;
  }

  save() {

    this.accountService.createDon(this.donMaterialRegistrationDto).subscribe(response => {
      this.httpStatus = response.httpStatus;
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
    this.donMaterialRegistrationDto = new DonMaterialRegistrationDto();

  }

  submit() {
    if (this.form.status === 'VALID') {
      this.donMaterialRegistrationDto.setFirstName(this.form.value.firstName);
      this.donMaterialRegistrationDto.setLastName(this.form.value.lastName);
      this.donMaterialRegistrationDto.setEmail(this.form.value.email);
      this.donMaterialRegistrationDto.setRoadNumber(this.form.value.roadNumber);
      this.donMaterialRegistrationDto.setTown(this.form.value.town);
      this.donMaterialRegistrationDto.setZipCode(this.form.value.postalCode);
      this.donMaterialRegistrationDto.setCountry(this.form.value.country);
      this.donMaterialRegistrationDto.setPhoneNumber(this.form.value.phoneNumber);
      this.donMaterialRegistrationDto.setkind(this.form.value.kind);
      this.donMaterialRegistrationDto.setComment(this.form.value.comment);
      this.donMaterialRegistrationDto.setIsConfidential(this.form.value.isConfidential);


      console.log(this.donMaterialRegistrationDto);

      this.save();
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

}

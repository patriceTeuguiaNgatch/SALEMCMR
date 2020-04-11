import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccountDto } from '../dto/accountDto';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-equipe',
  templateUrl: './equipe.component.html',
  styleUrls: ['./equipe.component.css']
})
export class EquipeComponent implements OnInit {

  inputFirstName = 'Saisir le nom'; // Input first name
  inputLastName = 'Saisir le prenom'; //  Input last name
  inputEmail = 'Saisir le courriel';
  thisEmailIsInvalid = "S'il vous plaît entrez un courriel est invalide"; // This email is invalid
  emailIsrequired = 'Email est requis';
  comments = 'commentaires';
  inputMessage = 'Saisir le message de moins de 100 caractères'; // input message

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

  accountDto: AccountDto = new AccountDto();

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  form = new FormGroup({
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    country: new FormControl(''),
    phoneNumber: new FormControl(''),
    comments: new FormControl(''),
  });


  get validation() {
    return this.form.controls;
  }

  submit() {
    if (this.form.status === 'VALID') {

      this.accountDto.firstName = this.form.value.firstName;
      this.accountDto.lastName = this.form.value.lastName;
      this.accountDto.email = this.form.value.email;
      this.accountDto.phoneNumber = this.form.value.firstName;

      console.log(this.accountDto.email);

      // this.accountService.createAccount(this.accountDto)
      //   .subscribe(data => console.log(data),
      //     error => console.log(error));
      // this.accountDto = new AccountDto();

      this.router.navigate(['home']);
    }
  }
}

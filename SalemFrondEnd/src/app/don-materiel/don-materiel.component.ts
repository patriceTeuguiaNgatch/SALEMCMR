import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Country } from '../dto/country';

@Component({
  selector: 'app-don-materiel',
  templateUrl: './don-materiel.component.html',
  styleUrls: ['./don-materiel.component.css']
})
export class DonMaterielComponent implements OnInit {

  firstName = 'Nom';
  inputFirstName = 'Saisir le nom'; // Input first name
  lastName = 'Prenom';
  inputLastName = 'Saisir le prenom'; //  Input last name
  email = 'Email';
  inputEmail = 'Saisir le courriel';
  thisEmailIsInvalid = "S'il vous plaît entrez un courriel est invalide"; // This email is invalid
  emailIsrequired = 'Email est requis';
  reason = 'Nature'; // Reason
  comments = 'commentaires';
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



  countryNew = new Country("", "");


  isEmailInvalid = true;
  reasonList: any = ["Education des enfants", "Foire des livres",
    "Aide financiere aux demunis", "soutien morale ou phychologique"];

  codePhoneNumberList: any = ["93", "27", "355", "213", "49", "376", "244", "1264", "1268",
    "966", "54", "374", "297", "61", "43", "994", "1242", "973", "880", "1246", "32",
    "501", "229", "1441", "975", "375", "95", "591", "387", "267", "55", "673", "359", "226",
    "257", "855", "237", "1", "238", "236", "56", "86", "357", "57", "269", "243", "242",
    "682", "82", "506", "225", "385", "53", "599", "45", "253", "1", "1767", "20", "971",
    "593", "291", "34", "372", "1", "251", "298", "679", "358", "33", "241", "220", "995",
    "233", "350", "30", "1473", "299", "590", "1671", "502", "224", "240", "245", "592",
    "594", "509", "504", "852", "36", "91", "62", "964", "98", "353", "354", "972", "39",
    "1876", "81", "962", "7", "254", "996", "686", "383", "965", "856", "266", "371", "961",
    "231", "218", "423", "370", "352", "853", "389", "261", "60", "265", "960", "223", "500",
    "356", "1670", "212", "692", "596", "230", "222", "262", "52", "691", "373", "377", "976",
    "382", "1664", "258", "264", "674", "977", "505", "227", "234", "683", "47", "687", "64",
    "968", "256", "998", "92", "680", "970", "507", "675", "595", "31", "599", "51", "63",
    "64", "48", "689", "1", "351", "974", "262", "40", "44", "7", "250", "1869", "290", "1758",
    "378", "590", "508", "1784", "677", "503", "685", "1684", "239", "221", "381", "248", "232",
    "65", "1721", "421", "386", "252", "249", "211", "94", "46", "41", "597", "268", "963",
    "992", "255", "886", "235", "420", "246", "672", "66", "670", "228", "690", "676", "1868",
    "216", "993", "1649", "90", "688", "380", "598", "678", "379", "58", "1340", "1284", "84",
    "681", "967", "260", "263"
  ]
  countryListNew: any = [
    new Country("Afghanistan", "(93)"), new Country("Afrique du Sud", "(27)"), new Country("Albanie", "(355)")
  ]

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

  submitted = false;
  cancel = false;

  constructor(private router: Router) { }

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
    comments: new FormControl(''),
    isConfidentiale: new FormControl(''),

  });


  get validation() {
    return this.form.controls;
  }

  submit() {
    if (this.form.status === 'VALID') {
      console.log(this.form.value);
    }
  }

  gotToDon() {
    this.router.navigate(['don'])
  }

}

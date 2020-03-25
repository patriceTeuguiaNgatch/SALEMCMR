import { Component, OnInit } from '@angular/core';

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
  thisEmailIsInvalid = 'Ce courriel est invalide'; // This email is invalid
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
  inputPhoneNumber = 'Saisir le numero de téléphone';
  property = 'Propriété';





  isEmailInvalid = true;
  reasonList = ["Faite votre choix", "Education des enfants", "Foire des livres",
    "Aide financiere aux demunis", "soutien morale ou phychologique"];

  countryList = ["Afghanistan", "Afrique du Sud", "Akrotiri", 'Albanie', "Algérie", "Allemagne",
    "Andorre", "Angola", "Anguilla", "Antarctique", "Antigua - et - Barbuda", "Arabie saoudite",
    "Arctic Ocean", "Argentine",
    "Arménie",
    "Aruba",
    "Ashmore and Cartier Islands",
    "Atlantic Ocean",
    "Australie",
    "Autriche",
    "Azerbaïdjan",
    "Bahamas",
    "Bahreïn",
    "Bangladesh",
    "Barbade",
    "Belau",
    "Belgique",
    "Belize",
    "Bénin",
    "Bermudes",
    "Bhoutan",
    "Biélorussie",
    "Birmanie",
    "Bolivie",
    "Bosnie - Herzégovine",
    "Botswana",
    "Brésil",
    "Brunei",
    "Bulgarie",
    "Burkina Faso",
    "Burundi",
    "Cambodge",
    "Cameroun",
    "Canada",
    "Cap - Vert",
    "Chili",
    "Chine",
    "Chypre",
    "Clipperton Island",
    "Colombie",
    "Comores",
    "Congo",
    "Coral Sea Islands",
    "Corée du Nord",
    "Corée du Sud",
    "Costa Rica",
    "Côte d'Ivoire",
    "Croatie",
    "Cuba",
    "Curacao",
    "Danemark",
    "Dhekelia",
    "Djibouti",
    "Dominique",
    "Égypte",
    "Émirats arabes unis",
    "Équateur",
    "Érythrée",
    "Espagne",
    "Estonie",
    "États - Unis",
    "Éthiopie",
    "ex - République yougoslave de Macédoine",
    "Finlande",
    "France",
    "Gabon",
    "Gambie",
    "Gaza Strip",
    "Géorgie",
    "Ghana",
    "Gibraltar",
    "Grèce",
    "Grenade",
    "Groenland",
    "Guam",
    "Guatemala",
    "Guernsey",
    "Guinée",
    "Guinée équatoriale",
    "Guinée - Bissao",
    "Guyana",
    "Haïti",
    "Honduras",
    "Hong Kong",
    "Hongrie",
    "Ile Bouvet",
    "Ile Christmas",
    "Ile Norfolk",
    "Iles Cayman",
    "Iles Cook",
    "Iles des Cocos(Keeling)",
    "Iles Falkland",
    "Iles Féroé",
    "Iles Fidji",
    "Iles Géorgie du Sud et Sandwich du Sud",
    "Iles Heard et McDonald",
    "Iles Marshall",
    "Iles Pitcairn",
    "Iles Salomon",
    "Iles Svalbard et Jan Mayen",
    "Iles Turks - et - Caicos",
    "Iles Vierges américaines",
    "Iles Vierges britanniques",
    "Inde",
    "Indian Ocean",
    "Indonésie",
    "Iran",
    "Iraq",
    "Irlande",
    "Islande",
    "Israël",
    "Italie",
    "Jamaïque",
    "Jan Mayen",
    "Japon",
    "Jersey",
    "Jordanie",
    "Kazakhstan",
    "Kenya",
    "Kirghizistan",
    "Kiribati",
    "Kosovo",
    "Koweït",
    "Laos",
    "Lesotho",
    "Lettonie",
    "Liban",
    "Liberia",
    "Libye",
    "Liechtenstein",
    "Lituanie",
    "Luxembourg",
    "Macao",
    "Madagascar",
    "Malaisie",
    "Malawi",
    "Maldives",
    "Mali",
    "Malte",
    "Isle of Man",
    "Mariannes du Nord",
    "Maroc",
    "Maurice",
    "Mauritanie",
    "Mexique",
    "Micronésie",
    "Moldavie",
    "Monaco",
    "Monde",
    "Mongolie",
    "Monténégro",
    "Montserrat",
    "Mozambique",
    "Namibie",
    "Nauru",
    "Navassa Island",
    "Népal",
    "Nicaragua",
    "Niger",
    "Nigeria",
    "Nioué",
    "Norvège",
    "Nouvelle - Calédonie",
    "Nouvelle - Zélande",
    "Oman",
    "Ouganda",
    "Ouzbékistan",
    "Pacific Ocean",
    "Pakistan",
    "Panama",
    "Papouasie - Nouvelle - Guinée",
    "Paracel Islands",
    "Paraguay",
    "Pays - Bas",
    "Pérou",
    "Philippines",
    "Pologne",
    "Polynésie française",
    "Porto Rico",
    "Portugal",
    "Qatar",
    "République centrafricaine",
    "République démocratique du Congo",
    "République dominicaine",
    "République tchèque",
    "Roumanie",
    "Royaume - Uni",
    "Russie",
    "Rwanda",
    "Sahara occidental",
    "Saint - Barthélemy",
    "Saint - Christophe - et - Niévès",
    "Sainte - Hélène",
    "Sainte - Lucie",
    "Saint - Marin",
    "Saint - Martin",
    "Saint - Pierre - et - Miquelon",
    "Saint - Siège",
    "Saint - Vincent - et - les - Grenadines",
    "Salvador",
    "Samoa",
    "Samoa américaines",
    "Sao Tomé - et - Principe",
    "Sénégal",
    "Serbie",
    "Seychelles",
    "Sierra Leone",
    "Singapour",
    "Sint Maarten",
    "Slovaquie",
    "Slovénie",
    "Somalie",
    "Soudan",
    "Soudan du Sud",
    "Southern Ocean",
    "Spratly Islands",
    "Sri Lanka",
    "Suède",
    "Suisse",
    "Suriname",
    "Swaziland,",
    "Syrie",
    "Tadjikistan",
    "Taïwan",
    "Tanzanie",
    "Tchad",
    "Terres australes françaises",
    "Territoire britannique de l'Océan Indien",
    "Thaïlande",
    "Timor Oriental",
    "Togo",
    "Tokélaou",
    "Tonga",
    "Trinité - et - Tobago",
    "Tunisie",
    "Turkménistan",
    "Turquie",
    "Tuvalu",
    "Ukraine",
    "Union européenne",
    "Uruguay",
    "Vanuatu",
    "Venezuela",
    "Viêt Nam",
    "Wake Island",
    "Wallis - et - Futuna",
    "West Bank",
    "Yémen",
    "Zambie",
    "Zimbabwe",
  ]

  constructor() { }

  ngOnInit(): void {
  }

}

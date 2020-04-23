import { Component, OnInit } from '@angular/core';
import { AccountDto } from '../../dto/accountDto';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-account-informations',
  templateUrl: './account-informations.component.html',
  styleUrls: ['./account-informations.component.css']
})
export class AccountInformationsComponent implements OnInit {

  accountDto: AccountDto;

  constructor(private accountService: AccountService, private router: Router) { }

  ngOnInit(): void {
  }

}

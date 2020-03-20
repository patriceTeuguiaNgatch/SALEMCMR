import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AccountService } from '../account.service';
import { RouterEvent, Router } from '@angular/router';
import { AccountDto } from '../accountDto';

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {
  accountDtoList: Observable<AccountDto[]>

  constructor(private accountService: AccountService, private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.accountDtoList = this.accountService.findAccountList();
  }

  deleteAccount(id: number) {
    this.accountService.deleteAccount(id).subscribe(data => {
      console.log(data);
      this.reloadData();
    },
      error => console.log(error));
  }

  accountInformations(id: number) {
    this.router.navigate(['informations', id]);
  }
}

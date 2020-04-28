import { Component, OnInit } from '@angular/core';
import { AccountDto } from '../../dto/accountDto';
import { AccountService } from '../account.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-accout',
  templateUrl: './create-accout.component.html',
  styleUrls: ['./create-accout.component.css']
})
export class CreateAccoutComponent implements OnInit {

  accountDto: AccountDto;// = new AccountDto()
  submitted = false;

  constructor(private accountService: AccountService, private router: Router) { }

  ngOnInit(): void {
  }


  newAccount() {
    this.submitted = false;
    // this.accountDto = new AccountDto();
  }

  save() {
    // this.accountService.createAccount(this.accountDto)
    //   .subscribe(data => console.log(data),
    //     error => console.log(error));
    // this.accountDto = new AccountDto();
    this.gotoSigIn();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoSigIn() {
    this.router.navigate(['']);
  }
}

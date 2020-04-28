import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, } from 'rxjs';
import { ResponseAccountDto } from '../dto/ResponseAccountDto';

import * as CryptoJS from 'crypto-js';
import { RequestInformationDto } from '../dto/requestInformationDto';



@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private baseUrl = 'http://localhost:8080/salemapi';
  private keyPassword: string = "melas0291"


  constructor(private http: HttpClient) { }

  findAccountList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/account/collection`);
  }

  deleteAccount(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {
      responseType: 'text'
    });
  }

  updateAccount(id: string, value: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  createAccount(accountDto: any): Observable<ResponseAccountDto> {

    return this.http.post<ResponseAccountDto>(`${this.baseUrl}/account/subscriber/create`, accountDto);
  }

  findAccountById(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  singIn(accountSingInDto: any): Observable<ResponseAccountDto> {

    return this.http.post<ResponseAccountDto>(`${this.baseUrl}/account/signIn`, accountSingInDto);
  }

  sendRequestInformation(requestInformationDto: any): Observable<ResponseAccountDto> {

    return this.http.post<ResponseAccountDto>(`${this.baseUrl}/message/create`, requestInformationDto);
  }


  // encryptPassword(password: string) {
  //   return CryptoJS.AES.encrypt(password.trim(), this.keyPassword.trim()).toString();
  // }

  // dencryptPassword(password: string) {
  //   return CryptoJS.AES.decrypt(password.trim(), this.keyPassword.trim()).toString(CryptoJS.enc.Utf8);
  // }

}

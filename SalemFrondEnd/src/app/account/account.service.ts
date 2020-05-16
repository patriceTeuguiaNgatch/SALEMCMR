import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, } from 'rxjs';
import { ResponseAccountDto } from '../dto/ResponseAccountDto';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private baseUrl = 'http://localhost:8080/salemapi';

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

  createDon(donRegistrationDto: any): Observable<ResponseAccountDto> {
    return this.http.post<ResponseAccountDto>(`${this.baseUrl}/don/material/create`, donRegistrationDto);
  }

  createDonFinancial(donFinancialRequestDto: any): Observable<ResponseAccountDto> {
    return this.http.post<ResponseAccountDto>(`${this.baseUrl}/don/financial/create`, donFinancialRequestDto);
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

  sendMessageInformation(requestInformationDto: any): Observable<ResponseAccountDto> {
    return this.http.post<ResponseAccountDto>(`${this.baseUrl}/message/create/confirmation`, requestInformationDto);
  }

  createDonMaterialThankYou(donMaterialRegistrationDto: any): Observable<ResponseAccountDto> {
    return this.http.post<ResponseAccountDto>(`${this.baseUrl}/don/material/create/information`, donMaterialRegistrationDto);
  }

  createDonFinancialThankYou(donFinancialRegistrationDto: any): Observable<ResponseAccountDto> {
    return this.http.post<ResponseAccountDto>(`${this.baseUrl}/don/material/create/information`, donFinancialRegistrationDto);
  }

}

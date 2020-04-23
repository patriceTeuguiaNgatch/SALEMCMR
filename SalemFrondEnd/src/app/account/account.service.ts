import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, } from 'rxjs';
import { ResponseAccountDto } from '../dto/ResponseAccountDto';


@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private baseUrl = 'http://localhost:8080/salemapi/account';

  constructor(private http: HttpClient) { }

  findAccountList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/collection`);
  }

  deleteAccount(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {
      responseType: 'text'
    });
  }

  updateAccount(id: string, value: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  createAccount(accountDto: Object): Observable<ResponseAccountDto> {
    return this.http.post<ResponseAccountDto>(`${this.baseUrl}/subscriber/create`, accountDto);
  }

  findAccountById(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private baseUrl = 'http://localhost:8080/salemapi/account';

  constructor(private http: HttpClient) { }

  findAccountList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/collection`);
  }

  deleteAccount(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {
      responseType: 'text'
    });
  }

  updateAccount(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }
  createAccount(accountDto: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/subscriber/create`, accountDto);
  }

  findAccountById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

}

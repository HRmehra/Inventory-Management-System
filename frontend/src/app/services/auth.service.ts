
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  constructor(private http: HttpClient) { }

  login(user: User): Observable<any> {
    return this.http.post("http://localhost:8080/api/auth/login", user, httpOptions)
  }

  register(user: User): Observable<any> {
    return this.http.post<any>("http://localhost:8080/api/auth/signup", user, httpOptions)

  }
}


import { Injectable } from '@angular/core';


const token_Key = 'auth-token';
const User_Key = 'auth-user'
@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  signout(): void {
    window.sessionStorage.clear();
  }

  public saveToken(token: string): void {
    window.sessionStorage.removeItem(token_Key)
    window.sessionStorage.setItem(token_Key, token);
  }
  public getToken(): String | null {
    return window.sessionStorage.getItem(token_Key)
  }

  public saveUser(users: any): void {
    window.sessionStorage.removeItem(User_Key)
    window.sessionStorage.setItem(User_Key, JSON.stringify(users));

  }
  public getUser(): any {
    const gUser = window.sessionStorage.getItem(User_Key)
    if (gUser) {
      return JSON.parse(gUser);
    }
    return {};
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AdUserService {

  constructor(private http:HttpClient) { }

  public viewUser(){
    return this.http.get("http://localhost:8080/api/auth/getUsers")
  }
  public delUser(id){
    return this.http.delete("http://localhost:8080/api/auth/delUser/"+ id)
  }
}

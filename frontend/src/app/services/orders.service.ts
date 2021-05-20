import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Orders } from '../models/orders';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private http:HttpClient) { }
  public getAllOrders() {
    return this.http.get("http://localhost:8080/api/auth/showord")
  }
  public AddOrder(order:Orders): Observable<any>{
    return this.http.post("http://localhost:8080/api/auth/addord",order)
  }

  public editOrders(oId:number,order:Orders):Observable<any>{
    return this.http.put("http://localhost:8080/api/auth/editord/"+oId,order)
  }

  public deleteOrders(oId) {
    return this.http.delete("http://localhost:8080/api/auth/delord/" + oId)
  }

  public getCurrentData(oId :number):Observable<Orders> {
    return this.http.get<Orders>("http://localhost:8080/api/auth/vieword/" + oId)
  }
}


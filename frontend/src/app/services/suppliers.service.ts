import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Suppliers } from '../models/suppliers';

@Injectable({
  providedIn: 'root'
})
export class SuppliersService {

  constructor(private http:HttpClient) { }
  public getSuppliers() {
    return this.http.get("http://localhost:8080/api/auth/showSup");
  }
  public addSuppliers(supp: Suppliers): Observable<any> {
    return this.http.post("http://localhost:8080/api/auth/addSup", supp);
  }
  public deleteSupplier(sno) {
    return this.http.delete("http://localhost:8080/api/auth/delSup/" + sno)
  }
  public EditSupplier(sno: String, supp: Suppliers): Observable<any> {
    return this.http.put("http://localhost:8080/api/auth/editsup/" + sno, supp);
  }
  public getCurrentData(sno: String): Observable<Suppliers> {
    return this.http.get<Suppliers>("http://localhost:8080/api/auth/viewsup/" + sno)
  }
  public getSupllierForOrder(){
    return this.http.get("http://localhost:8080/api/auth/showSup");
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) { }

  public AddProduct(product: Product): Observable<any> {
    return this.http.post("http://localhost:8080/api/auth/add", product);
  }
  handelError(error, Response) { }

  public getAllProducts() {
    return this.http.get("http://localhost:8080/api/auth/all")
  }
  public EditProduct(id: number, product: Product): Observable<any> {
    return this.http.put("http://localhost:8080/api/auth/edit/" + id, product);
  }

  public deleteProduct(id) {
    return this.http.delete("http://localhost:8080/api/auth/del/" + id)
  }

  public getCurrentData(id: number): Observable<Product> {
    return this.http.get<Product>("http://localhost:8080/api/auth/view/" + id)
  }

  public getAllForOrders() {
    return this.http.get("http://localhost:8080/api/auth/all")
  }
}

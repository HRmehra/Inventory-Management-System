import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css']
})
export class ViewProductsComponent implements OnInit {

  products: Product[] = [];
  constructor(private service:ProductsService) { }

  ngOnInit(): void {
    this.service.getAllProducts().subscribe(
      (data: Product[]) => {
        this.products = data;
      })
  }
  delete(j) {
    this.service.deleteProduct(j).subscribe(
      data => {
        this.ngOnInit();
        console.log("deleted", data);
      })
  }

}

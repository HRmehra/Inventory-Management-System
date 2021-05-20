import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Orders } from 'src/app/models/orders';
import { Product } from 'src/app/models/product';
import { Suppliers } from 'src/app/models/suppliers';
import { AddProductComponent } from 'src/app/Products/add-product/add-product.component';
import { OrdersService } from 'src/app/services/orders.service';
import { ProductsService } from 'src/app/services/products.service';
import { SuppliersService } from 'src/app/services/suppliers.service';

@Component({
  selector: 'app-add-orders',
  templateUrl: './add-orders.component.html',
  styleUrls: ['./add-orders.component.css']
})
export class AddOrdersComponent implements OnInit {

  orders = new Orders()
  msg = ''
  products: Product[] = [];

  suppliersO: Suppliers[] = [];

  constructor(
    private service: OrdersService,
    private router: Router,
    private Pservice: ProductsService,
    private Sservice: SuppliersService
  ) { }

  ngOnInit(): void {
    this.Pservice.getAllForOrders().subscribe(
      (data: Product[]) => {
        this.products = data;
      })

    this.Sservice.getSupllierForOrder().subscribe(
      (supData: Suppliers[]) => {
        this.suppliersO = supData;
      })

  }
  addOrder() {
    this.service.AddOrder(this.orders).subscribe(
      data => {
        console.log("added");
        this.msg = "added succesfully";
        this.router.navigate(['/orders']);
      },
      error => {
        console.log("failed to add");
        this.msg = error.error;

      })
  }

  test(e: any) {
    let product = JSON.parse(e.target.value)
    this.orders.price = product.buyingPrice
  }


}

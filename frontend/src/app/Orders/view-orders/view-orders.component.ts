import { Component, OnInit } from '@angular/core';
import { Orders } from 'src/app/models/orders';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-view-orders',
  templateUrl: './view-orders.component.html',
  styleUrls: ['./view-orders.component.css']
})
export class ViewOrdersComponent implements OnInit {
  orders:Orders[]=[]
  
  constructor(private service:OrdersService) { }

  ngOnInit(): void {
    this.service.getAllOrders().subscribe(
      (data: Orders[])=>{
        this.orders=data;
      }
    )
    // var date= new Date()

    // var dd = String(date.getDate()).padStart(2, '0');
    // var mm = String(date.getMonth() + 1).padStart(2, '0'); //January is 0!
    // var yyyy = date.getFullYear();
    
    // this.orders. = mm + '/' + dd + '/' + yyyy;
  }
  delete(j) {
    this.service.deleteOrders(j).subscribe(
      data => {
        this.ngOnInit();
        console.log("deleted", data);
      })
  }


}

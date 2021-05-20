import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Orders } from 'src/app/models/orders';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-edit-orders',
  templateUrl: './edit-orders.component.html',
  styleUrls: ['./edit-orders.component.css']
})
export class EditOrdersComponent implements OnInit {
  order = new Orders()
  id: number;
  constructor(private service:OrdersService,
    private Arouter: ActivatedRoute,
     private router: Router) { }

  ngOnInit(): void {
    this.id = this.Arouter.snapshot.params['oId'];
    this.service.getCurrentData(this.id).subscribe(result => {
      this.order = result;
    },
      error => console.log(error)
    )
  }

  edit() {
    this.service.editOrders(this.id, this.order).subscribe(
      data => {
        console.log("edited");
        this.router.navigate(['/orders'])
      },
      error => console.log(error)
    )
  }

}

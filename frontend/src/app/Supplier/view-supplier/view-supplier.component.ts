import { Component, OnInit } from '@angular/core';
import { Suppliers } from 'src/app/models/suppliers';
import { SuppliersService } from 'src/app/services/suppliers.service';

@Component({
  selector: 'app-view-supplier',
  templateUrl: './view-supplier.component.html',
  styleUrls: ['./view-supplier.component.css']
})
export class ViewSupplierComponent implements OnInit {

  suppliers: Suppliers[]=[];
  
  constructor(private service:SuppliersService) { }

  ngOnInit(): void {
    this.service.getSuppliers().subscribe(
      (data: Suppliers[])=>{
        this.suppliers=data;
      }
    )
  }
  delete(S) {
    this.service.deleteSupplier(S).subscribe(
      data => {
        this.ngOnInit();
        console.log("deleted", data);
      })
  }

}

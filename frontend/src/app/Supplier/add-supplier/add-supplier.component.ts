import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Suppliers } from 'src/app/models/suppliers';
import { SuppliersService } from 'src/app/services/suppliers.service';

@Component({
  selector: 'app-add-supplier',
  templateUrl: './add-supplier.component.html',
  styleUrls: ['./add-supplier.component.css']
})
export class AddSupplierComponent implements OnInit {

  supplier = new Suppliers()
  msg=""

  constructor(private service:SuppliersService,private router:Router) { }

  ngOnInit(): void {
  }
  add(){ 
    this.service.addSuppliers(this.supplier).subscribe(
      data =>{
        console.log("added");
        this.msg="added succesfully";
        this.router.navigate(['/suppliers']);
        
      },
      errors =>{
        console.log("failed to add");
        this.msg=errors.error;
      }
    )
  }

}

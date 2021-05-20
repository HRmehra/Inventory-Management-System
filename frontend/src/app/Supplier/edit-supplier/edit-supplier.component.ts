import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Suppliers } from 'src/app/models/suppliers';
import { SuppliersService } from 'src/app/services/suppliers.service';

@Component({
  selector: 'app-edit-supplier',
  templateUrl: './edit-supplier.component.html',
  styleUrls: ['./edit-supplier.component.css']
})
export class EditSupplierComponent implements OnInit {
  supplier = new Suppliers()
  sno: String
  constructor(private service:SuppliersService, private Arouter:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    this.sno = this.Arouter.snapshot.params['sno'];
    console.log(this.sno)
    this.service.getCurrentData(this.sno).subscribe(
      resultsup => {
      this.supplier = resultsup;
      console.log("test")
      console.log(this.supplier)
    },
      error => console.log(error)
    )
  }
  editS() {
    this.service.EditSupplier(this.sno, this.supplier).subscribe(
      data => {
        console.log("edited");
        this.router.navigate(['/suppliers'])
      },
      error => console.log(error)
    )
  }

}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {
  product = new Product()
  id: number;
  
  constructor(private service:ProductsService ,
    private Arouter:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.id = this.Arouter.snapshot.params['id'];
    this.service.getCurrentData(this.id).subscribe(result => {
      this.product = result;
    },
      error => console.log(error)
    )
  }
  edit() {
    this.service.EditProduct(this.id, this.product).subscribe(
      data => {
        console.log("edited");
        this.router.navigate(['/product'])
      },
      error => console.log(error)
    )
  }

}

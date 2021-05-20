import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  product = new Product()
  msg=''

  constructor(private service:ProductsService,private router:Router) { }

  ngOnInit(): void {
  }
  add(){
    this.service.AddProduct(this.product).subscribe(
      data =>{
        console.log("added");
        this.msg="added succesfully";
        this.router.navigate(['/product']);
        
      },
      error =>{
        console.log("failed to add");
        this.msg=error.error;
        
      }
    )
    }
  }
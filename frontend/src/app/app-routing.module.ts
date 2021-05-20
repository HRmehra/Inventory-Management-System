import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainhomeComponent } from './home/mainhome/mainhome.component';
import { LoginComponent } from './logup/login/login.component';
import { RegisterComponent } from './logup/register/register.component';
import { AddOrdersComponent } from './Orders/add-orders/add-orders.component';
import { EditOrdersComponent } from './Orders/edit-orders/edit-orders.component';
import { ViewOrdersComponent } from './Orders/view-orders/view-orders.component';
import { AddProductComponent } from './Products/add-product/add-product.component';
import { EditProductComponent } from './Products/edit-product/edit-product.component';
import { ViewProductsComponent } from './Products/view-products/view-products.component';
import { ProfileComponent } from './profiles/profile/profile.component';
import { BoardAdminComponent } from './protected-comp/board-admin/board-admin.component';
import { AddSupplierComponent } from './Supplier/add-supplier/add-supplier.component';
import { EditSupplierComponent } from './Supplier/edit-supplier/edit-supplier.component';
import { ViewSupplierComponent } from './Supplier/view-supplier/view-supplier.component';

const routes: Routes = [
  {path:'home',component:MainhomeComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'profile',component:ProfileComponent},
  {path:'product',component:ViewProductsComponent},
  {path:'add',component:AddProductComponent},
  {path:'edit/:id',component:EditProductComponent},
  {path:'suppliers',component:ViewSupplierComponent},
  {path:'addSup',component:AddSupplierComponent},
  {path:'edits/:sno',component:EditSupplierComponent},
  {path:'orders',component:ViewOrdersComponent},
  {path:'addOrder',component:AddOrdersComponent},
  {path:'editord/:oId',component:EditOrdersComponent},
  {path:'admin',component:BoardAdminComponent},
  
  {path:'',redirectTo:'login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

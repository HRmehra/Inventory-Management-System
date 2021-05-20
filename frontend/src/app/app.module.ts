import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './logup/login/login.component';
import { RegisterComponent } from './logup/register/register.component';
import { MainhomeComponent } from './home/mainhome/mainhome.component';
import { ProfileComponent } from './profiles/profile/profile.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AuthInterceptorService } from './helper/auth-interceptor.service';
import { ViewProductsComponent } from './Products/view-products/view-products.component';
import { EditProductComponent } from './Products/edit-product/edit-product.component';
import { AddProductComponent } from './Products/add-product/add-product.component';
import { ViewSupplierComponent } from './Supplier/view-supplier/view-supplier.component';
import { AddSupplierComponent } from './Supplier/add-supplier/add-supplier.component';
import { EditSupplierComponent } from './Supplier/edit-supplier/edit-supplier.component';
import { ViewOrdersComponent } from './Orders/view-orders/view-orders.component';
import { AddOrdersComponent } from './Orders/add-orders/add-orders.component';
import { EditOrdersComponent } from './Orders/edit-orders/edit-orders.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BoardAdminComponent } from './protected-comp/board-admin/board-admin.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    MainhomeComponent,
    ProfileComponent,
    ViewProductsComponent,
    EditProductComponent,
    AddProductComponent,
    ViewSupplierComponent,
    AddSupplierComponent,
    EditSupplierComponent,
    ViewOrdersComponent,
    AddOrdersComponent,
    EditOrdersComponent,
    BoardAdminComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatCardModule
  ],
  providers: [AuthInterceptorService],
  bootstrap: [AppComponent]
})
export class AppModule { }

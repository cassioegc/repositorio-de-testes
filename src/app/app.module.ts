import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BagComponent } from './bag/bag.component';
import { ItemsComponent } from './items/items.component';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { CheckoutModalComponent } from './checkout-modal/checkout-modal.component';
import { ModalModule } from 'ngx-bootstrap/modal';

@NgModule({
  declarations: [
    AppComponent,
    BagComponent,
    ItemsComponent,
    NavbarComponent,
    CheckoutModalComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ModalModule.forRoot(),
    AppRoutingModule
  ],
  entryComponents: [CheckoutModalComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

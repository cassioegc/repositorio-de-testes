import { Component, OnInit } from '@angular/core';
import { Order } from 'src/model/Order.model';
import { BagService } from './bag.service';
import { Food } from 'src/model/Food.model';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { CheckoutModalComponent } from '../checkout-modal/checkout-modal.component';

@Component({
  selector: 'app-bag',
  templateUrl: './bag.component.html',
  styleUrls: ['./bag.component.sass']
})
export class BagComponent implements OnInit {

  items: Order[];
  total: number;
  bsModalRef: BsModalRef;

  constructor(
    private bagService: BagService,
    private bsModalService: BsModalService
  ) { }

  ngOnInit() {
    this.items = this.bagService.items;
    this.total = this.bagService.total

    this.bagService.itemsChanged
    .subscribe(items => {
      this.items = items;
      this.total = this.bagService.total;
    });
  }

  decreaseFood(foodId: string) {
    this.bagService.decreaseItem(foodId);
  }

  addFood(food: Food) {
    this.bagService.addFood(food);
  }

  goTocheckout() {
    this.bsModalRef = this.bsModalService.show(CheckoutModalComponent);
    this.bsModalRef.content.items = this.items;
    this.bsModalRef.content.total = this.total;
  }

}

import { Component, OnInit, Input } from '@angular/core';
import { BagService } from '../bag/bag.service';
import { BsModalRef } from 'ngx-bootstrap/modal'
import { Order } from 'src/model/Order.model';

@Component({
  selector: 'app-checkout-modal',
  templateUrl: './checkout-modal.component.html',
  styleUrls: ['./checkout-modal.component.sass']
})
export class CheckoutModalComponent implements OnInit {

  @Input()
  items: Order[];

  @Input()
  total: number;
  
  constructor(
    private bsModalRef: BsModalRef
  ) { }

  ngOnInit() {
  }

  onClose() {
    this.bsModalRef.hide();
  }

}

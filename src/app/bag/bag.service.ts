import { Injectable, Output, EventEmitter, OnInit } from '@angular/core';

import { Order } from 'src/model/Order.model';
import { _ } from 'underscore';
import { Food } from 'src/model/Food.model';

@Injectable({
  providedIn: 'root'
})
export class BagService {

  private bagKey = 'bag';
  items: Order[] = JSON.parse(localStorage.getItem(this.bagKey)) || [];
  itemsChanged = new EventEmitter<Order[]>();
  total = this.calculateTotal();

  constructor() { }

  addFood(food: Food) {
    const order = _.find(this.items, order => order.food.id === food.id);

    if (!order) {
      const newOrder = new Order(food);
      this.items = this.items.concat(newOrder);
    } else {
      order.amount += 1;
    }
    this.posChangeItems();
  }

  decreaseItem(id: string) {
    const order: Order = _.find(this.items, order => order.food.id === id);
    order.amount -= 1;

    if (order.amount === 0) {
      this.items = _.filter(this.items, item => item !== order);
    }

    this.posChangeItems();
  }

  posChangeItems() {
    localStorage.setItem(this.bagKey, JSON.stringify(this.items));
    this.total = this.calculateTotal();
    this.itemsChanged.emit(this.items);
  }

  calculateTotal() {
    const prices = _.map(this.items, order => order.food.price * order.amount);
    return _.reduce(prices, (price, amount) => price + amount, 0);
  }
}

import { Component, OnInit } from '@angular/core';
import { Food } from 'src/model/Food.model';
import { ActivatedRoute } from '@angular/router';
import { take } from 'rxjs/operators';
import { BagService } from '../bag/bag.service';
import { FoodService } from '../food.service';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.sass']
})
export class ItemsComponent implements OnInit {

  items: Food[];

  constructor(
    private route: ActivatedRoute,
    private bagService: BagService,
    private foodService: FoodService
  ) { }

  ngOnInit() {
    this.route.queryParams
    .subscribe( queryParams => {
      this.foodService.getFood(queryParams)
      .subscribe(items => {
        this.items = items;
      });
    });
  }

  addToBag(food: Food) {
    this.bagService.addFood(food);
  }

}

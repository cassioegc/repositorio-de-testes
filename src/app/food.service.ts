import { Injectable, OnInit } from '@angular/core';
import { environment } from '../environments/environment';
import { take } from 'rxjs/operators';

import { Food } from 'src/model/Food.model';
import { HttpClient } from '@angular/common/http';
import { _ } from 'underscore';

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  private resource = environment.store_server + 'food';

  constructor(
    private http: HttpClient
  ) { }

  getFood(params? : any) {
    return this.http.get<Food[]>(this.resource, { params } )
    .pipe(
      take(1)
    );
  }

}

import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { _ } from "underscore";

@Component({
  selector: "app-navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.sass"]
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router) {}

  ngOnInit() {}

  filterCuisine(cuisine?: string) {
    const queryParams = { cuisine };
    this.navigate(queryParams);
  }

  search(value) {
    let queryParams = { };

    if (!_.isEmpty(value)) {
      queryParams = { q: value };
    }
    this.navigate(queryParams);
  }

  private navigate(queryParams) {
    this.router.navigate(['/food'], { queryParams });
  }
}

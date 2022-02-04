import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-user-disbord",
  templateUrl: "./user-disbord.component.html",
  styleUrls: ["./user-disbord.component.css"],
})
export class UserDisbordComponent implements OnInit {

  constructor(private _route: ActivatedRoute) {}

  ngOnInit(): void {
   
  }
}

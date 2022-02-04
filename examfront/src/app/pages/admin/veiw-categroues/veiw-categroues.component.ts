import { Component, OnInit } from "@angular/core";
import { CategoryService } from "src/app/services/category.service";
import Swal from "sweetalert2";

@Component({
  selector: "app-veiw-categroues",
  templateUrl: "./veiw-categroues.component.html",
  styleUrls: ["./veiw-categroues.component.css"],
})
export class VeiwCategrouesComponent implements OnInit {
  categories: any;

  constructor(private category: CategoryService) {}

  ngOnInit(): void {
    this.category.categories().subscribe(
      (data) => {
        //css
        this.categories = data;

        // console.log(this.categories);
      },
      (error) => {
        console.log(error);
        Swal.fire("Erroe !!", "Error in Loding data", "error");
      }
    );
  }
}

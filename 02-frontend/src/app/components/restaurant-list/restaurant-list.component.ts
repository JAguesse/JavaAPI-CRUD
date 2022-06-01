import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Restaurant } from 'src/app/common/restaurant';
import { RestaurantService } from 'src/app/services/restaurant.service';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit {

  restaurants: Restaurant[];
  displayedColumns: string[] = ['name', 'address', 'menu'];
  dataSource; 

  constructor(private restaurantService: RestaurantService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.restaurantService.getRestaurantList().subscribe(data => {
      this.restaurants = data; 
    })
    
    this.dataSource =  new MatTableDataSource(this.restaurants);
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}

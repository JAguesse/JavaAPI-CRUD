import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Restaurant } from '../common/restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {


  private baseUrl = "http://localhost:8080/restaurants";
  
  constructor(private httpClient: HttpClient) { }

  getRestaurantList(): Observable<Restaurant[]>{
    const searchUrl = `${this.baseUrl}`
    return this.httpClient.get<Restaurant[]>(this.baseUrl);
   // return this.getRestaurants(searchUrl);
  }

  private getRestaurants(searchUrl: string): Observable<Restaurant[]>{
    return this.httpClient.get<GetResponseRestaurants>(searchUrl).pipe(
      map(response => response._embedded.restaurants)
    );
  }
}


interface GetResponseRestaurants {
  _embedded: {
    restaurants: Restaurant[];
  }
}

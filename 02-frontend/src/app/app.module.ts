import { Component, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { RestaurantListComponent } from './components/restaurant-list/restaurant-list.component';

const routes: Routes = [
  
  {path: 'restaurants', component: RestaurantListComponent},
  {path: '', redirectTo: '/restaurants', pathMatch: 'full'}
]
@NgModule({
  declarations: [
    AppComponent, 
    RestaurantListComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule, 
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

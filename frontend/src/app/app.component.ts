// import { Component } from '@angular/core';
// import { RouterOutlet } from '@angular/router';
//
// @Component({
//   selector: 'app-root',
//   standalone: true,
//   imports: [RouterOutlet],
//   templateUrl: './app.component.html',
//   styleUrl: './app.component.css'
// })
// export class AppComponent {
//   title = 'frontend';
// }

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fruit } from '../models/fruit';

@Injectable({
  providedIn: 'root'
})
export class FruitService {
  private apiUrl = 'http://localhost:8080/api/fruits';

  constructor(private http: HttpClient) { }

  getFruits(): Observable<Fruit[]> {
    return this.http.get<Fruit[]>(this.apiUrl);
  }

  createFruit(fruit: Fruit): Observable<Fruit> {
    return this.http.post<Fruit>(this.apiUrl, fruit);
  }

  updateFruit(id: number, fruit: Fruit): Observable<Fruit> {
    return this.http.put<Fruit>(`${this.apiUrl}/${id}`, fruit);
  }

  deleteFruit(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}


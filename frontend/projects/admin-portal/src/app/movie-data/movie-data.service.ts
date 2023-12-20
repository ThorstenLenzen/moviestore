import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Movie } from './movie';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MovieDataService {

  private baseUrl: string = 'http://localhost:8080/api/';

  public constructor(private httpClient: HttpClient) { }

  public getAllMovies(): Observable<Movie[]> {
    const url = `${this.baseUrl}movies`;
    return this.httpClient.get<Movie[]>(url);
  }
}

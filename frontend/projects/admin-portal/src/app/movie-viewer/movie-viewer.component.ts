import { Component, OnInit } from '@angular/core';
import { MovieDataService } from '../movie-data/movie-data.service';
import { Movie } from '../movie-data/movie';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-movie-viewer',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './movie-viewer.component.html',
  styleUrl: './movie-viewer.component.scss'
})
export class MovieViewerComponent implements OnInit {

  public movies: Movie[] = [];

  constructor(private dataService: MovieDataService) {  
  }
  
  public ngOnInit(): void {
    this.dataService.getAllMovies().subscribe(
      (movies: Movie[]) => {
        this.movies = movies;
      }
    );
  }
}

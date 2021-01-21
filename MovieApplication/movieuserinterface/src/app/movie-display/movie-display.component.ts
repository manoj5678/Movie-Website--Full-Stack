import {Component, OnInit} from "@angular/core";
import {ActivatedRoute} from '@angular/router';
import {Movie} from "../model/movie";
import {UserService} from "../user.service";
import {Movierating} from "../model/movierating";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {MovieRatingModelDisplayComponent} from "../movie-rating-model-display/movie-rating-model-display.component";
import {User} from "../model/user";

@Component({
  selector: "app-movie-display",
  templateUrl: "./movie-display.component.html",
  styleUrls: ["./movie-display.component.css"]
})
export class MovieDisplayComponent implements OnInit {
  movies: Movie[];
  movieDetails: Movie;
  PMovieID: number;
  isModelWindowClosed: boolean;
  succesmessage: boolean;
  movierating:Movierating;
  movieratingList: Movierating[] = [];

  constructor(private userService: UserService, private route: ActivatedRoute, public dialog: MatDialog) {
    this.route.params.subscribe(params => {
      console.log("Hello", params)
      this.PMovieID = params['pmovieId'];
    });
  }


  saveMoviRatingWindow():void{
    console.log("movierating*****************",this.movierating.rating);
     const  userDetails =  this.userService.getUser();
     this.movierating.userId = userDetails.name;
      this.movierating.movieId = this.movieDetails.id.toString();
      this.movieratingList.push(this.movierating);
      this.userService.saveMovierating(this.movierating);
      this.isModelWindowClosed =  false;
      this.succesmessage = true;
  }
  closeMoviRatingWindow(): void {
    this.isModelWindowClosed =  false;
  }
  openMoviRatingWindow(): void {
    this.isModelWindowClosed =  true;
    this.movierating = new Movierating();
  }
  openDialog(): void {
    const movieRate = new Movierating();
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    const dialogRef = this.dialog.open(MovieRatingModelDisplayComponent, {
      width: '250px',
      data: {movieRatingDetails: movieRate}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.isModelWindowClosed = result;
    });
  }

  ngOnInit() {
    this.isModelWindowClosed = false;
    console.log("PMovieID", this.PMovieID);
    this.loadMovieDetails(this.PMovieID);
  }

  loadMovieratingList(movieId: number) {
    this.userService.loadMovieratingList(movieId).subscribe(value => {
      this.movieratingList = value;
    });
  }

  loadMovieDetails(movieId: number) {
    this.userService.getMovieListDetails(movieId).subscribe(value => {
      this.movieDetails = value;
    });
  }

}





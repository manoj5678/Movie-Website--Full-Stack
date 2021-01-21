import {Observable} from "rxjs";
import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from '@angular/router';
import {Movie} from "../model/movie";
import {UserService} from "../user.service";

@Component({
  selector: "app-movie-list",
  templateUrl: "./movie-list.component.html",
  styleUrls: ["./movie-list.component.css"]
})
export class MovieListComponent implements OnInit {
  movies: Observable<Movie[]>;

  constructor(private userService: UserService,
              private router: Router){

  }

  ngOnInit() {
    this.reloadData();
  }

  showMovieDetails(pmovieId: number) {
    this.router.navigate(['movieDisplay', pmovieId]);
  }

  reloadData() {
    this.movies = this.userService.getAllMovieList();
  }

}

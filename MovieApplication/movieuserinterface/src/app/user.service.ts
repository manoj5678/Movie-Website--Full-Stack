import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {userError} from "@angular/compiler-cli/src/transformers/util";
import {User} from "./model/user";
import {Movie} from "./model/movie";
import {map} from "rxjs/operators";
import {Movierating} from "./model/movierating";

@Injectable({
  providedIn: 'root'
})
export class UserService {


  private user:User;

  setUser(userDetails:User){
    this.user = userDetails;
  }

  getUser() {
    return this.user;
  }

  public isUserLogin;

  private baseUrl = 'http://localhost:8080/api/movie/';
  private baseNodeUrl = 'http://localhost:8800/api/movieRating/';

  constructor(private http: HttpClient) { }

  getMovie(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getUserDetails(user:User): Observable<User> {

    return this.http.post<User>(`${this.baseUrl}`+`/validateUser`, user);
  }

  updateRating(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }


  getAllMovieList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+`/movieDetails`);
  }

  loadMovieratingList(movieId:number): Observable<Movierating[]> {
    return this.http.get<Movierating[]>(`${this.baseNodeUrl}`+`/all/${movieId}`);
  }
  saveMovierating(movierating:Movierating): Observable<Movierating> {
    return this.http.get<Movierating>(`${this.baseNodeUrl}`+`/save/${movierating}`);
  }
  getMovieListDetails(movieId:number): Observable<Movie> {
    return this.http.get<Movie>(`${this.baseUrl}`+`/movieDetail/${movieId}`);
  }

}

import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MovieListComponent} from "./movie-list/movie-list.component";
import {AppComponent} from "./app.component";
import {MovieRedirectComponent} from "./movie-redirect/movie-redirect.component";
import {MovieDisplayComponent} from "./movie-display/movie-display.component";

const routes: Routes = [
  {
    path: 'movies', component: MovieListComponent
  },
  {path: 'login', component: MovieRedirectComponent},
  {path: 'movieDisplay/:pmovieId', component: MovieDisplayComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

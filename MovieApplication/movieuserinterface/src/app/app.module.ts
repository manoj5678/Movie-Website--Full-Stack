import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {MovieListComponent} from "./movie-list/movie-list.component";
import {MovieRedirectComponent} from "./movie-redirect/movie-redirect.component";
import {MAT_DIALOG_DATA, MatDialog, MatDialogModule, MatDialogRef} from "@angular/material/dialog";
import {MAT_FORM_FIELD_DEFAULT_OPTIONS, MatFormFieldModule} from "@angular/material/form-field";
import {MovieDisplayComponent} from "./movie-display/movie-display.component";
import {MovieRatingModelDisplayComponent} from "./movie-rating-model-display/movie-rating-model-display.component";

@NgModule({
  declarations: [
    AppComponent,
    MovieListComponent,
    MovieRedirectComponent,
    MovieDisplayComponent,
    MovieRatingModelDisplayComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatDialogModule,
    MatFormFieldModule
  ],
  providers: [
    {
      provide: MatDialogRef,
      useValue: []
    },
    {
      provide: MatDialog,
      useValue: []
    },
    {
      provide: MAT_DIALOG_DATA,
      useValue: []
    },
    { provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: { appearance: 'fill' } }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}

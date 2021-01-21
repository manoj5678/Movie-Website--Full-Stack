import {Component, Inject} from "@angular/core";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Movierating} from "../model/movierating";

@Component({
  selector: 'app-movie-rating-model-display',
  templateUrl: './movie-rating-model-display.component.html',
})
export class MovieRatingModelDisplayComponent {

  constructor(
    public dialogRef: MatDialogRef<MovieRatingModelDisplayComponent>) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}

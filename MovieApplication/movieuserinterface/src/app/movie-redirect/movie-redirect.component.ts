import {Component} from "@angular/core";
import {UserService} from "../user.service";
import {Router} from "@angular/router";
import {User} from "../model/user";
import {Observable} from "rxjs";
import {Movie} from "../model/movie";

@Component({
  selector: "app-movie-redirect",
  templateUrl: "./movie-redirect.component.html",
  styleUrls: ["./movie-redirect.component.css"]
})
export class MovieRedirectComponent {

  title = 'Movie Rating Details';
  emailId: string;
  password: string;
  error:boolean;
  userLogedIn:boolean;

  constructor(private userService: UserService,private router: Router) {
  }

  onSubmit() {
    console.log("Email id ", this.emailId);
    console.log("password ", this.password);
    let  userDetails:User = new User();
    userDetails.password =this.password;
    userDetails.email =this.emailId;

    this.userService.getUserDetails(userDetails).subscribe(
      data => {
        console.log(data);
       if(data != null ) {
         this.userLogedIn =true;
         this.userService.isUserLogin = true;
         this.userService.setUser(data) ;
         this.router.navigate(['movies']);
        }else {
          this.error = true;
        }

      },
      error => console.log(error));
  }


  ngOnInit(): void {

  }

}


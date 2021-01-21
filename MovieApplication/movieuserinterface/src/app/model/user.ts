import {Role} from "./role";
import {Contact} from "./contact";

export class User {
  public email: string;
  public name: string;
  public password: string;
  public id: number;
  public  role:Role;
  public  contact:Contact;
}

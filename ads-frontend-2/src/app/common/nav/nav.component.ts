import { Component, OnInit } from '@angular/core';

import { UserService } from '../../common/login/user.service';
import { Globals } from '../../globals';
import { JwtHelperService } from '@auth0/angular-jwt';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  public firstName: String;
  public lastName: String;
  public email: String;
  public userRole: String;


  constructor(private userService: UserService,  private jwtHelperService: JwtHelperService, private globals: Globals) {

  }

  ngOnInit() {
   
  }

  ngDoCheck() {
    if (!this.jwtHelperService.isTokenExpired()) {
      // console.log(this.globals.appModulesAvailable);

      const myRawToken = localStorage.getItem('access_token');
      const decodedToken = this.jwtHelperService.decodeToken(myRawToken);

      this.firstName = decodedToken.firstName;
      this.lastName = decodedToken.lastName;
      this.email = decodedToken.email;
      this.userRole = decodedToken.userRole;
    }
  }

  isLogedIn() {
    return !this.jwtHelperService.isTokenExpired();
  }

  logout() {
    this.userService.logout();
  }

}

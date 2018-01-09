import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { Router, ActivatedRoute } from '@angular/router';
import { SessionHelper } from '../core/session.helper';
import { UserService } from './user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
	result;
	model: any = {};
	loading = false;
	error = '';
	redirectUrl: string;
	showNavOptions;

	constructor(private router: Router, 
		private activatedRoute: ActivatedRoute,
		private authenticationService:LoginService,
		private userService: UserService,
		private _sessionHelper: SessionHelper
		) {
			if (this._sessionHelper.isAuthenticated()){
				this.router.navigate(['/home']);
			}
		}

	ngOnInit() {
	}

	login(isValid) {
			console.log("FOrm is valid ",isValid);
			if(isValid){
	    this.loading = true;
	    this.showNavOptions = true;

	    this.authenticationService.login(this.model.username, this.model.password)
	      .subscribe(result => {
	          this.loading = false;

	          if (result) {
	          	console.log('result',JSON.stringify(result));
	            this.userService.login(result);
	            this.navigateAfterSuccess();
	          } else {
	            this.error = 'Username or password is incorrect';
	          }
	        },
	        error => {
						if(error && error.status == 401 && error.status == 400){
							alert("Username or password is incorrect")
						}
	          this.error = 'Username or password is incorrect';
	          this.loading = false;
	        }
				);
			}
  	}
  	
	private navigateAfterSuccess() {
		this.redirectUrl = '/home';
		if (this.redirectUrl) {
		  this.router.navigateByUrl(this.redirectUrl);
		} else {
		  this.router.navigate(['/']);
		}
	}
}

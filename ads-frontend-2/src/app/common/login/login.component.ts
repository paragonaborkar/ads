import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { Router, ActivatedRoute } from '@angular/router';

import { SessionHelper } from '../../auth/session.helper';
import { UserService } from './user.service';

import { JwtHelperService } from '@auth0/angular-jwt';

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
	loginError = false;
	serverError = false;

	constructor(private jwtHelperService: JwtHelperService, private router: Router, private activatedRoute: ActivatedRoute, private authenticationService: LoginService, private userService: UserService, private _sessionHelper: SessionHelper) {}

	ngOnInit() {
		let response = (this.activatedRoute.snapshot.queryParams["response"]);

		this.redirectUrl = (this.activatedRoute.snapshot.queryParams["redirectTo"]);
		console.log("redirectUrl:" + this.redirectUrl);
		console.log("response:" + response);

		if (response !== null && response !== undefined) {
			let res = JSON.parse(atob(response));
			this.userService.login(res);
			this.navigateAfterSuccess();
		}
		let err_msg = (this.activatedRoute.snapshot.queryParams["error"]);
		if (err_msg !== null && err_msg !== undefined) {
			alert(err_msg);
		}

	}

	loadDevLogin() {
		this.model = {
			username: "jdoe@corp.com",
			password: "123"
		};
	}

	login(isValid) {
		if (isValid) {
			this.loading = true;
			this.showNavOptions = true;

			this.authenticationService.login(this.model.username, this.model.password).subscribe(result => {
				this.loading = false;

				console.log(result);

				if (result) {
					this.userService.login(result);
					this.navigateAfterSuccess();
				} else {
					this.error = 'Username or password is incorrect';
				}
			},
				error => {
					console.error(error.status);
					if (error.status >= 400 && error.status < 500) {
						this.loginError = true;
					}
					else {
						this.serverError = true;
					}
					this.loading = false;
				}
			);
		}
	}

	private navigateAfterSuccess() {

		if (this.redirectUrl == '' || this.redirectUrl == undefined) {

			if (this._sessionHelper.get("userRole") == "ROLE_USER")
				this.redirectUrl = '/index';
			else
				this.redirectUrl = '/home';
		}

		if (this.redirectUrl) {
			this.router.navigateByUrl(this.redirectUrl);
		} else {
			this.router.navigate(['/']);
		}
	}
}

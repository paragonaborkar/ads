import { OnInit, Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable()
export class Globals implements OnInit {
	appModulesAvailable: any = {};

	apiUrl: string="http://localhost:8080";
	askAQuestionUrl: string = "https://support.netapp.com?adsRequest=question";
	reportAProblemUrl: string = "https://support.netapp.com?adsRequest=problem";

	readonly TOKEN_AUTH_USERNAME = 'testjwtclientid'; // FIXME: Comment - why and how used in Login Service
	readonly TOKEN_AUTH_PASSWORD = 'XY7kmzoNzl100';  // FIXME: Comment - why and how used in Login Service

	// FIXME: implement this sync
	constructor(private http: HttpClient) {
		this.http.get('assets/global.json')
			.subscribe(data => {
				this.apiUrl = data["apiUrl"];
				this.askAQuestionUrl = data["askAQuestionUrl"];
				this.reportAProblemUrl = data["reportAProblemUrl"];
				console.log("this.apiUrl:" + this.apiUrl);
			});
	}

	ngOnInit() {
      
    }

}

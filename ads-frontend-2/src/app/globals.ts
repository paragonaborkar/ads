import { OnInit, Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable()
export class Globals implements OnInit {
	appModulesAvailable: any = {};

	// apiUrl: string="http://localhost:8080";
	apiUrl="/api";

	askAQuestionUrl = "https://support.netapp.com?adsRequest=question";
	reportAProblemUrl = "https://support.netapp.com?adsRequest=problem";

	readonly TOKEN_AUTH_USERNAME = 'adsClient'; // FIXME: Comment - why and how used in Login Service
	readonly TOKEN_AUTH_PASSWORD = 'sdjlh9#$380231funej01382#$';  // FIXME: Comment - why and how used in Login Service

	constructor(private http: HttpClient) {
		this.http.get('assets/global.json')
			.subscribe(data => {
				this.askAQuestionUrl = data["askAQuestionUrl"];
				this.reportAProblemUrl = data["reportAProblemUrl"];
			});
	}

	ngOnInit() {

    }

}

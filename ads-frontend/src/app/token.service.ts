import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers, ResponseContentType} from '@angular/http';
import { SessionHelper } from './core/session.helper';

@Injectable()
export class TokenService {
    
    constructor(private http:Http, private _sessionHelper:SessionHelper ) {
    }

    token(){
    	let authToken = this._sessionHelper.getToken().access_token;
        const headers = new Headers();
        headers.append('Content-Type', 'application/json');
        headers.append('Authorization', `bearer ${authToken}`);
        let options = new RequestOptions({ headers: headers });
        return options;
    }
}
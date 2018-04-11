import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable()
export class SessionHelper {

    myRawToken = '';
    expirationDate: Date;
    isExpired = true;
    decodedToken = null;

    constructor(private jwtHelperService: JwtHelperService) {
        this.init();
    }

    init() {
        this.myRawToken = localStorage.getItem('access_token');

        if (this.myRawToken != undefined && this.myRawToken != "undefined") {
            this.isExpired = this.jwtHelperService.isTokenExpired(this.myRawToken);

            this.decodedToken = this.jwtHelperService.decodeToken(this.myRawToken);
            this.expirationDate = this.jwtHelperService.getTokenExpirationDate(this.myRawToken);
        } else {
            this.removeAll();
        }
    }

    getToken() {
        return this.myRawToken;
    }

    get(key: string): any {
        if (this.decodedToken == null)
            this.init();

        console.log( "decodedToken:",  this.decodedToken);
        console.log( "key", key );
        console.log( "this.decodedToken[key]", this.decodedToken[key]);

        const item = this.decodedToken[key];
        if (item == 'undefined' || item == null) {
             return null; 
        } else {
           return item;
        }
    }

    removeAll() {
        localStorage.clear();
    }   
}
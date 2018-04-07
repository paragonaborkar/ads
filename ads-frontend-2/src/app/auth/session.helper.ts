import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable()
export class SessionHelper {
    private _tokenKey = 'accessTokenInfo';

    myRawToken = '';
    expirationDate: Date;
    isExpired = true;
    decodedToken = '';

    constructor(private jwtHelperService: JwtHelperService) {
        this.myRawToken = localStorage.getItem('access_token');

        if (this.myRawToken != undefined) {
            this.isExpired = this.jwtHelperService.isTokenExpired(this.myRawToken);

            this.decodedToken = this.jwtHelperService.decodeToken(this.myRawToken);
            this.expirationDate = this.jwtHelperService.getTokenExpirationDate(this.myRawToken);
        }
    }

    getToken() {
        return this.myRawToken;
    }

    get(key: string): any {     
        const item = this.decodedToken[key];
        if (item == 'undefined' || item == null) { return null; }
        return item;
    }

    removeAll() {
        localStorage.clear();
    }   
}
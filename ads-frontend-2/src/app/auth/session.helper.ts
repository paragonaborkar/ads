import { Injectable } from '@angular/core';

@Injectable()
export class SessionHelper {
    private _storage: Storage;
    private _tokenKey: string = 'accessTokenInfo';
    private _migKey: string='migKey';

    constructor() {
        this._storage = sessionStorage;
    }

    setToken(token: any) {
        this._storage.setItem(this._tokenKey, JSON.stringify(token));
    }

    getToken() {
        return this.get<any>(this._tokenKey);
    }

    set(key: string, value: any) {
        this._storage.setItem(key, JSON.stringify(value));
    }

    get<T>(key: string): T {
        let item = this._storage.getItem(key);
        if (!item || item == 'undefined' || item == null) return null;
        return <T>JSON.parse(item);
    }

    isAuthenticated() {
        let token = this.getToken();
        if (!token || token == 'undefined' || token == null) return false;
        return token.expires_in > 0;
    }

    removeAll() {
        this._storage.clear();
        localStorage.clear();
    }

    public isTokenExpired(token?: string, offsetSeconds?: number) {
        let expiresIn = 0;

         if (this.get<any>(this._tokenKey) != null) {
            expiresIn = this.get<any>(this._tokenKey).expires_in;

        }
        console.log("this._tokenKey:"+this._tokenKey);
        console.log("expiresIn:"+expiresIn);


        // let expiresIn = this.get<any>(this._tokenKey).expires_in;
        let date = new Date(0); // The 0 here is the key, which sets the date to the epoch
        date.setUTCSeconds(expiresIn);
        offsetSeconds = offsetSeconds || 0;
        if (date === null) {
            return false;
        }
        // Token expired?
        return !(date.valueOf() > (new Date().valueOf() + (offsetSeconds * 1000)));
    }

    setMigKey(migKey: any) {
        this._storage.setItem(this._migKey, migKey);
    }

    getMigKey() {
        return this.get<any>(this._migKey);
    }

}

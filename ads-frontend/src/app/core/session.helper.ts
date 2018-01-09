import { Injectable } from '@angular/core';

@Injectable()
export class SessionHelper {
    private _storage: Storage;
    private _tokenKey: string = 'accessTokenInfo';

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
        var item = this._storage.getItem(key);
        if (!item || item == 'undefined' || item == null) return null;
        return <T>JSON.parse(item);
    }

    isAuthenticated() {
        var token = this.getToken();
        if (!token || token == 'undefined' || token == null) return false;
        return token.expires_in > 0;
    }

    removeAll() {
        this._storage.clear();
    }

    public isTokenExpired(token?: string, offsetSeconds?: number) {
        var expiresIn = this.get<any>(this._tokenKey).expires_in;
        var date = new Date(0); // The 0 here is the key, which sets the date to the epoch
        date.setUTCSeconds(expiresIn);
        offsetSeconds = offsetSeconds || 0;
        if (date === null) {
            return false;
        }
        // Token expired?
        return !(date.valueOf() > (new Date().valueOf() + (offsetSeconds * 1000)));
    }

}

import { SpringRestResponse } from './spring-rest-response';
import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';



@Injectable()
export class UserAdminService {

  constructor(private http: Http) { }

  private serviceUrl = 'http://localhost:8080/userNatives';
  private headers = new Headers({ 'Content-Type': 'application/json' });

  getUserNatives() {
    return this.http.get(this.serviceUrl)
      .map((res: Response) => (res.json()))
      .catch(this.handleError);
  }

  private handleError(error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }

    console.error(errMsg);
    return Observable.throw(errMsg);
  }

  addUser(obj): Observable<any> {
    console.log('User Object in Add User - ', obj);
    return this.http.post(this.serviceUrl, obj).map(function (response) {
      return response.json();
    }).catch(function (err) {
      return err;
    });
  }
  update(user: Object): Observable<Object> {
    const url = user['_links']['self']['href'];
    return this.http
      .put(url, JSON.stringify(user), { headers: this.headers })
      .map((res: Response) => res.json() as Object)
      // .map(() => user)
      .catch(this.handleError);
  }

  delete(user: Object): Observable<any> {
    console.log(user);
    const url = user['_links']['self']['href'];
    console.log('Calling delete for URL:' + url);
    return this.http.delete(url, { headers: this.headers })
      .map(() => null)
      .catch(this.handleError);
  }


}

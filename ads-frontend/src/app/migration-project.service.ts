import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { SpringRestResponse } from './spring-rest-response';


@Injectable()
export class MigrationProjectService {
  
  constructor(private http: Http) { }

  private serviceUrl = 'http://localhost:8080/migrationProjects';
  private headers = new Headers({'Content-Type': 'application/json'});

  getMigrationProjects(): Observable<SpringRestResponse> {
    return this.http.get(this.serviceUrl)
    				.map((res:Response) => new SpringRestResponse(res.json())) 
                    .catch(this.handleError);
  }
  
  private handleError (error: Response | any) {
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

  create(name: string): Observable<Object> {
    console.log("Creating new:" + name);

    return this.http
      .post(this.serviceUrl, JSON.stringify({migrationProjectName: name}), {headers: this.headers})
      .map( (res:Response) => res.json() as Object)
      .catch(this.handleError);
  }

  update(project: Object): Observable<Object> {
    const url = project["_links"]["self"]["href"];
    return this.http
      .put(url, JSON.stringify(project), {headers: this.headers})
      .map( (res:Response) => res.json() as Object)
      // .map(() => project)
      .catch(this.handleError);
  }

  delete(project: Object): Observable<void> {
    const url = project["_links"]["self"]["href"];
    console.log("Calling delete for URL:" + url);
    return this.http.delete(url, {headers: this.headers})
      .map(() => null)
      .catch(this.handleError);
  }


}

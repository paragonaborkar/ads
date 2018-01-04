import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { SpringRestResponse } from '../spring-rest-response';


@Injectable()
export class ProjectsService {

  constructor(private http: Http) { }

  // default url
  private serviceUrl = 'http://localhost:8080/assign-migration-specialist.json';
  
  getProjects(jsonUrl?:string): Observable<SpringRestResponse> {
    console.log(jsonUrl);
    if (jsonUrl) {
      this.serviceUrl = jsonUrl;
    }

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

}
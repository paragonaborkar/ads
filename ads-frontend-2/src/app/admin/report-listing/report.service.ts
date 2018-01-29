import { Injectable } from '@angular/core';
// import { Response, RequestOptions, Headers, ResponseContentType} from '@angular/http';
import {RequestOptions, ResponseContentType, Headers} from '@angular/http';
import {HttpClient, HttpResponse} from "@angular/common/http";

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';

import { SpringRestResponse } from '../../spring-rest-response';


import { saveAs as importedSaveAs} from "file-saver";

import { SessionHelper } from '../../auth/session.helper';
import { Globals } from '../../globals';

@Injectable()
export class ReportService {
    
     private reportServiceUrl = '';

    constructor(private http:HttpClient, private _sessionHelper:SessionHelper,  private globals: Globals) {
        this.reportServiceUrl = globals.apiUrl;
    }
    
   /**
   * Generates Jasper Report
   */
    // openJasperReport(e){
    //     return this.http.get(this.reportServiceUrl+'/htmlReport/1').toPromise()
    //         .then(function(data){
    //         return data;
    //         },function(error){
    //             //FIXME
    //         })
    
    // }


    openJasperReport(e): Observable<SpringRestResponse> {
        console.log(
            "here"
        );

        return this.http.get(this.reportServiceUrl+'/htmlReport/1')
                        .map((res:Response) => new SpringRestResponse(res.json())) 
                        .catch(this.handleError);

                      
      }
      
      private handleError (error: Response | any) {
          // In a real world app, you might use a remote logging infrastructure
          let errMsg: string;
          if (error instanceof Response) {
            const body = error.json() || '';
            const err = JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
          } else {
            errMsg = error.message ? error.message : error.toString();
          }
    
          console.error(errMsg);
          return Observable.throw(errMsg);
      }
   
    private extractData(res: Response) {
    let body = res.json();
        return body;
    }
    private handleErrorObservable (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
    }

    /**
    * Downloads Jasper Report
    */
    downloadJasperReport() {
        
        const type = 'application/vnd.ms-excel';
        const fileName = 'UserReport.xls';
        
        const headers = new Headers({ 'Accept': type });
        
        const options = new RequestOptions({
            responseType: ResponseContentType.Blob,
            headers: headers
        });
        
        
        // this.http.get(this.reportServiceUrl+'/downloadReport', options)
        // .catch(errorResponse => Observable.throw(errorResponse.json()))
        // .map((response) => { 
        //     if (response instanceof Response) {
        //         return response.blob();
        //     }
        //         return response;
        //     })
        // .subscribe(data => importedSaveAs(data, fileName),
        //         error => console.log(error)); 
        
    }
        
} 
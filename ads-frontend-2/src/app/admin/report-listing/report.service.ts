import { Injectable } from '@angular/core';
import { RequestOptions, ResponseContentType, Headers } from '@angular/http';
import { HttpClient, HttpHeaders, HttpResponse, HttpParams } from "@angular/common/http";

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';

// import { SpringRestResponse } from '../../spring-rest-response';


import { saveAs as importedSaveAs } from "file-saver";

import { SessionHelper } from '../../auth/session.helper';
import { Globals } from '../../globals';

@Injectable()
export class ReportService {

    private reportServiceUrl = '';

    constructor(private http: HttpClient, private _sessionHelper: SessionHelper, private globals: Globals) {
        this.reportServiceUrl = globals.apiUrl;
    }



    openJasperReport(pageNo, reportName): Observable<any> {
    

        return this.http.get(this.reportServiceUrl + '/generateReport?pageNo=' + pageNo + '&reportName=' + reportName)
            .map((res: Response) => res)
            .catch(this.handleError);
    }

    private handleError(error: Response | any) {
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
    private handleErrorObservable(error: Response | any) {
        console.error(error.message || error);
        return Observable.throw(error.message || error);
    }

    /**
    * Downloads Jasper Report
    */
    downloadJasperReport(reportName) {

        const type = 'application/vnd.ms-excel';
        const fileName = 'Report.xls';

        const headers = new HttpHeaders({ 'Accept': type });

        //Add download process feature: https://blog.angularindepth.com/the-new-angular-httpclient-api-9e5c85fe3361

        this.http.get(this.reportServiceUrl + '/downloadReport?reportName=' + reportName,
            { headers: headers, responseType: 'blob', reportProgress: true })
            .catch(errorResponse => Observable.throw(errorResponse))
            .map((response) => {
                if (response instanceof Response) {
                    return response.blob();
                }
                return response;
            })
            .subscribe(data => importedSaveAs(data, fileName),
            error => console.error(error));
    }

} 
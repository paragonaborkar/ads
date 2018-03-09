import { Injectable } from '@angular/core';

import { Headers, Response } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import { RequestOptions } from '@angular/http';

import { saveAs as importedSaveAs } from "file-saver";

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { AdsErrorService } from '../common/ads-error.service';
import { Globals } from '../globals';
import { Page } from "../common/page";


@Injectable()
export class OwnerService {
    private reportServiceUrl = '';


    constructor(private http: HttpClient, private errorService: AdsErrorService, private global: Globals) {

    }

    private activitiesePath = '/activities/search/findByDisposition?disposition=DiscoverOwner&projection=activityWithQtree';
    // private activitiesePath = '/activities/27';
    private servicePath = '/userNatives/';
    private validateMigKey = '/validate-migration-key/';

    // {{url}}/activities/search/findByDisposition?disposition=NFS-Orphan&projection=activityWithQtree
    // {{url}}
    getAllActivities(page: Page): Observable<any> {

        // return this.http.get(this.global.apiUrl + this.activitiesePath + "&page=" + page.number + "&size=" + page.size)
        return this.http.get(this.global.apiUrl + "/activities?page=" + page.number + "&size=" + page.size)
            .map((res: Response) => res)
        // .catch(
        // Handle error in Subscribe() using the AdsErrorService  
        // You can optionally handle it here, if needed    
        //   );
    }

    openJasperReport(pageNo, reportName): Observable<any> {
        return this.http.get(this.global.apiUrl + '/generateReport?pageNo=' + pageNo + '&reportName=' + reportName)
            .map((res: Response) => res)
            .catch(this.handleError);
    }

    /**
      * Downloads Jasper Report
      */
    downloadJasperReport(reportName) {

        const type = 'application/vnd.ms-excel';
        const fileName = 'Report.xls';
        const headers = new HttpHeaders({ 'Accept': type });

        //Add download process feature: https://blog.angularindepth.com/the-new-angular-httpclient-api-9e5c85fe3361

        this.http.get(this.global.apiUrl + '/downloadReport?reportName=' + reportName,
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

    private handleError(error: Response | any) {
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

    getQTreesForOwner(migKey): Observable<any> {
        console.log("getQTreesForOwner:", migKey);

        return this.http.get(this.global.apiUrl + this.servicePath)
            .map((res: Response) => res)
        // .catch(
        // Handle error in Subscribe() using the AdsErrorService  
        // You can optionally handle it here, if needed    
        //   );
    }


    validateMigKeyExists(migKey: string, userCorpId: number): Observable<any> {

        return this.http.get(this.global.apiUrl + this.validateMigKey + migKey + '/' + userCorpId)
            .map(res => res)
            .map((res: any) => {
                return res;
            });
    }

}

import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { saveAs as importedSaveAs } from "file-saver";

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { AdsErrorService } from '../../common/ads-error.service';
import { Globals } from '../../globals';


@Injectable()
export class ReportCommonService {

  private servicePath = '/adsReports/';

  constructor(private http: HttpClient, private errorService: AdsErrorService, private global: Globals) { }


  getReportsForModule(adsModule: String): Observable<any> {
    return this.http.get(this.global.apiUrl + this.servicePath + "/search/findByAdsModule?adsModule=" + adsModule)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }

  // FIXME: add module as a parameter
  openJasperReport(pageNo, reportName): Observable<any> {
    return this.http.get(this.global.apiUrl + '/generateReport?pageNo=' + pageNo + '&reportName=' + reportName)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );

  }


  downloadJasperReport(reportName) {

    let type = 'application/vnd.ms-excel';
    let fileName = 'Report.xls';
    let headers = new HttpHeaders({ 'Accept': type });

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

}

import { Injectable } from '@angular/core';

import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { AdsErrorService } from '../../common/ads-error.service';
import { Globals } from '../../globals';

@Injectable()
export class ManualFunctionService {

  constructor(private http: HttpClient, private errorService: AdsErrorService, private global: Globals) { }

  runJob(jobName): Observable<any> {
    return this.http
      .post(this.global.apiUrl  + "/" + jobName, null)
      .map((res: Response) => res);
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }


  postFileAndRunJob(fileToUpload: File, jobName): Observable<boolean> {
    let headers = new HttpHeaders({ 'AdsFile': "AdsFile-TOBEREMOVED" });
    const formData: FormData = new FormData();
    formData.append('file', fileToUpload, fileToUpload.name);

    return this.http
      .post(this.global.apiUrl  + "/" +  jobName, formData, { headers: headers, reportProgress: true })
      .map(() => { return true; });

  }
}

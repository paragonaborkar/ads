import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers, ResponseContentType} from '@angular/http';
import { Observable } from 'rxjs';
import { saveAs as importedSaveAs} from "file-saver";
import { SessionHelper } from '../core/session.helper';
import { TokenService } from '../token.service';
import { environment } from "../../environments/environment";
import 'rxjs/add/operator/map';

@Injectable()
export class ReportService {
    
    constructor(private http:Http, private _sessionHelper:SessionHelper, private tokenService:TokenService ) {
    }
    
   /**
   * Generates Jasper Report
   */
    openJasperReport(e){

        let options = this.tokenService.token();

        return this.http.get(environment.serverUrl+'/htmlReport/1',options).toPromise()
            .then(function(data){
            return data;
            },function(error){})
    
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
        
        let authToken = this._sessionHelper.getToken().access_token;
        const headers = new Headers({ 'Accept': type });
           
        headers.append('Authorization', `bearer ${authToken}`);
        let abc = this.tokenService.token();
        const options = new RequestOptions({
        responseType: ResponseContentType.Blob,
        headers: headers
        });
        this.http.get(environment.serverUrl+'/downloadReport', options)
        .catch(errorResponse => Observable.throw(errorResponse.json()))
        .map((response) => { 
            if (response instanceof Response) {
                return response.blob();
            }
                return response;
            })
        .subscribe(data => importedSaveAs(data, fileName),
                error => console.log(error)); 
        
    }
        
} 
import { Injectable } from '@angular/core';

import { Headers, Response } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import { RequestOptions } from '@angular/http';

import { saveAs as importedSaveAs } from "file-saver";

import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { AdsErrorService } from '../../common/ads-error.service';
import { Globals } from '../../globals';
import { Page } from "../../common/page";


@Injectable()
export class OperationalOverrideService {


  constructor(private http: HttpClient, private errorService: AdsErrorService, private global: Globals) { }


  getActivities(page: Page): Observable<any> {

    let urlParms = "projection=activityWithQtree";

    let pagingParms = "&page=" + page.number + "&size=" + page.size;

    return this.http.get(this.global.apiUrl + "/activities/search/findUnidentifiedOwners?" + urlParms + pagingParms)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }


  getDropDown(fieldName, fieldCascadeName): Observable<any> {

    // let urlParms = "projection=activityWithQtree";  
    let urlParms = "";
    if (fieldCascadeName != null)
      urlParms = "search/findByFieldNameAndFieldCascadeName?fieldName="+ fieldName + "&fieldCascadeName=" + fieldCascadeName;  
    else 
      urlParms = "search/findByFieldName?fieldName="+ fieldName;

    return this.http.get(this.global.apiUrl + "/sysFieldValues/" + urlParms)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }

  getRequestedByPerson(search): Observable<any> {

    let params = "?firstContains=" + search + "&lastContains=" + search + "&projection=UserCorporate";
    console.log("getRequestedByPerson params " + params);
    return this.http
      .get(this.global.apiUrl + "/userCorporates/search/findByFirstNameContainingOrLastNameContaining" + params)
      .map((res: Response) => res["_embedded"]["userCorporates"]);
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );

  }

}

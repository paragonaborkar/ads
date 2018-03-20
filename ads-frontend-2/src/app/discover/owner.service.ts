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

    private validateMigKey = '/validateMigrationKey/';

    constructor(private http: HttpClient, private errorService: AdsErrorService, private global: Globals) { }


    getAllActivitiesForUser(migKey, corpUserId, page: Page): Observable<any> {

        let urlParms = "migKey=" + migKey + "&corpUserId=" + corpUserId + "&disposition=DiscoverOwner" + "&projection=activityWithQtree";

        let pagingParms = "&page=" + page.number + "&size=" + page.size;

        return this.http.get(this.global.apiUrl + "/activities/search/getActivitiesFromMigrationKeyAndCorpUserId?" + urlParms +pagingParms)
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

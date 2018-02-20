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
export class QtreesService {

    private IS_MIG_EXIST='/validate-migrationkey/';

    constructor(private http: HttpClient, private globals: Globals) {
    }

    isMigKeyExists(migKey: string, userCorpId: number):  Observable<any> {
  
        return this.http.get(this.globals.apiUrl + this.IS_MIG_EXIST+migKey+'/'+userCorpId)
        .map(res => res)
        .map((res: any) => {
          return res;
        });
      }

} 
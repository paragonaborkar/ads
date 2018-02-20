import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { Globals } from '../../globals';

@Injectable()
export class QtreesService {

    private IS_MIG_EXIST='/validate-migration-key/';

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
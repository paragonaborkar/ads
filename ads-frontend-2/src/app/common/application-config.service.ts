import { Injectable } from '@angular/core';
import { Headers, Response, RequestOptions } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Globals } from '../globals';
import { AdsHelperService } from './ads-helper.service';
import { AdsErrorService } from './ads-error.service';

@Injectable()
export class ApplicationConfigService {
  private preferencesServiceUrl = '';

  constructor(private http: HttpClient, private globals: Globals, private adsHelper: AdsHelperService, private adsError: AdsErrorService) {
    this.preferencesServiceUrl = globals.apiUrl + '/preferences/';
  }

  // Only get SYSTEM Configurable screens
  getPreferencesForSystemAdmin(): Observable<any> {
    let url = this.adsHelper.replaceParam(this.preferencesServiceUrl + "search/findByPreferenceType",
      [{ "preferenceType": "SYSTEM" }, { "projection": "preferenceWithPreferenceDetails" }], true);

    console.log("getPreferences Calling:" + url);

    return this.http.get(url)
      .map((res) => res)
      .catch(error => error);
  }


  // Only get USER Configurable screens for a specific User
  getPreferencesForUser(pageName, nativeUserId, corpUserId): Observable<any> {

    // First try to get the User's preference, should it previously exist.
    let url = this.adsHelper.replaceParam(this.preferencesServiceUrl + "search/findByPreferenceTypeAndPageNameAndNativeUserIdAndCorpUserId",
      [{ "preferenceType": "USER" }, { "pageName": pageName }, { "nativeUserId": nativeUserId }, { "corpUserId": corpUserId }, { "projection": "preferenceWithPreferenceDetails" }], true);
    console.log("getPreferencesForUser Calling:" + url);

    // If the User doesn't have a preference for this screen, then copy the SYSTEM for the USER and return it.
    return this.http.get(url)
      .map((res) => res)
      .catch(error => {

        this.adsError.processErrorForGet(error, false);
        return Observable.throw(error);
        }
      );
  }


  
  getPreferenceDetailsForPreference(selectedPreferenceDetailsResource: any): Observable<any> {
    return this.http.get(selectedPreferenceDetailsResource)
      .map(response => response)
      .catch(error => error);
  }



  updatePreferenceDetails(updatedPreferenceDetail: any): Observable<any> {
    console.log("updatedPreferenceDetail.patchLink:");
    console.log(updatedPreferenceDetail);
    return this.http.patch(updatedPreferenceDetail.patchLink,
      {
        fieldOrder: updatedPreferenceDetail.fieldOrder,
        fieldVisible: updatedPreferenceDetail.fieldVisible
      }).map(function (response) {
        // return response.json();
        return response;
      }).catch(function (err) {
        return err;
      });
  }


}

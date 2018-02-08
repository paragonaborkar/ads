import { Injectable } from '@angular/core';
import { Headers, Response, RequestOptions } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Globals } from '../globals';

@Injectable()
export class ApplicationConfigService {
  private preferencesServiceUrl = '';

  constructor(private http: HttpClient,  private globals: Globals) { 
     this.preferencesServiceUrl = globals.apiUrl + '/preferences';
  }

  getPreferences(): Observable<any> {
    console.log("Calling:" + this.preferencesServiceUrl);
    return this.http.get(this.preferencesServiceUrl)
      .map((res) => res)
      .catch(error => error);
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

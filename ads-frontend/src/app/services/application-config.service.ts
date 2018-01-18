import { Injectable } from '@angular/core';
import { Headers, Http, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { TokenService } from '../token.service';

@Injectable()
export class ApplicationConfigService {
  private preferencesServiceUrl = 'http://localhost:8080/preferences';
  private headers = new Headers({ 'Content-Type': 'application/json' });

  constructor(private http: Http, private tokenService: TokenService) { }

  getPreferences(): Observable<any[]> {

    let options = this.tokenService.token();
    return this.http.get(this.preferencesServiceUrl, options)
      .map(response => response.json()._embedded.preferences)
      .catch(error => error);
  }

  getPreferenceDetailsForPreference(preference: any) {
    let options = this.tokenService.token();
    return this.http.get(preference._links.preferenceDetails.href, options)
      .toPromise()
      .then(res => res.json()._embedded.preferenceDetails)
      .then(data => data);
  }

  updatePreferenceDetails(updatedPreferenceDetail: any): Observable<any> {
    let options = this.tokenService.token();
    return this.http.patch(updatedPreferenceDetail.patchLink,
      {
        fieldOrder: updatedPreferenceDetail.fieldOrder,
        fieldVisible: updatedPreferenceDetail.fieldVisible
      }, options).map(function (response) {
        return response.json();
      }).catch(function (err) {
        return err;
      });
  }

}

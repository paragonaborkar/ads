import { Injectable } from '@angular/core';
import { Headers, Response, RequestOptions } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Globals } from '../globals';
import { AdsHelperService } from './ads-helper.service';
import { AdsErrorService } from './ads-error.service';
import { FriendlyLabelPipePipe } from '../pipes/friendly-label-pipe.pipe';


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



  getPreferencesForColumns(columns, hdrTmpl, actionTmpl): Observable<any> {
    return this.getPreferencesForUser("UserListing", 1, 0)
      .map(columnPreferences => columnPreferences._links.preferenceDetails.href)
      .switchMap(preferenceDetailsHref => {
        if (preferenceDetailsHref !== null && preferenceDetailsHref !== undefined) {
          return this.getPreferenceDetailsForPreference(preferenceDetailsHref);
        }
      })
      .map(preferenceDetails => {
        console.log(preferenceDetails);

        preferenceDetails._embedded.preferenceDetails.forEach(preferenceDetail => {

          var obj = columns.find(function (obj) {
            return obj.name === preferenceDetail.fieldName;
          }, preferenceDetail.fieldName);

          if (obj == undefined) {
            if (preferenceDetail.fieldVisible === 1) {
              columns.push({
                name: new FriendlyLabelPipePipe().transform(preferenceDetail.fieldName),
                prop: preferenceDetail.fieldName,
                order: preferenceDetail.fieldOrder
              });
            }

          } else {
            // This is when we initialize the list of columns manually through this component.
            columns.find(column => {
              if (column.name === preferenceDetail.fieldName) {
                // column.hidden = preferenceDetail.fieldVisible === 1 ? false : true;
                return true;
              }
            });
          }
        });

        columns.push({
          headerTemplate: hdrTmpl,
          cellTemplate: actionTmpl,
          order: 1000
        });


        // Display the columns in the correct order now that we have the complete set of them.
        this.sortColumns(columns);
        console.log("Sorted: this.columns");
        console.log(columns);
        return columns;
      });

  }

  
  sortColumns(items: any[]) {
    items.sort(function (item1, item2) {
      if (item1.order > item2.order) {
        return 1;
      } else {
        return -1;
      }
    });
  }


}

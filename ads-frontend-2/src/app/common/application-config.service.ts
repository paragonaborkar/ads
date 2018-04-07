import { Injectable } from '@angular/core';
import { Headers, Response, RequestOptions } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Globals } from '../globals';
import { AdsHelperService } from './ads-helper.service';
import { AdsErrorService } from './ads-error.service';
import { FriendlyLabelPipePipe } from '../pipes/friendly-label-pipe.pipe';
import { SessionHelper } from '../auth/session.helper';


@Injectable()
export class ApplicationConfigService {
  private preferencesServiceUrl = '';
  private apiUrl;

  constructor(private http: HttpClient, private globals: Globals, private adsHelper: AdsHelperService, private adsError: AdsErrorService, private sessionHelper: SessionHelper) {
    this.apiUrl = globals.apiUrl;
    this.preferencesServiceUrl = this.apiUrl + '/preferences/';
  }

  // Only get SYSTEM Configurable screens
  // This is for the admin's configuration page.
  getPreferencesForSystemAdmin(): Observable<any> {
    let url = this.adsHelper.replaceParam(this.preferencesServiceUrl + "search/findByPreferenceType",
      [{ "preferenceType": "SYSTEM" }, { "projection": "preferenceWithPreferenceDetails" }], true);

    console.log("getPreferences Calling:" + url);

    return this.http.get(url)
      .map((res) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }


  // Get Configurable screens for a specific User
  // First try to get the User's preference, should it previously exist.
  // Then try to get the System preference, it should exist.
  getPreferencesForUser(pageName, nativeUserId, corpUserId, copySystemToUser: boolean = false): Observable<any> {

    // let url = this.preferencesServiceUrl + "search/findByPreferenceTypeAndPageNameAndNativeUserIdAndCorpUserId"; { "projection": "preferenceWithPreferenceDetails" }
    let url = this.apiUrl + "/getPreferencesForUser";

    url = this.adsHelper.replaceParam(url,
      [{ "preferenceType": "USER" }, { "pageName": pageName }, { "nativeUserId": nativeUserId }, { "corpUserId": corpUserId }, { "copySystemToUser": copySystemToUser }], true);
    console.log("getPreferencesForUser Calling:" + url);

    // If the User doesn't have a preference for this screen, then copy the SYSTEM for the USER and return it.
    return this.http.get(url)
      .map((res) => res);
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );

  }


  getPreferenceDetailsForPreference(selectedPreferenceDetailsResource: any): Observable<any> {
    return this.http.get(selectedPreferenceDetailsResource)
      .map(response => response);
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed

  }



  updatePreferenceDetails(updatedPreferenceDetail: any): Observable<any> {
    console.log("updatedPreferenceDetail.patchLink:");
    console.log(updatedPreferenceDetail);
    return this.http.patch(updatedPreferenceDetail.patchLink,
      {
        fieldOrder: updatedPreferenceDetail.fieldOrder,
        fieldVisible: updatedPreferenceDetail.fieldVisible
      }).map(response => response);
    // return response.json();
    // return response;
    // });
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
  }


  // getPreferencesForColumns(pageName, columns, hdrTmpl, actionTmpl, dateTimeTmpl, asIsTmpl): Observable<any> {
    getPreferencesForColumns(pageName, columns, columnTemplates, actionColumn:boolean): Observable<any> {
    
      console.log("corpUserId 2: " + this.sessionHelper.get("corpUserId"));
    return this.getPreferencesForUser(pageName, this.sessionHelper.get("nativeUserId"), this.sessionHelper.get("corpUserId"))
      .map(preferenceDetails => {
        console.log(preferenceDetails);

        preferenceDetails._embedded.preferenceDetails.forEach(preferenceDetail => {

          var obj = columns.find(function (obj) {
            return obj.name === preferenceDetail.fieldName;
          }, preferenceDetail.fieldName);

          if (obj == undefined) {
            if (preferenceDetail.fieldVisible === 1) {
              
              console.log(preferenceDetail.fieldTemplate);
              let template = columnTemplates.asIsTmpl;
              switch (preferenceDetail.fieldTemplate) {
                case "dateTime": {
                  template = columnTemplates.dateTimeTmpl;
                  break;
                }
                case "date": {
                  template = columnTemplates.dateTmpl;
                  break;
                }
                case "stringEdit": {
                  template = columnTemplates.stringEditTmpl;
                  break;
                }
                case "yesNo": {
                  template = columnTemplates.yesNoTmpl;
                  break;
                }

                
              }

              columns.push({
                name: new FriendlyLabelPipePipe().transform(preferenceDetail.fieldName),
                prop: preferenceDetail.fieldProp == "" ? preferenceDetail.fieldName: preferenceDetail.fieldProp,
                order: preferenceDetail.fieldOrder,
                flexGrow: 1,
                cellTemplate: template
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

        if (columnTemplates.actionHeaderTmpl != null && actionColumn) {
          columns.push({
            headerTemplate:columnTemplates.actionHeaderTmpl,
            cellTemplate: columnTemplates.actionTmpl,
            order: 1000,
            flexGrow: 1
          });
        }


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

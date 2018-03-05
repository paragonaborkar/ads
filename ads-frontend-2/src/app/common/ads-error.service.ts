import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SessionHelper } from '../auth/session.helper';
import { NGXLogger } from 'ngx-logger';
import { Router } from '@angular/router';

@Injectable()
export class AdsErrorService {

  public errorMessages;

  constructor(private router: Router, private http: HttpClient, private logger: NGXLogger, private sessionHelper: SessionHelper) {
    this.errorMessages = this.http.get('assets/errorMessages.json')
      .subscribe(data => {
        this.errorMessages = data;
      });
  }

  getSafe(fn) {
    try {
        return fn();
    } catch (e) {
        return undefined;
    }
}

  processError(error: HttpErrorResponse | any, actionName, method): string {
   
    this.remoteLogError(error, actionName);

    // First - if 401: Unauthorized, sent to the login page.
    if (this.getSafe(() => error.status)  != undefined){
      console.log("REDIRECT 1", error);
      if (error.status == 401) {
        console.log("REDIRECT 2");
        this.router.navigate(['login']);
      }
    }

    // Get the friendly error message based on the ADS error message configuration using the HTTP status response code:
    // Using actionName:
    // 1. Try to get the message by exact error code
    if (this.getSafe(() => this.errorMessages[actionName][method][error.status])  != undefined)
      return this.errorMessages[actionName][method][error.status];
    else {
      // 2. Try to get the message by error code based on class. Eg.g 1xx, 2xx, 3xx, etc
      let errorClass = error.status.toString().substring(0, 1) + "xx";
      if (this.getSafe(() => this.errorMessages[actionName][method][errorClass]) != undefined) {
        return this.errorMessages[actionName][method][errorClass];
      } else
        // 3. Try to get the  message using the default for the 
        if (this.getSafe(() => this.errorMessages[actionName][method]["default"]) != undefined) {
          return this.errorMessages[actionName][method]["default"];
        }
    }

    // If we didn't get an error message to display at this point, get a default one
    // 1. Try to get the message by exact error code
    if (this.getSafe(() => this.errorMessages["default"][error.status]) != undefined)
      return this.errorMessages["default"][error.status];
    else {
      // 2. Try to get the message by error code based on class. Eg.g 1xx, 2xx, 3xx, etc
      let errorClass = error.status.toString().substring(0, 1) + "xx";
      if (this.getSafe(() => this.errorMessages["default"][errorClass]) != undefined) {
        return this.errorMessages["default"][errorClass];
      } else
        // 3. Try to get the  message using the default for the 
        if (this.getSafe(() => this.errorMessages["default"]["default"]) != undefined) {
          return this.errorMessages["default"]["default"];
        }
    }
    return "Sorry, an application error has occurred.";

  }

  // Log errors that occur on the frontend to a server for review and fix
  remoteLogError(error: HttpErrorResponse | any, actionName) {
    console.log("remoteLogError");
    console.error(error);
    console.error(error.status.toString());

    let tokenInfo = this.sessionHelper.getToken();

    let nativeUserId = "";
    if (typeof tokenInfo.nativeUserId != 'undefined') {
      nativeUserId = tokenInfo.nativeUserId
    }
    
    let corpUserId = "";
    if (typeof tokenInfo.corpUserId != 'undefined') {
      corpUserId = tokenInfo.corpUserId
    }

    this.logger.error(actionName, "corpUserId:" + corpUserId, "nativeUserId:" + nativeUserId, error.status.toString(), error.message);
  }

}

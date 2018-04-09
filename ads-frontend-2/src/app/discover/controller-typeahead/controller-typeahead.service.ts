import { Injectable } from '@angular/core';

import { HttpClient, HttpErrorResponse } from '@angular/common/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { AdsErrorService } from '../../common/ads-error.service';
import { Globals } from '../../globals';

@Injectable()
export class ControllerTypeaheadService {
  private servicePathController = '/controllerReleases/';

  constructor(private http: HttpClient, private errorService: AdsErrorService, private global: Globals) { }

  getData(nameOfDataProvider: String, criteria: String): Observable<any> {
    switch (nameOfDataProvider) {
      case "findByControllerByNameContainingWithoutExistingWorkPackage": {
        return this.findByControllerByNameContainingWithoutExistingWorkPackage(criteria);
      }
      case "findByControllerNameContaining": {
        return this.findByControllerNameContaining(criteria);
      }
      case "findByControllerTargetsAvailableWithControllerNameContaining": {
        return this.findByControllerTargetsAvailableWithControllerNameContaining(criteria);
      }
      
      default: {
        return Observable.throw('Controller Typeahead Service Error: Name of data provider not found:' + nameOfDataProvider);
      }
    }
  }

  findByControllerTargetsAvailableWithControllerNameContaining(criteria: String): Observable<any> {

    return this.http.get(this.global.apiUrl + "/controllers/search/findByControllerTargetsAvailableWithControllerNameContaining?controllerNameContains=" + criteria + "&projection=ControllerId")
      .map((res: Response) => res["_embedded"]["controllers"]);
    // There were some posts on need to always return an observable, but didn't see this during development
    // .catch((error:any) => Observable.throw(error || 'Server error'));

    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }

  findByControllerNameContaining(criteria: String): Observable<any> {
    return this.http.get(this.global.apiUrl + "/controllers/search/findByControllerNameContaining?controllerNameContains=" + criteria + "&projection=ControllerId")
      .map((res: Response) => res["_embedded"]["controllers"]);
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }

  findByControllerByNameContainingWithoutExistingWorkPackage(criteria: String): Observable<any> {
    return this.http.get(this.global.apiUrl + "/controllers/search/findByControllerByNameContainingWithoutExistingWorkPackage?controllerNameContains=" + criteria + "&projection=ControllerId")
      .map((res: Response) => res["_embedded"]["controllers"]);
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }
}

import { SpringRestResponse } from '../../spring-rest-response';
import { Injectable } from '@angular/core';
import { Headers, Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';

// Don't use Promise, use Observable...
import { Observable } from 'rxjs/Observable';
import { RequestOptions } from '@angular/http';

import 'rxjs/add/operator/catch'; 
import 'rxjs/add/operator/map';

import { Page } from "../../common/page";
import { AdsErrorService } from '../../common/ads-error.service';
import { Globals } from '../../globals';


@Injectable()
export class UserAdminService {

  constructor(private http: HttpClient, private errorService: AdsErrorService, private global: Globals) { }

  private servicePath = '/userNatives/?projection=userNativeWithUserRole';
  private servicePathCreate = '/userNatives/';
  private userRolesPath = '/userRoles';

  getUserNatives(e): Observable<any> {
    return this.http.get(this.global.apiUrl + this.servicePath)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }

  getUserNativesPaging(page: Page): Observable<any> {
    return this.http.get(this.global.apiUrl + this.servicePath + "&page=" + page.number + "&size=" + page.size)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService  
    // You can optionally handle it here, if needed    
    //   );
  }

  getUserRoles(): Observable<any> {
    return this.http.get(this.global.apiUrl + this.userRolesPath)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }



  getUserRole(userRoleHref): Observable<any> {
    console.log('Get User Role- ', userRoleHref);
    return this.http
      .get(userRoleHref)
      .map(function (response) {
        return response;
      })
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }

  getUser(userHref): Observable<any> {
    console.log('Get User - ', userHref);
    return this.http
      .get(userHref)
      .map(function (response) {
        return response;
      })
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }

  /**
   * This method is to add user  in the usernatives table
   * @param obj
   */
  addUser(obj): Observable<any> {
    console.log('User Object in Add User - ', obj);
    return this.http
      .post(this.global.apiUrl +this.servicePathCreate, obj)
      .map(function (response) {
        return response;
      })
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }

  /**
   * This method is to edit user from usernatives table
   * @param user
   */
  update(user: Object, url): Observable<Object> {
    
    console.log("Trying to Update user:"+url);
    console.log(user);
    return this.http
      .patch(url, user)
      .map((res: Response) => res)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }

  /**
   * This method is to delete user from usernatives table
   * @param user
   */
  delete(user: Object): Observable<any> {
    console.log(user);

    const url = user['_links']['self']['href'];
    console.log('Calling delete for URL:' + url);
    return this.http
      .delete(url)
      .map(() => null)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }

  
  changePassword(user: Object): Observable<any> {
    console.log(user);

    const url = user['_links']['self']['href'];
    console.log('Calling delete for URL:' + url);
    return this.http
      .patch(url, user)
      .map(() => null)
    // .catch(
    // Handle error in Subscribe() using the AdsErrorService      
    // You can optionally handle it here, if needed
    //   );
  }


}

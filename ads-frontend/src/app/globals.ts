import { Injectable } from '@angular/core';

@Injectable()
export class Globals {
  	apiUrl: string = 'http://localhost:8080';
  	appModulesAvailable: any = {};

  	readonly  TOKEN_AUTH_USERNAME = 'testjwtclientid';
 	readonly  TOKEN_AUTH_PASSWORD = 'XY7kmzoNzl100';
 	readonly  TOKEN_NAME = 'accessTokenInfo';
 	readonly  ACCESS_TOKEN_NAME = 'access_token'; 
}
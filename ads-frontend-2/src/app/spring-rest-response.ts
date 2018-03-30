// https://www.npmjs.com/package/json-typescript-mapper
// Remove json-typescript-mapper from package.json if not used.
// import {JsonProperty} from 'json-typescript-mapper'; 

export class SpringRestResponse {
	// @JsonProperty('_embedded')
    _embedded: Object; 
    // @JsonProperty('_links')
    _links: Object;
     // @JsonProperty('page')
    page: Object;

    constructor(body) {
        console.log("SpringRestResponse body");
        console.log(body);
        this._embedded = body._embedded;
        this._links = body._links;
        this.page = body.page;
    }

   
}
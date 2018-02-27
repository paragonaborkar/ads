import { Injectable } from '@angular/core';


@Injectable()
export class AdsHelperService {

  constructor() { }


  // Example Usage: 
  // let url = this.replaceParam(this.preferencesServiceUrl + "search/findByPreferenceType", 
  // [{ "preferenceType": "SYSTEM" }, { "projection": "preferenceWithPreferenceDetails" }], true);
  replaceParam(originalUrl, paramsObject, add) {
    var newUrl = originalUrl;

    paramsObject.forEach(params => {
      for (let param in params) {

        var re = new RegExp("[\\?&:]" + param + "=([^&#]*)", "i"), match = re.exec(newUrl), delimiter, newString;
        if (match === null && add) {
          // append new param
          var hasQuestionMark = /\?/.test(newUrl);
          var hasColon = /\:/.test(newUrl);
          // delimiter = hasColon ? (hasQuestionMark ? "&:" : "?:") : (hasQuestionMark ? "&" : "?");
          delimiter = hasQuestionMark ? "&" : "?";
          newUrl = newUrl + delimiter + param + "=" + params[param];
        } else if (match) {
          delimiter = match[0].charAt(0);
          newUrl = newUrl.replace(re, delimiter + param + "=" + params[param]);
        } else {
          console.error("Parameter", "'" + param + "'", "Does not exist in url: ", originalUrl);
          console.error("To add these parameters to this url please change your method call to: replaceParam([Object], [Boolean=true])")
        }
      }
    })

    return newUrl;
  }


  // Flatten some data in nested JSON 
  ungroupJson(jsonObjList, groupToProcess, fieldsToIgnore) {
    jsonObjList.forEach(jsonObj => {
      for (let key in jsonObj) {
        if (key == groupToProcess) {
          let nestedData = jsonObj[groupToProcess];
          // remove the grouping, this will avoid a situtation when the "parent key name" === "child key name" OR when the field name is a dup, this can happen with "createTime"
          delete jsonObj[groupToProcess];

          for (let key2 in nestedData) {
            if (fieldsToIgnore.includes(key2)) {
              // console.log("skipping");
            } else {
              console.log("Checking for: " + key2);
              // Move the value up a level if it doesn't already exist
              if (!(key2 in jsonObj))
                jsonObj[key2] = nestedData[key2];
              else {
                console.error("Not adding:" + key2)
              }
            }
          }
        }
      }
    });
    return jsonObjList;
  }


  
}

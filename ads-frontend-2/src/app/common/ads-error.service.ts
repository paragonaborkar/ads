import { Injectable } from '@angular/core';

@Injectable()
export class AdsErrorService {

  constructor() { }

  processErrorForGet(error, valueRequired: boolean) {

    console.log("Processing Error:");
    console.log(error);

    if (error.status === 404 && valueRequired) {

    }

  }
}

import { Component, ViewChild, OnInit } from '@angular/core';
import { EventEmitter, Input, Output } from '@angular/core';
import { FormsModule, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';


import { ActivtyResponse } from "../../activity-response";

import { OwnerResponseService } from './owner-response.service';
import { SessionHelper } from '../../../auth/session.helper';
import { AdsErrorService } from '../../../common/ads-error.service';

// import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';


@Component({
  selector: 'app-owner-response',
  templateUrl: './owner-response.component.html',
  styleUrls: ['./owner-response.component.scss']
})
export class OwnerResponseComponent implements OnInit {
  @Output() saved = new EventEmitter();
  @Output() cancel = new EventEmitter();

  @Input() activityInfo = [];
  @Input() scheduleAction: any;

  isMultiOwner: boolean;
  potentialOwners = [];

  errorMessage = '';

  bsValue = null;

  public formGroup: FormGroup; // our model driven form

  activityResponse: ActivtyResponse = new ActivtyResponse();
  activityResponseInfoSource = {};
  corporateUserIdFromJwt = 9;
  // public bsModalRef: BsModalRef,

  constructor( private ownerResponseService: OwnerResponseService, private errorService: AdsErrorService, private sessionHelper: SessionHelper) { }

  ngOnInit() {

    this.dataSource = Observable.create((observer: any) => {
      // Runs on every search
      observer.next(this.asyncSelected);
    }).mergeMap((token: string) => this.getStatesAsObservable(token));


    let loginInfo = this.sessionHelper.getToken();
    // this.corporateUserIdFromJwt = loginInfo.corpUserId; // ************************************* FIX

    this.activityInfo["activityResponses"].forEach(activtyResponse => {
      // If we have an ActivityResponse for another Owner that hasn't responded yet, it's MultiOwner.
      if (activtyResponse["ownerUserCorporateId"] != this.corporateUserIdFromJwt) {

        if (!activtyResponse["isOwner"] && activtyResponse["isPresumed"]) {
          // Only display unprocessed Owners (Users) as potential Owners.
          this.potentialOwners.push(activtyResponse);

          this.isMultiOwner = true;
          console.log("isMultiOwner:" + this.isMultiOwner);
          // Get list of first, last names, Corp Ids to display in table.

          this.ownerResponseService.getCorpUserInfo(activtyResponse["ownerUserCorporateId"]).subscribe(
            response => {
              console.log(response);
              activtyResponse["firstName"] = response.firstName;
              activtyResponse["lastName"] = response.lastName;
              activtyResponse["userName"] = response.userName;
            }, err => {
              // Get the ADS configured error message to display.
              this.errorMessage = this.errorService.processError(err, "getCorpOwnerDetailsForOwnership", "GET");
            });

        }
      } else {
        this.activityResponseInfoSource = activtyResponse;
      }

    });

console.log("this.potentialOwners:", this.potentialOwners);

    this.formGroup = new FormGroup({
      // is Owner ?
      confirmOwner: new FormControl(null, Validators.required),

      // If Owner
      decommissionVolume: new FormControl(null, Validators.required),
      decommissionByDate: new FormControl(null),
      //   // migrationDate: new FormControl(),        // Use for Schedule module in future.
      //   // migrationStartTime: new FormControl(),   // Use for Schedule module in future.
      //   // dayOfWeek: new FormControl()             // Use for Schedule module in future.

      // If not Owner
      suggestedOwnerUserCorporateId: new FormControl(),
      dontKnowOwner: new FormControl(false),

      // For everyone, regardless of Owner response
      migrationTeamContactMe: new FormControl(false)
    });

    if (!this.isMultiOwner) {
      // let updatedDecommissionVolume = new FormControl(null, Validators.required);
      let updatedDecommissionByDate = new FormControl(null, Validators.required);

      // this.formGroup.addControl('decommissionVolume', updatedDecommissionVolume);
      this.formGroup.addControl('decommissionByDate', updatedDecommissionByDate);
    }
  }



  onDecommissionVolumeValueChanged(value: any) {
    let control = this.formGroup.get('decommissionByDate');
    // Using setValidators to add and remove validators. No better support for adding and removing validators to controller atm.
    // See issue: https://github.com/angular/angular/issues/10567
    if (value) {
      control.setValidators([Validators.required]);
    } else {
      control.setValidators([]);
    }

    control.updateValueAndValidity(); //Need to call this to trigger a update
  }


  save() {
    console.log(this.formGroup);

    this.activityResponse.activityResponseId = this.activityResponseInfoSource["id"];
    this.activityResponse.ownerUserCorporateId = this.activityResponseInfoSource["ownerUserCorporateId"];

    this.activityResponse.currentUserCorporateId = this.corporateUserIdFromJwt;

    this.activityResponse.isMultiOwner = this.isMultiOwner;
    this.activityResponse.isOwner = this.formGroup.value.confirmOwner;
    this.activityResponse.isPresumed = false; // If the Owner responds with T or F, then we set this to false to indicate it was processed.
    this.activityResponse.callMe = this.formGroup.value.migrationTeamContactMe;

    if (this.activityResponse.isOwner) {
      this.activityResponse.decommissionVolume = this.formGroup.value.decommissionVolume;
      this.activityResponse.decommissionByDate = this.formGroup.value.decommissionByDate;
    } else {
      this.activityResponse.dontKnowOwner = this.formGroup.value.dontKnowOwner;
      this.activityResponse.suggestedOwnerUserCorporateId = this.suggestedOwnerUserCorporateId;
      this.activityResponse.suggestedOwnerUserCorporateResourceUrl = this.suggestedOwnerUserCorporateResourceUrl;
    }


    // TODO: Handle an error and display a message in the modal.
    this.ownerResponseService.saveOwnerResponse(this.activityResponse).subscribe(
      response => {
        console.log(response);
        this.saved.emit();
      }, err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "saveOwnerResponse", "PATCH");
      });
  }


  close() {
    console.log("Calling close");
    this.cancel.emit();
  }


  asyncSelected: any;
  typeaheadLoading: boolean;
  typeaheadNoResults: boolean;
  dataSource: Observable<any>;
  suggestedOwnerUserCorporateId = 0;
  suggestedOwnerUserCorporateResourceUrl = '';

  getStatesAsObservable(token: string) {
    return this.ownerResponseService.getPotentialOwners(token);
  }

  changeTypeaheadLoading(e: boolean): void {
    this.typeaheadLoading = e;
  }

  changeTypeaheadNoResults(e: boolean): void {
    this.typeaheadNoResults = e;
    this.suggestedOwnerUserCorporateId = 0;
    this.suggestedOwnerUserCorporateResourceUrl = '';
  }

  typeaheadOnSelect(e: TypeaheadMatch): void {
    console.log('Selected value: ', e);

    this.asyncSelected = e.item["firstName"] + " " + e.item["lastName"];

    this.suggestedOwnerUserCorporateId = e.item["id"];
    this.suggestedOwnerUserCorporateResourceUrl = e.item["_links"]["self"]["href"];


    console.log("this.suggestedOwnerUserCorporateId :" + this.suggestedOwnerUserCorporateId);
  }

}

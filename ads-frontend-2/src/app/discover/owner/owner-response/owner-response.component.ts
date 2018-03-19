import { Component, ViewChild, OnInit } from '@angular/core';
import { EventEmitter, Input, Output } from '@angular/core';
import { FormsModule, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { ModalDirective } from 'ngx-bootstrap/modal';

import { ActivtyResponse } from "../../activity-response";

import { OwnerResponseService } from './owner-response.service';
import { SessionHelper } from '../../../auth/session.helper';
import { AdsErrorService } from '../../../common/ads-error.service';

@Component({
  selector: 'app-owner-response',
  templateUrl: './owner-response.component.html',
  styleUrls: ['./owner-response.component.scss']
})
export class OwnerResponseComponent implements OnInit {
  @ViewChild('ownerResponseModal') public ownerResponseModal: ModalDirective;
  @Output() saved = new EventEmitter();
  @Output() cancel = new EventEmitter();

  @Input() activityInfo: any;
  @Input() scheduleAction: any;
  @Input() isMultiOwner: boolean;

  errorMessage = '';

  bsValue = null;

  public formGroup: FormGroup; // our model driven form

  activityResponse: ActivtyResponse = new ActivtyResponse();
  loginInfo;

  constructor(private ownerResponseService: OwnerResponseService, private errorService: AdsErrorService, private sessionHelper: SessionHelper) { }

  ngOnInit() {
    this.loginInfo = this.sessionHelper.getToken();

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
      newVolumeOwner: new FormControl(),
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

    this.activityResponse.activityResponseId = this.activityInfo.activityResponses[0].id;
    this.activityResponse.ownerUserCorporateId = this.activityInfo.activityResponses[0].ownerUserCorporateId;
    
    // this.activityResponse.currentUserCorporateId = this.loginInfo.corpUserId;
    this.activityResponse.currentUserCorporateId = 9;

    this.activityResponse.isOwner = this.formGroup.value.confirmOwner;
    this.activityResponse.isPresumed = false; // If the Owner responds with T or F, then we set this to false to indicate it was processed.
    this.activityResponse.callMe = this.formGroup.value.migrationTeamContactMe;

    if (this.activityResponse.isOwner) {
      this.activityResponse.decommissionVolume = this.formGroup.value.decommissionVolume;
      this.activityResponse.decommissionByDate = this.formGroup.value.decommissionByDate;
    } else {
      this.activityResponse.dontKnowOwner = this.formGroup.value.dontKnowOwner;
      this.activityResponse.suggestedOwnerUserCorporateId = 0; // TODO   // Get from lookup.
    }


    // TODO: Handle an error and display a message in the modal.
    this.ownerResponseService.saveOwnerResponse(this.activityResponse).subscribe(
      response => {
        console.log(response);

        // this.saved.emit(this.user);
      }, err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "saveOwnerResponse", "PATCH");
      });
  }

  close() {
    this.cancel.emit();
  }


}

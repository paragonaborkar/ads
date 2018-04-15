import { Component, ViewChild, OnInit } from '@angular/core';
import { EventEmitter, Input, Output } from '@angular/core';
import { FormsModule, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { SessionHelper } from '../../../auth/session.helper';
import { AdsErrorService } from '../../../common/ads-error.service';

import { TypeaheadMatch } from 'ngx-bootstrap/typeahead';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';

import { OperationalOverrideService } from '../operational-override.service';

@Component({
  selector: 'app-op-override-confirm',
  templateUrl: './op-override-confirm.component.html',
  styleUrls: ['./op-override-confirm.component.scss']
})
export class OpOverrideConfirmComponent implements OnInit {
  @Output() saved = new EventEmitter();
  @Output() cancel = new EventEmitter();

  @Input() activityInfo = [];
  @Input() scheduleAction: any;

  isMultiOwner: boolean;
  potentialOwners = [];

  errorMessage = '';

  corporateUserIdFromJwt = 0;
  nativeUserIdFromJwt = 0;

  bsValue = null;

  unidentifiedAuditReasons = [];

  public formGroup: FormGroup; // our model driven form

  constructor(private operationalOverrideService: OperationalOverrideService, private errorService: AdsErrorService, private sessionHelper: SessionHelper) {
    this.dataSource = Observable.create((observer: any) => {
      // Runs on every search
      observer.next(this.asyncSelected);
    }).mergeMap((token: string) => this.getStatesAsObservable(token));
  }

  ngOnInit() {
    this.corporateUserIdFromJwt = this.sessionHelper.get("corpUserId");
    this.nativeUserIdFromJwt = this.sessionHelper.get("nativeUserId");

    // This should never happen, but if it does, sent them both to 0. 
    // The service in ADS v1.0 is coded to error out if there's not current ID value in the POST.
    if (this.corporateUserIdFromJwt > 0 && this.nativeUserIdFromJwt > 0) {
      this.corporateUserIdFromJwt = 0;
      this.nativeUserIdFromJwt = 0;
    }

    this.formGroup = new FormGroup({
      requestedBy: new FormControl(null, Validators.required),
      reasonCode: new FormControl(null, Validators.required),
      reason: new FormControl(null, Validators.required),
    });

    this.operationalOverrideService.getDropDown("unidentified-audit", null).subscribe(
      data => {
        console.log(data);
        this.unidentifiedAuditReasons = data._embedded.sysFieldValues;
      }
    );
  }

  close() {
    console.log("Calling close");
    this.cancel.emit();
  }

  unidentifiedResponse = {};

  save() {
    console.log("Calling save");

    this.unidentifiedResponse["activityId"] = this.activityInfo["id"];
    this.unidentifiedResponse["activityResourceUrl"] = this.activityInfo["_links"]["self"]["href"];
    this.unidentifiedResponse["currentUserCorporateId"] = this.corporateUserIdFromJwt;
    this.unidentifiedResponse["currentUserNativeId"] = this.nativeUserIdFromJwt;

    this.unidentifiedResponse["reasonCode"] = this.formGroup.value.reasonCode;
    this.unidentifiedResponse["reason"] = this.formGroup.value.reason;
    this.unidentifiedResponse["requestedByName"] = this.requestedByName;
    this.unidentifiedResponse["requestedByUserCorporateId"] = this.requestedByUserCorporateId;
    this.unidentifiedResponse["requestedByUserCorporateResourceUrl"] = this.requestedByUserCorporateResourceUrl;


    this.operationalOverrideService.resetUnidentified(this.unidentifiedResponse).subscribe(
      data => {
        console.log("POST response", data);
        this.saved.emit();
      }, err => {
        console.log(err);
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "unidentifiedOverride", "POST");
      }
    );
  }

  asyncSelected: any;
  typeaheadLoading: boolean;
  typeaheadNoResults: boolean;
  dataSource: Observable<any>;
  requestedByUserCorporateId = 0;
  requestedByUserCorporateResourceUrl = '';
  requestedByName = '';

  getStatesAsObservable(token: string) {
    return this.operationalOverrideService.getRequestedByPerson(token);
  }

  changeTypeaheadLoading(e: boolean): void {
    this.typeaheadLoading = e;
  }

  changeTypeaheadNoResults(e: boolean): void {
    this.typeaheadNoResults = e;
    this.requestedByUserCorporateId = 0;
    this.requestedByUserCorporateResourceUrl = '';
    this.requestedByName = this.formGroup.value.requestedBy;
  }

  typeaheadOnSelect(e: TypeaheadMatch): void {
    console.log('Selected value: ', e);

    this.asyncSelected = e.item["firstName"] + " " + e.item["lastName"];
    this.requestedByName = this.asyncSelected;
    this.requestedByUserCorporateId = e.item["id"];
    this.requestedByUserCorporateResourceUrl = e.item["_links"]["self"]["href"];
    console.log("selected:" + this.requestedByUserCorporateResourceUrl);
  }


}

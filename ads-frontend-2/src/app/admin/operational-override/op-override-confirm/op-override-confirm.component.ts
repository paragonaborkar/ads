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

  bsValue = null;

  unidentifiedAuditReasons = [];

  public formGroup: FormGroup; // our model driven form

  constructor(private operationalOverrideService: OperationalOverrideService) { 
    this.dataSource = Observable.create((observer: any) => {
      // Runs on every search
      observer.next(this.asyncSelected);
    }).mergeMap((token: string) => this.getStatesAsObservable(token));
  }

  ngOnInit() {
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

  save() {
    console.log("Calling save");
    this.saved.emit();
  }

  asyncSelected: any;
  typeaheadLoading: boolean;
  typeaheadNoResults: boolean;
  dataSource: Observable<any>;
  suggestedOwnerUserCorporateId = 0;
  suggestedOwnerUserCorporateResourceUrl = '';

  getStatesAsObservable(token: string) {
    return this.operationalOverrideService.getRequestedByPerson(token);
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

import { Component, ViewChild, OnInit } from '@angular/core';
import { EventEmitter, Input, Output } from '@angular/core';
import { FormsModule, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { ModalDirective } from 'ngx-bootstrap/modal';

import { ActivtyResponse } from "../../activity-response";

import { OwnerResponseService } from './owner-response.service';

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

  errorMessage = '';

  public formGroup: FormGroup; // our model driven form

  activityResponse: ActivtyResponse = new ActivtyResponse();

  constructor(private ownerResponseService:OwnerResponseService, private errorService: AdsErrorService) { }

  ngOnInit() {
    console.log(this.activityInfo);

    this.formGroup = new FormGroup({
      isOwnerFormGroup: new FormGroup({
        confirmOwner: new FormControl(null, Validators.required),
        migrationTeamContactMe: new FormControl(false)
      }),
      ownerFormGroup: new FormGroup({
        decommissionVolume: new FormControl(),
        controllerInstalledDate: new FormControl(),
        // migrationDate: new FormControl(),        // Use for Schedule module in future.
        // migrationStartTime: new FormControl(),   // Use for Schedule module in future.
        // dayOfWeek: new FormControl()             // Use for Schedule module in future.
      }),
      notOwnerFormGroup: new FormGroup({
        newVolumeOwner: new FormControl(),
        dontKnowOwner: new FormControl()
      })



    });
  }

  save() {
    console.log(this.formGroup);

    this.activityResponse.isOwner =  this.formGroup.value.isOwnerFormGroup.confirmOwner;
    this.activityResponse.isPresumed = false; // If the Owner responds with T or F, then we set this to false to indicate it was processed.
    this.activityResponse.callMe =  this.formGroup.value.isOwnerFormGroup.migrationTeamContactMe;
   
    // this.activityResponse.ownerUserCorporateId; // We don't need to set this, since it'a already set.

    this.activityResponse.suggestedOwnerUserCorporateId; // Get from lookup.

      // TODO: Handle an error and display a message in the modal.
      this.ownerResponseService.saveOwnerResponse(this.activityResponse, this.activityInfo.activityResponses[0].id).subscribe(
        response => {
          console.log(response);
         
          // this.saved.emit(this.user);
        },  err => {
          // Get the ADS configured error message to display.
          this.errorMessage = this.errorService.processError(err, "saveOwnerResponse", "PUT");
        });
    


  }

  close() {
    this.cancel.emit();
  }


}

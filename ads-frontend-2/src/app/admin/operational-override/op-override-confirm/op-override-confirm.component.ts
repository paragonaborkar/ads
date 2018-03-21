import { Component, ViewChild, OnInit } from '@angular/core';
import { EventEmitter, Input, Output } from '@angular/core';
import { FormsModule, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { SessionHelper } from '../../../auth/session.helper';
import { AdsErrorService } from '../../../common/ads-error.service';

import { TypeaheadMatch } from 'ngx-bootstrap/typeahead';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';


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

  public formGroup: FormGroup; // our model driven form

  constructor() { }

  ngOnInit() {
    this.formGroup = new FormGroup({
      requestedBy: new FormControl(null, Validators.required),
      reasonCode: new FormControl(null, Validators.required),
      reason: new FormControl(null, Validators.required),
    });
     
  }

  close() {
    console.log("Calling close");
    this.cancel.emit();
  }

  save() {
    console.log("Calling save");
    this.saved.emit();
  }

}

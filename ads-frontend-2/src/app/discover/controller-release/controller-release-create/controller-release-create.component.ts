import { Component, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

import { AdsErrorService } from '../../../common/ads-error.service';
import { ControllerReleaseService } from '../controller-release.service';
import { SaveMessageTimerComponent } from '../../../common/save-message-timer/save-message-timer.component';

@Component({
  selector: 'app-controller-release-create',
  templateUrl: './controller-release-create.component.html',
  styleUrls: ['./controller-release-create.component.scss']
})

export class ControllerReleaseCreateComponent implements OnInit {
  @ViewChild(SaveMessageTimerComponent) saveTimerChild:SaveMessageTimerComponent;

  @Output() savedControllerTarget = new EventEmitter();

  public errorMessage = "";
  
  selectedControllerInvalid = false;
  showSuccessMsg = '';

  newTarget = {};

  @Output() saved = new EventEmitter();

  constructor(private controllerTargetService: ControllerReleaseService, private errorService: AdsErrorService) {  }

  ngOnInit() {  }

  save(formData) {
    console.log(formData);
    this.errorMessage = '';

    this.controllerTargetService.create(this.newTarget).subscribe(
      response => {
        console.log(response);
        this.showSuccessMsg = "Saved...";
        // this.newTarget = {};

        // formData.selectedItem = null;
        // formData.asyncSelected = null;

        this.saveTimerChild.setSuccessTimer();

        this.savedControllerTarget.emit();
      }, err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "createControllerRelease", "POST");
      });
  }


  filterByController(filterObject) {
    console.log("filterObject", filterObject);
    this.errorMessage = '';
    if (filterObject["selectedItem"] === null) {
      this.selectedControllerInvalid = true;
    } else {
      this.selectedControllerInvalid = false;
      this.newTarget[filterObject["controllerName"]] = filterObject["selectedItem"]["_links"]["self"]["href"];

      if (this.newTarget["srcController"] == this.newTarget["tgtController"]) {
        this.errorMessage = "Source and Target Controller cannot be the same.";
      }
    }

  }

}

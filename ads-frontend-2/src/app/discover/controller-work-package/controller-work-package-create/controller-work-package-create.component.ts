import { Component, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

import { AdsErrorService } from '../../../common/ads-error.service';
import { ControllerWorkPackageService } from '../controller-work-package.service';
import { SaveMessageTimerComponent } from '../../../common/save-message-timer/save-message-timer.component';

@Component({
  selector: 'app-controller-work-package-create',
  templateUrl: './controller-work-package-create.component.html',
  styleUrls: ['./controller-work-package-create.component.scss']
})

export class ControllerWorkPackageCreateComponent implements OnInit {
  @ViewChild(SaveMessageTimerComponent) saveTimerChild:SaveMessageTimerComponent;

  public errorMessage = "";
  
  selectedControllerInvalid = false;
  showSuccessMsg = '';

  newTarget = {
    controller: ''
  };

  minDate = new Date(1990, 1, 1);
  todaysDate = new Date();
  maxDate = new Date(this.todaysDate.getFullYear() + 1, this.todaysDate.getMonth(), this.todaysDate.getDate())

  bsValue: Date = new Date();

  @Output() savedControllerTarget = new EventEmitter();
  @Output() cancel = new EventEmitter();

  constructor(private controllerWorkPackageService: ControllerWorkPackageService, private errorService: AdsErrorService) {  }

  ngOnInit() {  }

  save() {
    this.errorMessage = '';

    this.controllerWorkPackageService.create(this.newTarget).subscribe(
      response => {
        console.log(response);
        this.showSuccessMsg = "Saved...";
        this.saveTimerChild.setSuccessTimer(); 
        this.savedControllerTarget.emit();
      }, err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "createControllerTarget", "POST");
      });
  }


  // close() {
  //   console.log("Calling close");
  // }

  filterByController(filterObject) {
    console.log("filterObject", filterObject);
    if (filterObject["selectedItem"] === null) {
      this.selectedControllerInvalid = true;
     
    } else {
      this.selectedControllerInvalid = false;
      console.log(filterObject["selectedItem"]["_links"]["self"]["href"]);
      this.newTarget.controller = filterObject["selectedItem"]["_links"]["self"]["href"];
    }

  }

}

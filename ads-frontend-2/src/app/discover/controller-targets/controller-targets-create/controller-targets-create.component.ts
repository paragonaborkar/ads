import { Component, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AdsErrorService } from '../../../common/ads-error.service';
import { ControllerTargetService } from '../controller-target.service';


@Component({
  selector: 'app-controller-targets-create',
  templateUrl: './controller-targets-create.component.html',
  styleUrls: ['./controller-targets-create.component.scss']
})

export class ControllerTargetsCreateComponent implements OnInit {
  public errorMessage = "";

   newTarget = {};

  minDate = new Date(2010, 1, 1);
  todaysDate = new Date();
  maxDate = new Date(this.todaysDate.getFullYear() + 5, this.todaysDate.getMonth(),  this.todaysDate.getDate())

  bsValue: Date = new Date();

  @Output() saved = new EventEmitter();
  @Output() cancel = new EventEmitter();

  constructor(private controllerTargetService: ControllerTargetService, private errorService: AdsErrorService) { }

  ngOnInit() {
  }

  save() {
    console.log("newControllerTarget save()", this.newTarget);

    this.errorMessage = '';

    this.controllerTargetService.create(this.newTarget).subscribe(
      response => {
        console.log(response);
        // this.saved.emit(this.user);
      },  err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "createControllerTarget", "POST");
      });

  }

  close() {
    console.log("Calling close");   
  }


}

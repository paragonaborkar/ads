import { Component, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AdsErrorService } from '../../../common/ads-error.service';



@Component({
  selector: 'app-controller-targets-create',
  templateUrl: './controller-targets-create.component.html',
  styleUrls: ['./controller-targets-create.component.scss']
})
export class ControllerTargetsCreateComponent implements OnInit {
  public errorMessage = "";

  @Output() saved = new EventEmitter();
  @Output() cancel = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  save(newControllerTarget) {
    console.log("newControllerTarget save()", newControllerTarget);

    // TODO: Handle an error and display a message in the modal.
    // this.usersService.update(this.User, this.userSelfLink).subscribe(
    //   response => {
    //     console.log(response);
    //     console.log("Saved in modal");
    //     this.saved.emit(this.User);
    //   });

  }

  close() {
    console.log("Calling close");   
  }


}

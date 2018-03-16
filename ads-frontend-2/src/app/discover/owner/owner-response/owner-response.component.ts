import { Component, ViewChild, OnInit } from '@angular/core';
import { EventEmitter, Input, Output } from '@angular/core';
import { FormsModule, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';


import { ModalDirective } from 'ngx-bootstrap/modal';

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

  public formGroup: FormGroup; // our model driven form



  activityResponse = [];

  constructor() { }

  ngOnInit() {
    console.log(this.activityInfo);

    this.formGroup = new FormGroup({
      isOwnerFormGroup: new FormGroup({
        confirmOwner: new FormControl(null, Validators.required),
        migrationTeamContactMe: new FormControl(false)
      }),
      ownerFormGroup: new FormGroup({
        decommissionVolume: new FormControl(),
        migrationDate: new FormControl(),
        migrationStartTime: new FormControl(),
        dayOfWeek: new FormControl()
      }),
      notOwnerFormGroup: new FormGroup({
        newVolumeOwner: new FormControl(),
        dontKnowOwner: new FormControl()
      })



    });
  }

  save() {

    this.formGroup
    
    // TODO: Handle an error and display a message in the modal.
    // this.usersService.update(this.User, this.userSelfLink).subscribe(
    //   response => {
    //     console.log(response);
    //     console.log("Saved in modal");
    //     this.saved.emit(this.User);
    //   });

  }

  close() {
    this.cancel.emit();
  }


}

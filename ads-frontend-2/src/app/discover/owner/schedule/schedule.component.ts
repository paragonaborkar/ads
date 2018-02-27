import { Component, ViewChild, OnInit } from '@angular/core';
import { EventEmitter, Input, Output } from '@angular/core';
import { FormsModule, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';


import { ModalDirective } from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.scss']
})
export class ScheduleComponent implements OnInit {
  @ViewChild('scheduleModal') public scheduleModal: ModalDirective;
  @Output() saved = new EventEmitter();
  @Output() cancel = new EventEmitter();
  @Input() activityToSchedule: any;
  @Input() scheduleAction: any;

  public formGroup: FormGroup; // our model driven form



  activityResponse = [];

  constructor() { }

  ngOnInit() {
    console.log(this.activityToSchedule);

    this.formGroup = new FormGroup({
      isOwnerFormGroup: new FormGroup({
        confirmOwner: new FormControl(null, Validators.required),
        migrationTeamContactMe: new FormControl(false, Validators.required)
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

import { Component, ViewChild, Input, Output, EventEmitter } from "@angular/core";
import { FormsModule, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import { ModalDirective } from 'ngx-bootstrap/modal';
import { DatepickerModule } from 'ngx-bootstrap/datepicker'; 

import { OwnersOfAVolumeService } from './owners-of-a-volume.service';

import { SpringRestResponse } from '../../spring-rest-response';


@Component({
  selector: 'schedule-volume-modal',
  templateUrl: './schedule-volume-modal.component.html',
  styleUrls: ['./schedule-volume-modal.component.scss']
})
export class ScheduleVolumeModalComponent {
  @ViewChild('scheduleVolumeModal') public scheduleVolumeModal:ModalDirective;

  @Input() title: string;
  @Input() volume: Object;

  @Output() onSavedSchedule: EventEmitter<boolean> = new EventEmitter<boolean>();
  
  public formGroup: FormGroup; // our model driven form

  subjectName:string;
  ownersOfAVolume: SpringRestResponse;

  public minDate: Date = new Date();
  public maxDate: Date = new Date();
  public dateDisabled: {date: Date, mode: string}[];


  constructor(private _fb: FormBuilder, private ownersOfAVolumeService: OwnersOfAVolumeService) { 
    (this.maxDate = new Date()).setDate(this.minDate.getDate() + 365);
    (this.dateDisabled = []);
  }

  getOwnerVolumes():void {
    this.ownersOfAVolumeService.getOwners('')
          .subscribe(
                     owners => {
                        this.ownersOfAVolume = owners;

                        console.log(" this.ownersOfAVolume");
                        console.log(this.ownersOfAVolume);
                       // console.log(this.migrationProjectService.constructor.name);
                       //error =>  this.errorMessage = <any>error
                     });
  }

  ngOnInit() {
    this.getOwnerVolumes();

     // We will initialize our form models here
     // We may want to refactor the structure of this to align with the REST call and backend processing
    this.formGroup = this._fb.group({
      isOwnerFormGroup: this._fb.group(this.initIsOwnerFormGroup()),
      ownerFormGroup: this._fb.group(this.initOwnerFormGroup()),
      notOwnerFormGroup: this._fb.group(this.initNotOwnerFormGroup())
    });
    

   // Example on how to restict dates
   var twoDaysFromnow: Date = new Date();
   (twoDaysFromnow = new Date()).setDate(this.minDate.getDate() + 2);

   var sameDayNextWeek: Date = new Date();
   (sameDayNextWeek = new Date()).setDate(this.minDate.getDate() + 7);

   this.dateDisabled = [{date: this.minDate, mode: 'day'}, {date: twoDaysFromnow, mode: 'day'}, {date: sameDayNextWeek, mode: 'day'}];
   // End date restiction example
  }
  
  initIsOwnerFormGroup() {
    const model = {
      confirmOwner: [true],
      migrationTeamContact: [false]

    }
    return model;
  }

  initOwnerFormGroup() {
    const model = {
       migrationDate: [],
       decommissionVolume: [false]
    }
    return model;
  }

  initNotOwnerFormGroup() {

    const model = {
      newVolumeOwner: [ "F591154"],
      dontKnowOwner: [false]

    }
    return model;
    
  }


 public getDate(): number {
   console.log( this.formGroup.controls.ownerFormGroup["migrationDate"]);
    return this.formGroup.controls.ownerFormGroup["migrationDate"]  && this.formGroup.controls.ownerFormGroup["migrationDate"].getTime() || new Date().getTime();
  }
 


  show(volumeToSchedule: Object): void {  

    console.log("volumeToSchedule");
    console.log(volumeToSchedule);
    
    this.volume = volumeToSchedule;
    if (this.volume["scheduled"]) {
      this.title = "Re-Schedule Migration";
    } else {
      this.title = "Schedule Migration";
    }

    this.scheduleVolumeModal.show();
  }

  save() {
    let saved = false;
    //TODO: Add code to save the scheduled here. If successful, then return true.
    //TODO: If error, the TBD 

    this.onSavedSchedule.emit(saved);  
  }

  cancel(): void {
  
    this.scheduleVolumeModal.hide();
  }

}
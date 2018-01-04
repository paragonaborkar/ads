import { Component, ViewChild, OnInit } from '@angular/core';

import { VolumeOwersServiceService } from './volume-owers-service.service';
import { ScheduleVolumeModalComponent } from './schedule-volume-modal/schedule-volume-modal.component';

import { SpringRestResponse } from '../spring-rest-response';


@Component({
  selector: 'app-volume-owners',
  templateUrl: './volume-owners.component.html',
  styleUrls: ['./volume-owners.component.scss']
})
export class VolumeOwnersComponent implements OnInit {
   @ViewChild('scheduleVolumeModal') scheduleVolumeModal :ScheduleVolumeModalComponent;

   volumeOwners: SpringRestResponse;
 
   constructor( private volumeOwnerService: VolumeOwersServiceService) { }

 ngOnInit() {
  	  this.getOwnerVolumes();
  }

  getOwnerVolumes():void {
    this.volumeOwnerService.getVolumeOwners('http://localhost:8080/volume-owners-data.json')
          .subscribe(
                     volumeOwners => {
                        this.volumeOwners = volumeOwners;

                        console.log(" this.volumeOwners");
                        console.log(this.volumeOwners);
                       // console.log(this.migrationProjectService.constructor.name);
                       //error =>  this.errorMessage = <any>error
                     });
  }

  showScheduleModal(volumeToSchedule: Object) {
    console.log("showScheduleModal");
    console.log(volumeToSchedule);
    this.scheduleVolumeModal.show(volumeToSchedule);
  }


  // TODO: so we have an simple object that includes:
  //   - saved: boolean
  //   - errorMsg: String - if an error occurred.
  onSavedSchedule(savedResponse: boolean) {
    console.log(savedResponse);
    // Reload the saved data from the server.
    // TODO: Not sure if we should just get the updated Volume or reload all volumes
    // TODO: Retain any paging after reload
    this.getOwnerVolumes();
  }

}

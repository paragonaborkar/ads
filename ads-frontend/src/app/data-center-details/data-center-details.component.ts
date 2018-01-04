import { Component, OnInit } from '@angular/core';

import { VolumeOwersServiceService } from '../volume-owners/volume-owers-service.service';

import { SpringRestResponse } from '../spring-rest-response';


@Component({
  selector: 'app-data-center-details',
  templateUrl: './data-center-details.component.html',
  styleUrls: ['./data-center-details.component.scss']
})
export class DataCenterDetailsComponent implements OnInit {

   alertDisplayed:boolean = false;

   dataCenterDetail: SpringRestResponse;
 
   constructor( private volumeOwnerService: VolumeOwersServiceService) { }

 ngOnInit() {
  	  this.getOwnerVolumes();
  }

  getOwnerVolumes():void {
    this.volumeOwnerService.getVolumeOwners('http://localhost:8080/data-center-details.json')
          .subscribe(
                     migrationProjects => {
                        this.dataCenterDetail = migrationProjects;

                        console.log(" this.dataCenterDetail");
                        console.log(this.dataCenterDetail);
                       // console.log(this.migrationProjectService.constructor.name);
                       //error =>  this.errorMessage = <any>error
                     });
  }

  approve():void {
    this.alertDisplayed = true;
  }

}

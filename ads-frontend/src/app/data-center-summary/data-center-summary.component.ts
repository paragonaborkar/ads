import { Component, OnInit } from '@angular/core';

import { VolumeOwersServiceService } from '../volume-owners/volume-owers-service.service';

import { SpringRestResponse } from '../spring-rest-response';


@Component({
  selector: 'app-data-center-summary',
  templateUrl: './data-center-summary.component.html',
  styleUrls: ['./data-center-summary.component.scss']
})
export class DataCenterSummaryComponent implements OnInit {

   dataCenters: SpringRestResponse;
 
   constructor( private volumeOwnerService: VolumeOwersServiceService) { }

 ngOnInit() {
  	  this.getOwnerVolumes();
  }

  getOwnerVolumes():void {
    this.volumeOwnerService.getVolumeOwners('http://localhost:8080/data-center-summary.json')
          .subscribe(
                     migrationProjects => {
                        this.dataCenters = migrationProjects;

                        console.log(" this.dataCenters");
                        console.log(this.dataCenters);
                       // console.log(this.migrationProjectService.constructor.name);
                       //error =>  this.errorMessage = <any>error
                     });
  }
}

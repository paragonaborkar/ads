import { Component, OnInit } from '@angular/core';

import { VolumeOwersServiceService } from '../volume-owners/volume-owers-service.service';

import { SpringRestResponse } from '../spring-rest-response';

@Component({
  selector: 'app-replication-pattern',
  templateUrl: './replication-pattern.component.html',
  styleUrls: ['./replication-pattern.component.scss']
})
export class ReplicationPatternComponent implements OnInit {


	replicationPatterns: SpringRestResponse;
 
	constructor( private volumeOwnerService: VolumeOwersServiceService) { }

 ngOnInit() {
  	  this.getOwnerVolumes();
  }

  getOwnerVolumes():void {
    this.volumeOwnerService.getVolumeOwners('http://localhost:8080/replication-pattern.json')
          .subscribe(
                     migrationProjects => {
                        this.replicationPatterns = migrationProjects;

                        console.log(" this.replicationPatterns");
                        console.log(this.replicationPatterns);
                       // console.log(this.migrationProjectService.constructor.name);
                       //error =>  this.errorMessage = <any>error
                     });
  }
}

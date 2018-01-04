import { Component, OnInit } from '@angular/core';

import { ProjectsService } from './projects.service';

import { SpringRestResponse } from '../spring-rest-response';


@Component({
  selector: 'app-assign-mig-specialist',
  templateUrl: './assign-mig-specialist.component.html',
  styleUrls: ['./assign-mig-specialist.component.scss']
})
export class AssignMigSpecialistComponent implements OnInit {

   projects: SpringRestResponse;


  constructor(private projectService: ProjectsService) { }

  ngOnInit() {
  	  this.getProjects();
  }


  getProjects():void {
    this.projectService.getProjects('http://localhost:8080/assign-migration-specialist.json')
          .subscribe(
                     projects => {
                        this.projects = projects;

                        console.log(" this.projects");
                        console.log(this.projects);
                     });
  }
}

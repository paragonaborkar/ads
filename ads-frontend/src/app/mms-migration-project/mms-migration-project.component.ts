 import { Component, ViewChild, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ModalModule } from 'ngx-bootstrap/modal';

import { MigrationProjectService } from '../migration-project.service';

import { SpringRestResponse } from '../spring-rest-response';

import { MmsConfirmationModalComponent } from '../confirmation-modal/mms-confirmation-modal.component';

import {MmsConfirmationResponse} from '../confirmation-modal/mms-confirmation-response';


// For some reason 'migration-project' would throw an error. 
// So this Component is pre-fixed with 'mms-'

@Component({
  selector: 'app-mms-migration-project',
  templateUrl: './mms-migration-project.component.html',
  styleUrls: ['./mms-migration-project.component.scss']
})
export class MmsMigrationProjectComponent implements OnInit {
  @ViewChild('confirmationModal') confirmationModal :MmsConfirmationModalComponent;

  projects: SpringRestResponse;

  // errorMessage: "";

  selectedProject: Object;

  constructor(private migrationProjectService: MigrationProjectService) { }


  onSelect(project: Object): void {
      // this.selectedProject = project;  // This align updates the list immedately, but it's not saved to the server yet.
      this.selectedProject = Object.assign({}, project);  // This will clone the project that was clicked on.
  }

  ngOnInit() {
  	  this.getProjects();
  }

  getProjects():void {
    this.migrationProjectService.getMigrationProjects()
          .subscribe(
                     migrationProjects => {
                        this.projects = migrationProjects;

                        console.log(" this.projects");
                        console.log( this.projects);
                       // console.log(this.migrationProjectService.constructor.name);
                       //error =>  this.errorMessage = <any>error
                     });
  }


  add(name: string): void {
      name = name.trim();
      if (!name) { return; }
      this.migrationProjectService.create(name)
        .subscribe(project => {
          this.projects._embedded["migrationProjects"].push(project);
          this.selectedProject = null;
        });
    }


  save(): void {
    this.migrationProjectService.update(this.selectedProject)
      .subscribe(project => {
        console.log(project);
        this.selectedProject = null;
      });
  }


  showDeleteConfirmation(projectToDelete: Object) {
    console.log("showDeleteConfirmation");
    console.log(projectToDelete);
    this.confirmationModal.show(projectToDelete, projectToDelete["migrationProjectName"]);
  }

  onConfirm(confirmResponse: MmsConfirmationResponse)  {
    console.log(confirmResponse);
    if (confirmResponse.confirmed) {
      if (confirmResponse.action == 'delete') {
         this.delete(confirmResponse.subject);
      }
    }
  }


  delete(project: Object): void {
      this.migrationProjectService.delete(project)
          .subscribe(() => {
            this.projects._embedded["migrationProjects"] = this.projects._embedded["migrationProjects"].filter(h => h !== project);
            if (this.selectedProject === project) 
              { this.selectedProject = null; }
          });
    }
 }
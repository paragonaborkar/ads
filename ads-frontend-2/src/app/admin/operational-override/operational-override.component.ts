import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import 'rxjs/add/operator/switchMap';

import { SessionHelper } from '../../auth/session.helper';
import { OperationalOverrideService } from './operational-override.service';
import { ApplicationConfigService } from '../../common/application-config.service';

import { DataTableColTemplatesComponent } from '../../common/data-table-col-templates/data-table-col-templates.component';

import { Page } from "../../common/page";

@Component({
  selector: 'app-operational-override',
  templateUrl: './operational-override.component.html',
  styleUrls: ['./operational-override.component.scss']
})
export class OperationalOverrideComponent implements OnInit {
  public pageName = "OperationalOverrideListing";
  @ViewChild(DataTableColTemplatesComponent) dataTableColsTemplate: DataTableColTemplatesComponent;
  columnTemplates = {};
  @ViewChild('actionTmpl') actionTmpl: TemplateRef<any>;
  
  public isPropPreferenceModal = false;
  public isConfirmModal = false;
  public activityInfo: any = {};
  public scheduleAction = '';

  page = new Page();

  // Listing of actvities/owner information to display 
  rows: any[] = [];
  columns: any = [];

  constructor(private operationalOverrideService: OperationalOverrideService, private sessionHelper: SessionHelper, private applicationConfigService: ApplicationConfigService) {
    this.page.number = 1;
    this.page.pageNumber = 1;
    this.page.size = 1000;
   }

  ngOnInit() {
  }

  ngAfterViewInit() {
    this.columnTemplates = this.dataTableColsTemplate.getTemplates();
    this.columnTemplates["actionTmpl"] = this.actionTmpl;

    this.setPage({ pageNumber: 0 });
    this.applyPreferences();
  }


  /**
 * Populate the table with new data based on the page number
 * @param page The page to select
 */
  setPage(pageInfo) {
   
    this.page.number = pageInfo.pageNumber;
    this.page.pageNumber = pageInfo.pageNumber;

    // This method is to get all the values from user_native table
    this.operationalOverrideService.getActivities(pageInfo).subscribe(
      data => {
        console.log(data);
        this.page = data.page;
        this.page.pageNumber = this.page.number;
        // Don't set rows to undefined, it'll break the listing!    
        if (data._embedded.activities) {
          this.rows = data._embedded.activities;

          // this.rows.forEach(activity => {
          //   activity["activityResponses"].forEach(activtyResponse => {
          //     if (activtyResponse["ownerUserCorporateId"] != this.currentUserCorporateId) {
          //       // Keep other owners in a multi owner scenerio and display on the Owner modal.
          //       // console.log("DEBUG AND TEST: Deleting:", this.rows["activityResponses"].activtyResponse);              
          //     }
          //   }); 
          // });
        }
        // this.rows = this.adsHelper.ungroupJson(usersNativeResponse._embedded.userNatives, "userRole", ["createTime", "updateTime"]);
        console.log("******************");
        console.log(this.rows);
        console.log(this.page);
        console.log("****");
        if (this.page.number > 0 && this.rows.length == 0) {
          pageInfo.pageNumber = pageInfo.pageNumber - 1;
          this.setPage(pageInfo);
        }
      });
  }

  applyPreferences(): void {
    this.applicationConfigService.getPreferencesForColumns(this.pageName, this.columns, this.columnTemplates, true)
      .subscribe(columnPreferences => {
        this.columns = columnPreferences;
      }
      );

  }

  pagingUpdated() {
    this.setPage(this.page);
  }

  showConfirmModal(row) {
   
    this.activityInfo = row;
    this.isConfirmModal = true;

  }
  
  hideConfirmModal() {
    this.isConfirmModal = false;
    this.setPage(this.page);
  }



  showPropertyModal() {
    this.isPropPreferenceModal = true;
  }


  hidePropertyModal() {
    this.isPropPreferenceModal = false;
    this.rows = [];
    this.columns = [];
  
    this.setPage(this.page);
    this.applyPreferences();
  }

}

import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import 'rxjs/add/operator/switchMap';

import { SessionHelper } from '../../auth/session.helper';
import { OwnerService } from '../owner.service';
import { ApplicationConfigService } from '../../common/application-config.service';

import { Page } from "../../common/page";

import { DataTableColTemplatesComponent } from '../../common/data-table-col-templates/data-table-col-templates.component'


@Component({
  selector: 'app-owner',
  templateUrl: './owner.component.html',
  styleUrls: ['./owner.component.scss']
})
export class OwnerComponent implements OnInit {
  @ViewChild(DataTableColTemplatesComponent) dataTableColsTemplate: DataTableColTemplatesComponent;
  columnTemplates = {};
  @ViewChild('actionTmpl') actionTmpl: TemplateRef<any>;

  public isScheduleModal = false;
  public activityInfo: any = {};
  public scheduleAction = '';

  public currentUserCorporateId = 9;


  page = new Page();

  // owerListing: any = [];
  public pageName = "OwnerListing";


  // Listing of actvities/owner information to display 
  rows: any[] = [];
  columns: any = [];


  constructor(private route: ActivatedRoute, private ownerService: OwnerService, private sessionHelper: SessionHelper, private applicationConfigService: ApplicationConfigService) {
    this.page.number = 1;
    this.page.pageNumber = 1;
    this.page.size = 1000;
  }

  ngOnInit() {

    var loginInfo = this.sessionHelper.getToken();

    // this.route.params
    //   .switchMap((params: ParamMap) => this.ownerService.validateMigKeyExists(params['migKey'], loginInfo.corpUserId))
    //   .subscribe((data) => this.owerListing = data);

  }


  ngAfterViewInit() {
    this.columnTemplates = this.dataTableColsTemplate.getTemplates();
    this.columnTemplates["actionTmpl"] = this.actionTmpl;

    this.setPage({ offset: 0 });
    this.applyPreferences();
  }


  /**
 * Populate the table with new data based on the page number
 * @param page The page to select
 */
  setPage(pageInfo) {
    console.log("Loading page...");
    this.page.number = pageInfo.offset;
    this.page.pageNumber = pageInfo.offset;

    // This method is to get all the values from user_native table
    this.ownerService.getAllActivitiesForUser("ABC", this.currentUserCorporateId, pageInfo).subscribe(
      data => {
        console.log(data);
        this.page = data.page;
        this.page.pageNumber = this.page.number;
        // Don't set rows to undefined, it'll break the listing!    
        if (data.page.totalElements > 0) {
          this.rows = data._embedded.activities;
          this.rows.forEach(activity => {

            activity["activityResponses"].forEach(activtyResponse => {
              if (activtyResponse["ownerUserCorporateId"] != this.currentUserCorporateId) {
                // DEBUG AND TEST:
                console.log("DEBUG AND TEST: Deleting:", this.rows["activityResponses"][activtyResponse]);
                // We are getting all responses, delete what doesn't apply to this user so we don't update it by accident.
                delete this.rows["activityResponses"][activtyResponse];
              }
            });

          });
        }
        // this.rows = this.adsHelper.ungroupJson(usersNativeResponse._embedded.userNatives, "userRole", ["createTime", "updateTime"]);
        console.log("******************");
        console.log(this.rows);
        console.log(this.page);
        console.log("****");
        if (this.page.number > 0 && this.rows.length == 0) {
          pageInfo.offset = pageInfo.offset - 1;
          this.setPage(pageInfo);
        }
      });
  }

  applyPreferences(): void {
    this.applicationConfigService.getPreferencesForColumns(this.pageName, this.columns, this.columnTemplates)
      .subscribe(columnPreferences => {
        this.columns = columnPreferences;
      }
      );

  }

  pagingUpdated() {
    this.setPage(this.page);
  }


  showScheduleModal(row, action) {
    this.activityInfo = row;
    this.scheduleAction = action;
    this.isScheduleModal = true;
  }

  hideScheduleModal() {
    this.isScheduleModal = false;
  }
}
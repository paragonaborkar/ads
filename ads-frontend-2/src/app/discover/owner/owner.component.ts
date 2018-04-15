import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import 'rxjs/add/operator/switchMap';

import { SessionHelper } from '../../auth/session.helper';
import { OwnerService } from '../owner.service';
import { ApplicationConfigService } from '../../common/application-config.service';

import { DataTableColTemplatesComponent } from '../../common/data-table-col-templates/data-table-col-templates.component';

import { Page } from "../../common/page";


@Component({
  selector: 'app-owner',
  templateUrl: './owner.component.html',
  styleUrls: ['./owner.component.scss']
})
export class OwnerComponent implements OnInit {
  public pageName = "OwnerListing";
  @ViewChild(DataTableColTemplatesComponent) dataTableColsTemplate: DataTableColTemplatesComponent;
  columnTemplates = {};
  @ViewChild('actionTmpl') actionTmpl: TemplateRef<any>;

  public isPropPreferenceModal = false;
  public isScheduleModal = false;
  public activityInfo: any = {};
  public scheduleAction = '';
  activtyResponseForCurrentUser = [];

  public currentUserCorporateId = 0;

  page = new Page();

  migkey = '';

  // Listing of actvities/owner information to display 
  rows: any[] = [];
  columns: any = [];

  constructor(private router: Router, private route: ActivatedRoute, private ownerService: OwnerService, private sessionHelper: SessionHelper, private applicationConfigService: ApplicationConfigService) {
    this.page.number = 1;
    this.page.pageNumber = 1;
    this.page.size = 1000;
  }

  ngOnInit() {

    this.currentUserCorporateId = this.sessionHelper.get("corpUserId");

    this.route.params.subscribe(params => {
      this.migkey = params['migKey'];
    });

    // FIXME: Complete this when SSO is ready.....
    this.route.params
      .switchMap((params: ParamMap) => this.ownerService.validateMigKeyExists(params['migKey'], this.currentUserCorporateId))
      .subscribe((validateMigKeyExists) => {
        console.log("validateMigKeyExists:", validateMigKeyExists);
        if (!validateMigKeyExists) {
          this.router.navigate(['/owner']);
        }
      }, err => {
        this.router.navigate(['/owner']);
      });
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
    this.ownerService.getAllActivitiesForUser(this.migkey, this.currentUserCorporateId, pageInfo).subscribe(
      data => {
        console.log(data);
        // Don't set rows to undefined, it'll break the listing!    
        if (data._embedded.activities) {

          data._embedded.activities.forEach(activity => {

            let appCount = 0;
            let appNames = [];

            let hostCount = 0;
            let hostNames = [];

            // Count of unique app amd unique hosts
            activity["qtree"]["shares"].forEach(share => {
              if (!hostNames.includes(share["host"]["hostName"])) {
                hostNames.push(share["host"]["hostName"]);
                hostCount = hostCount + 1;

                share["host"]["applications"].forEach(app => {
                  if (!appNames.includes(app["applicationName"])) {
                    appNames.push(app["applicationName"]);
                    appCount = appCount + share["host"]["applications"].length;
                  }
                });
              }

            });

            activity["qtree"]["appCount"] = appCount;
            activity["qtree"]["appNames"] = appNames;

            activity["qtree"]["hostCount"] = hostCount;
            activity["qtree"]["hostNames"] = hostNames;

            activity["activityResponses"].forEach(activtyResponse => {

              if (activtyResponse["ownerUserCorporateId"] == this.currentUserCorporateId) {
                this.activtyResponseForCurrentUser = activtyResponse;
              }
              if (activtyResponse["ownerUserCorporateId"] != this.currentUserCorporateId) {
                // Keep other owners in a multi owner scenerio and display on the Owner modal.
                // console.log("DEBUG AND TEST: Deleting:", this.rows["activityResponses"].activtyResponse);              

                //FIXME: Do we need to merge up additional information like hosts and applications? 
                // Ideally we get all data in 1 request, but if we cannot, then request and merge here.
              }
            });

          });

          this.rows = data._embedded.activities;
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


  showScheduleModal(row, action) {

    this.activityInfo = row;
    this.scheduleAction = action;

    this.isScheduleModal = true;
    console.log("show called");
  }

  hideScheduleModal() {
    this.isScheduleModal = false;
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
import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { Page } from "../../common/page";
import { ApplicationConfigService } from '../../common/application-config.service';
import { ControllerReleaseService } from './controller-release.service';
import { AdsErrorService } from '../../common/ads-error.service';




@Component({
  selector: 'app-controller-release',
  templateUrl: './controller-release.component.html',
  styleUrls: ['./controller-release.component.scss']
})
export class ControllerReleaseComponent implements OnInit {
  public pageName = "ControllerReleaseListing";
  errorMessage = "";

  @ViewChild('hdrTmpl') hdrTmpl: TemplateRef<any>;
  @ViewChild('actionTmpl') actionTmpl: TemplateRef<any>;

  // Listing of Controller Release information to display 
  rows: any[] = [];
  columns: any = [];
  page = new Page();

  controllerProcessed = false;

  constructor(private contrllerReleaseService: ControllerReleaseService, private applicationConfigService: ApplicationConfigService,  private errorService: AdsErrorService) {
    this.page.number = 1;
    this.page.pageNumber = 1;
    this.page.size = 3;



  }

  ngOnInit() {
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
    this.contrllerReleaseService.getControllerReleasesByProcessed(this.page, this.controllerProcessed).subscribe(
      data => {
        console.log(data);
        this.page = data.page;
        this.page.pageNumber = this.page.number;
        this.rows = data._embedded.controllerReleases;
        // this.rows = this.adsHelper.ungroupJson(usersNativeResponse._embedded.userNatives, "userRole", ["createTime", "updateTime"]);
        console.log("******************");
        console.log(this.rows);
        console.log(this.page);
        console.log("****");
        if (this.page.number > 0 && this.rows.length == 0) {
          pageInfo.offset = pageInfo.offset - 1;
          this.setPage(pageInfo);
        }
      }, err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "getControllerReleaseList", "GET");
      });
  }

  applyPreferences(): void {
    // console.log("applyPreferences Start");

    this.applicationConfigService.getPreferencesForColumns(this.pageName, this.columns, this.hdrTmpl, this.actionTmpl)
      .subscribe(columnPreferences => {
        this.columns = columnPreferences;
      });
  }

  pagingUpdated() {
    this.setPage(this.page);
  }








}

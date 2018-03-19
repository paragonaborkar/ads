import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { Page } from "../../common/page";
import { ApplicationConfigService } from '../../common/application-config.service';
import { ControllerReleaseService } from './controller-release.service';
import { AdsErrorService } from '../../common/ads-error.service';

import { DataTableColTemplatesComponent} from '../../common/data-table-col-templates/data-table-col-templates.component'

@Component({
  selector: 'app-controller-release',
  templateUrl: './controller-release.component.html',
  styleUrls: ['./controller-release.component.scss']
})
export class ControllerReleaseComponent implements OnInit {
  @ViewChild(DataTableColTemplatesComponent) dataTableColsTemplate :DataTableColTemplatesComponent;
  columnTemplates = {};
  @ViewChild('actionTmpl') actionTmpl: TemplateRef<any>;

  public pageName = "ControllerReleaseListing";
  errorMessage = "";

  // Listing of Controller Release information to display 
  rows: any[] = [];
  columns: any[] = [];
  page = new Page();

  controllerProcessed = false;
  controllerRelease = {};

  public isDeleteModal = false;
  public isPropPreferenceModal = false;

  constructor(private contrllerReleaseService: ControllerReleaseService, private applicationConfigService: ApplicationConfigService,  private errorService: AdsErrorService) {
    this.page.number = 1;
    this.page.pageNumber = 1;
    this.page.size = 3;
  }

  ngOnInit() {
 
  }

  ngAfterViewInit() {
    this.columnTemplates = this.dataTableColsTemplate.getTemplates();
    this.columnTemplates["actionTmpl"] =this.actionTmpl;

    this.setPage({ offset: 0 }, '');
    this.applyPreferences();
  }



  setPage(pageInfo, filter) {
    console.log("Loading page...");
    this.page.number = pageInfo.offset;
    this.page.pageNumber = pageInfo.offset;

    
    // This method is to get all the values from user_native table
    this.contrllerReleaseService.getControllerReleasesByProcessed(this.page, this.controllerProcessed).subscribe(
      data => {
        this.setupPaging(data, pageInfo, filter);
      }, err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "getControllerReleaseList", "GET");
      });
 
  }

  setupPaging(data, pageInfo, filter) {
    console.log(data);
    this.page = data.page;
    this.page.pageNumber = this.page.number;
    
    // Don't set rows to undefined, it'll break the listing!    
    if (data.page.totalElements > 0) {
      this.rows = data._embedded.controllerReleases;
    }
    // this.rows = this.adsHelper.ungroupJson(usersNativeResponse._embedded.userNatives, "userRole", ["createTime", "updateTime"]);
    console.log("******************");
    console.log(this.rows);
    console.log(this.page);
    console.log("****");
    if (this.page.number > 0 && this.rows.length == 0) {
      pageInfo.offset = pageInfo.offset - 1;
      this.setPage(pageInfo, filter);
    }
  }

  applyPreferences(): void {
    // console.log("applyPreferences Start");

    this.applicationConfigService.getPreferencesForColumns(this.pageName, this.columns, this.columnTemplates)
      .subscribe(columnPreferences => {
        this.columns = columnPreferences;
      });
  }

  pagingUpdated() {
    // Need to get the filter value!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    this.setPage(this.page, '');
  }

  showDeleteModal(row) {
    // console.log(row._links.self.href);
    this.controllerRelease = row;
    this.isDeleteModal = true;
  }

  // This method is to hide the modals  
  onHide(modalToHide): void {
    if (modalToHide === 'delete') {
      this.isDeleteModal = false;
      this.setPage({ offset: this.page.pageNumber }, '');
    } else if (modalToHide === 'propPreferenceModal') {
      this.isPropPreferenceModal = false;
      this.columns = [];    // This makes the columns display refresh after the user updates it.
      this.applyPreferences();
    }
  }
}

import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
// import { Subscription } from 'rxjs/Subscription';
import { Subject } from 'rxjs/Subject';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/timer';

import { Page } from "../../common/page";

import { AppPropsService } from './app-props.service'
import { ApplicationConfigService } from '../../common/application-config.service';
import { AdsErrorService } from '../../common/ads-error.service';
import { SaveMessageTimerComponent } from '../../common/save-message-timer/save-message-timer.component';

import { DataTableColTemplatesComponent } from '../../common/data-table-col-templates/data-table-col-templates.component'


@Component({
  selector: 'app-app-props',
  templateUrl: './app-props.component.html',
  styleUrls: ['./app-props.component.scss']
})
export class AppPropsComponent implements OnInit {
  @ViewChild(DataTableColTemplatesComponent) dataTableColsTemplate :DataTableColTemplatesComponent;
  columnTemplates = {};
  @ViewChild('stringEditTmpl') stringEditTmpl: TemplateRef<any>;
  @ViewChild(SaveMessageTimerComponent) saveTimerChild: SaveMessageTimerComponent;

  public pageName = "SysPropListing";
  configGroups: any[] = [];
  page = new Page();

  showSuccessMsg = '';


  // Listing of native users to display 
  rows: any[] = [];
  columns: any = [];
  editing = {};
  grouping = '';

  // public showSuccess: boolean = false; 
  public errorMessage: string = '';

  // private subscription: Subscription;
  // private timer: Observable<any>;

  constructor(private appPropService: AppPropsService, private applicationConfigService: ApplicationConfigService, private errorService: AdsErrorService) {
    this.page.number = 1;
    this.page.pageNumber = 1;
    this.page.size = 3;

  }

  ngOnInit() {   
  }


  ngAfterViewInit() {
    this.columnTemplates = this.dataTableColsTemplate.getTemplates();
    this.columnTemplates["stringEditTmpl"] =this.stringEditTmpl;

    this.appPropService.getSysConfigGroups().subscribe(
      sysConfigGroups => {
        this.configGroups = sysConfigGroups;
        console.log(sysConfigGroups);
        this.grouping = sysConfigGroups[0];

        this.setPage({ offset: 0 });
        this.applyPreferences();
      });
  }


  // public ngOnDestroy() {
  //   if ( this.subscription && this.subscription instanceof Subscription) {
  //     this.subscription.unsubscribe();
  //   }
  // }

  /**
 * Populate the table with new data based on the page number
 * @param page The page to select
 */
  setPage(pageInfo) {
    // console.log("Loading page...");
    this.page.number = pageInfo.offset;
    this.page.pageNumber = pageInfo.offset;

    // This method is to get all the values from user_native table
    this.appPropService.getSysConfigData(this.page, this.grouping).subscribe(
      // this.appPropService.getSysConfigsByPage(this.page).subscribe(
      configs => {
        console.log(configs);
        this.page = configs.page;
        this.page.pageNumber = this.page.number;
        // Don't set rows to undefined, it'll break the listing!    
        if (configs.page.totalElements > 0) {
          this.rows = configs._embedded.sysConfigs;
        }
        // console.log("******************");
        // console.log(this.rows);
        // console.log(this.page);
        // console.log("****");
        if (this.page.number > 0 && this.rows.length == 0) {
          pageInfo.offset = pageInfo.offset - 1;
          this.setPage(pageInfo);
        }
      });
  }

  pagingUpdated() {
    this.setPage(this.page);
  }

  updateTableRows(grouping) {
    this.grouping = grouping;
    this.setPage(this.page);
  }

  updateTableValue(event, cell, rowIndex, row) {
    this.editing[rowIndex + cell] = false;
    this.rows[rowIndex][cell] = event.target.value;

    // TODO: Handle an error and display a message
    this.appPropService.updateSysConfig(row, row._links.self.href).subscribe(
      response => {
        console.log(response);
        console.log("Saved row");

        this.showSuccessMsg = "Saved...";
        this.saveTimerChild.setSuccessTimer();
      }, err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "updateApplicationProperty", "PATCH");
      });
  }


  applyPreferences(): void {
    this.applicationConfigService.getPreferencesForColumns(this.pageName, this.columns, this.columnTemplates, false)
      .subscribe(columnPreferences => {
        this.columns = columnPreferences;

      });
  }
}

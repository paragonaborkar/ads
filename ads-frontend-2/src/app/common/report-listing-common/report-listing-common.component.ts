import { Component, OnInit, Input } from '@angular/core';

import { ReportCommonService } from './report-common.service';
import { AdsErrorService } from '../../common/ads-error.service';


@Component({
  selector: 'app-report-listing-common',
  templateUrl: './report-listing-common.component.html',
  styleUrls: ['./report-listing-common.component.scss']
})
export class ReportListingCommonComponent implements OnInit {
  errorMessage = '';
  reportListing = [];

  @Input() moduleName: string;
  @Input() moduleDisplayName: string;


  customReport = '';
  totalPages = 0;
  showJasperReport;
  pageCount;
  report;
  myVar: boolean;
  reportName: any;

  constructor(private reportCommonService: ReportCommonService, private errorService: AdsErrorService) { }

  ngOnInit() {

    console.log(this.moduleName);

    this.pageCount = 1;

    this.myVar = true;


    // This method is to get all the values from user_native table
    this.reportCommonService.getReportsForModule('discover').subscribe(
      data => {
        console.log(data);

        let colsPerRow = 3;
        let rowCounter = 0;
        let results = {};

        data._embedded.adsReports.forEach((item, index) => {
          let row = index % colsPerRow;
          if (row == 0) {
            rowCounter = rowCounter + 1
            this.reportListing[rowCounter] = [];
          }
          this.reportListing[rowCounter].push(item);
        });
      }, err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "getControllerReleaseList", "GET");
      });
  }

  numbers = [];

  openJasperReport(requestedPageNumber, reportName): void {
    console.log(reportName);

    this.myVar = false;
    this.reportName = reportName;
    this.showJasperReport = true;
    if (!requestedPageNumber)
      requestedPageNumber = 1;
    this.pageCount = requestedPageNumber;

    this.reportCommonService.openJasperReport(requestedPageNumber, reportName)
      .subscribe(
        res => {
          console.log(reportName + " back", this.report);
          this.report = res;
          this.customReport = this.report.report;

          console.log(this.customReport);
          this.totalPages = this.report.totalPages;

          this.numbers = [];
          // An array of number for the paging.
          for (var i = 1; i <= this.totalPages; i++) {
            this.numbers.push(i);
          }

          var ele: any = document.getElementById("customReport");
          ele.innerHTML = this.customReport;

          var x = document.getElementsByClassName("jrPage");
          console.log(x);
          ele = document.getElementById("customReport");
          ele.innerHTML = "<table class=\"table table-striped\">" + x.item(0).innerHTML + "</table>";


        });
  }


  goToPrevious(): void {
    this.pageCount = --this.pageCount;
    this.openJasperReport(this.pageCount, this.reportName);
  }

  goToNext(): void {
    this.pageCount = ++this.pageCount;
    this.openJasperReport(this.pageCount, this.reportName);
  }
  goToPage(pageNum): void {
    this.openJasperReport(pageNum, this.reportName);
  }

  downloadJasperReport(reportName, reportTitle, query, module) {
    reportName = this.reportName;
    this.reportCommonService.downloadJasperReport(reportName);
  }
}

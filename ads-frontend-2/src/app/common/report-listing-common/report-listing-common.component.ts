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

  numbers = [];

  reportHtml = '';

  customReport = '';
  totalPages = 0;
  showJasperReport;
  pageCount;
  report;
  myVar: boolean;
  reportName = '';
  reportTitle = '';

  constructor(private reportCommonService: ReportCommonService, private errorService: AdsErrorService) { }

  ngOnInit() {

    console.log(this.moduleName);

    this.pageCount = 1;

    this.myVar = true;


    // This method is to get all the values from user_native table
    this.reportCommonService.getReportsForModule(this.moduleName).subscribe(
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


  openJasperReport(requestedPageNumber, reportName, reportTitle): void {
    console.log(reportName);

    this.myVar = false;
    this.reportName = reportName;
    this.reportTitle = reportTitle;
    this.showJasperReport = true;
    if (!requestedPageNumber)
      requestedPageNumber = 1;
    this.pageCount = requestedPageNumber;

    this.reportCommonService.openJasperReport(requestedPageNumber, reportName, this.moduleName)
      .subscribe(
        res => {

          console.log("res:", res);

          this.report = res;
          this.customReport = res.report;

          this.totalPages = res.totalPages;
          this.numbers = [];
          // An array of number for the paging.
          for (var i = 1; i <= this.totalPages; i++) {
            this.numbers.push(i);
          }


          let jasperFormatting = true;
          if (!jasperFormatting) {
            var div = document.createElement('div');
            div.innerHTML = this.report.report;
            var x = div.getElementsByClassName("jrPage");

            console.log(" x.item(0).childNodes.item(1)", x.item(0).childNodes.item(1));

            let len = x.item(0).childNodes.item(1).childNodes.length;
            for (let i = 0; i <= len; i++) {
              let e = x.item(0).childNodes.item(1).childNodes[i];
              if (i <= 2) {
                x.item(0).childNodes.item(1).removeChild(e);
              }
            }

            // Remove junk at the end of the report.
            x.item(0).childNodes.item(1).removeChild(x.item(0).childNodes.item(1).lastChild);
            x.item(0).childNodes.item(1).removeChild(x.item(0).childNodes.item(1).lastChild);
            x.item(0).childNodes.item(1).removeChild(x.item(0).childNodes.item(1).lastChild);
            x.item(0).childNodes.item(1).removeChild(x.item(0).childNodes.item(1).lastChild);
            x.item(0).childNodes.item(1).removeChild(x.item(0).childNodes.item(1).lastChild);
            x.item(0).childNodes.item(1).removeChild(x.item(0).childNodes.item(1).lastChild);


            var all = x.item(0).getElementsByTagName('*');

            for (var i = -1, l = all.length; ++i < l;) {
              all[i].removeAttribute('style');
            }

            this.reportHtml = "<table class=\"table table-striped mt-3\">" + x.item(0).innerHTML + "</table>";
          } else {
            var ele = document.getElementById("reportHtml");

            ele.innerHTML = this.report.report;
          }

          // ele.innerHTML = "<table class=\"table table-striped mt-3\">" + x.item(0).innerHTML + "</table>";
        });
  }


  goToPrevious(): void {
    this.pageCount = --this.pageCount;
    this.openJasperReport(this.pageCount, this.reportName, this.moduleName);
  }

  goToNext(): void {
    this.pageCount = ++this.pageCount;
    this.openJasperReport(this.pageCount, this.reportName, this.moduleName);
  }
  goToPage(pageNum): void {
    this.openJasperReport(pageNum, this.reportName, this.moduleName);
  }

  downloadJasperReport(reportName, reportTitle, query, module) {
    reportName = this.reportName;
    this.reportCommonService.downloadJasperReport(reportName);
  }
}

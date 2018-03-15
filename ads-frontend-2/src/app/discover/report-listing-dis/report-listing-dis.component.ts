import { Component, OnInit } from '@angular/core';
import { OwnerService } from '../owner.service';
import { Globals } from '../../globals';


import { ReportCommonService } from '../../common/report-listing-common/report-common.service';

@Component({
  selector: 'app-report-listing-dis',
  templateUrl: './report-listing-dis.component.html',
  styleUrls: ['./report-listing-dis.component.scss']
})
export class ReportListingDisComponent implements OnInit {
  customReport: any;
  totalPages = 0;
  totalPagesArr = [];
  showJasperReport;
  pageCount;
  report;
  myVar: boolean;
  reportName: any;
  callMeReport:any;
  volumeDecommission:any;
  unknownOwner:any;

  constructor(private reportService: ReportCommonService, private globals: Globals) {
  }
  ngOnInit() {
    this.myVar = true;
    this.pageCount = 1;
    this.callMeReport=this.globals.callMeReportName;
    this.volumeDecommission=this.globals.volumeDecommissionReportName;
    this.unknownOwner=this.globals.unknownOwnerReportName;
  }

  back() {
    this.myVar = true;
    this.pageCount = 1;
    document.getElementById("customReport").innerHTML = "";
  }

  openJasperReport(requestedPageNumber, reportName): void {
    this.myVar = false;
    this.reportName = reportName;
    this.showJasperReport = true;
    if (!requestedPageNumber)
      requestedPageNumber = 1;
    this.pageCount = requestedPageNumber;
    this.reportService.openJasperReport(requestedPageNumber, reportName, 'discover')
      .subscribe(
      res => {
        this.report = res;
        this.customReport = this.report.report;
        this.totalPages = this.report.totalPages;
        var ele: any = document.getElementById("customReport");
        ele.innerHTML = this.customReport;
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
    this.reportService.downloadJasperReport(reportName, "discover");
  }
}

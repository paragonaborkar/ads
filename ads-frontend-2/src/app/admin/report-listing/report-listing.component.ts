import { Component, OnInit } from '@angular/core';
import { Response, Headers, RequestOptions, RequestMethod, RequestOptionsArgs, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs';
import { ReportService } from './report.service';
import { HttpClient } from '@angular/common/http';
import { SessionHelper } from '../../auth/session.helper';
import { Globals } from '../../globals';

@Component({
    selector: 'app-report-listing',
    templateUrl: './report-listing.component.html',
    styleUrls: ['./report-listing.component.scss']
})
export class ReportListingComponent implements OnInit {

    errorMessage: String;
    report;
    customReport: any;
    totalPages = 0;
    totalPagesArr = [];
    showJasperReport;
    pageCount;
    output;
    reportName = this.globals.userNativeReportName;

    constructor(private reportService: ReportService, private _sessionHelper: SessionHelper, private globals: Globals) { }


    ngOnInit(): void {
        this.pageCount = 1;
    }

    openJasperReport(requestedPageNumber,reportName): void {
        this.showJasperReport = true;
        if (!requestedPageNumber)
            requestedPageNumber = 1;
        this.pageCount = requestedPageNumber;
        reportName = this.globals.userNativeReportName;
          
        this.reportService.openJasperReport(requestedPageNumber,reportName)
            .subscribe(
            res => {
                this.report = res;
                console.log(this.report );
                this.customReport = this.report.report;
                this.totalPages = this.report.totalPages;

                var ele: any = document.getElementById('reportsCustom');
                ele.innerHTML = this.customReport;
            });
    }

    goToPrevious(): void {
        this.pageCount = --this.pageCount;
        this.openJasperReport(this.pageCount,this.reportName);
    }

    goToNext(): void {
        this.pageCount = ++this.pageCount;
        this.openJasperReport(this.pageCount,this.reportName);
    }

    downloadJasperReport(reportName) {
        reportName = this.globals.userNativeReportName;
        this.reportService.downloadJasperReport(reportName);
    }

    
}

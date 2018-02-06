import { Component, OnInit } from '@angular/core';
import { Response, Headers, RequestOptions, RequestMethod, RequestOptionsArgs, URLSearchParams} from '@angular/http';
import { Observable } from 'rxjs';
import { ReportService } from './report.service';
import { HttpClient } from '@angular/common/http';
import { SessionHelper } from '../../auth/session.helper';

@Component({
   selector: 'app-report-listing',                        
   templateUrl: './report-listing.component.html',
   styleUrls: ['./report-listing.component.scss']
})
export class ReportListingComponent implements OnInit {

    errorMessage: String;
    report;
    customReport:any;
    totalPages;
    totalPagesArr=[];
    showJasperReport;
    pageCount;
    output;

    constructor(private reportService:ReportService, private _sessionHelper:SessionHelper) { }

   
    ngOnInit():void {
        this.pageCount = 1;
    }

    openJasperReport(e):void {
        this.showJasperReport = true;
        if(!e) 
            e = 1;
        this.pageCount=e;
        //this.report = this.reportService.openJasperReport(e);

        this.reportService.openJasperReport(e)
        .subscribe(
                   res => {
                      this.report = res;

                      console.log(" this");
                      console.log( this);
                   });

        // this.report.then((data)=>{
        //     var data1 = (<any>data)._body;
        //     this.customReport = JSON.parse(data1).report;
        //     this.totalPages = JSON.parse(data1).totalPages;
        //     var ele:any = document.getElementById('reportsCustom');
            
        //     ele.innerHTML = this.customReport;
        // });
    }

    goToPrevious():void{
        this.pageCount  = --this.pageCount;
        this.openJasperReport(this.pageCount );
    }

    goToNext():void{ 
        this.pageCount = ++this.pageCount;
        this.openJasperReport(this.pageCount );
    }

    downloadJasperReport(){
        this.reportService.downloadJasperReport();
    }

    
 }

import { Component, OnInit } from '@angular/core';


import { SpringRestResponse } from '../spring-rest-response';

@Component({
  selector: 'app-report-listing',
  templateUrl: './report-listing.component.html',
  styleUrls: ['./report-listing.component.scss']
})
export class ReportListingComponent implements OnInit {
  
  errorMessage: "";

  constructor() { }

  ngOnInit() {}
 
}

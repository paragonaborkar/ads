import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { HttpClient } from '@angular/common/http';

import 'rxjs/add/operator/switchMap';

import { OwnerService } from '../owner.service';

@Component({
  selector: 'app-owner',
  templateUrl: './owner.component.html',
  styleUrls: ['./owner.component.scss']
})
export class OwnerComponent implements OnInit {

  constructor(private route: ActivatedRoute, private router: Router, private service: OwnerService) { }

  owerListing: any = [];

  ngOnInit() {

    console.log("in OwnerComponent ngOnInit()");

    this.owerListing = this.route.paramMap
      .switchMap((params: ParamMap) =>
        this.service.getQTreesForOwner(params.get('id')));
  }

}

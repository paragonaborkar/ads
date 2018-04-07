import { Component, OnInit, Input } from '@angular/core';


import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';


import { SessionHelper } from '../../auth/session.helper';
import { OwnerHomeService } from './owner-home.service';


@Component({
  selector: 'app-owner-home',
  templateUrl: './owner-home.component.html',
  styleUrls: ['./owner-home.component.scss']
})
export class OwnerHomeComponent implements OnInit {
  queueToProcess=[];

  constructor(private ownerHomeService: OwnerHomeService, private sessionHelper: SessionHelper) { }

  ngOnInit() {

    this.ownerHomeService.getActivitiesResponsesPending(this.sessionHelper.get("corpUserId")).subscribe(data => {
      // this.message = data;
      console.log(data);
      this.queueToProcess = data._embedded.migrationKeys;
    }, error => {
      //FIXME: Display the error message.
      console.log(error);
    });
  }

}

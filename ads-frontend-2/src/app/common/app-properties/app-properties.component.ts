import { Component, OnInit } from '@angular/core';
import { Subject } from 'rxjs/Subject';
import 'rxjs/add/operator/map';
import { AppPropertiesService } from './app-properties.service';
import { SysConfigPipe } from './sysconfig.pipe';
import { Headers, Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';


@Component({
  selector: 'app-app-properties',
  templateUrl: './app-properties.component.html',
  styleUrls: ['./app-properties.component.scss'],
})

export class AppPropertiesComponent implements OnInit {
  public configGroups: any;
  public configDetails:any;
  grpName:string;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  defaultGroup: string = '';

  constructor(private appPropertiesService:AppPropertiesService,private http: Http) { }

  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5
    };

  	this.appPropertiesService.getSysConfigGroups().subscribe(
      sysConfigGroups => {
        this.configGroups = sysConfigGroups;
      });

  }
  editItem(item){
      item.edit = true;
      item.changedName = item.name;
      item.changedPriority = item.priority;
    }

  updateItem(item){
      let grName=this.grpName;
      let changedName = item.changedName;
      let changedPriority = item.changedPriority;
      var infoToSend = {
          "propertyName": changedName,
          "propertyValue": changedPriority,
          "grouping": "email"
        }
         
      this.appPropertiesService.updateItem(infoToSend,item.id,grName).subscribe(
      sysConfigGroups => {
        this.configGroups = sysConfigGroups;
      });
    }
    private handleError(error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }

    console.error(errMsg);
    return Observable.throw(errMsg);
  }

  getConfigDetails(grouping){
    this.grpName=grouping;
    this.appPropertiesService.getSysConfigData(grouping)
    .subscribe(
          sysConfigGroupsdetails => {
            this.configDetails = sysConfigGroupsdetails;
            this.dtTrigger.next();
          });
  }

}

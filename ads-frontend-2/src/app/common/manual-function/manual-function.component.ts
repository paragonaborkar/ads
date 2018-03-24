import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Globals } from '../../globals';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';
import 'rxjs/add/operator/map';

import { ManualFunctionService } from './manual-function.service';

@Component({
  selector: 'app-manual-function',
  templateUrl: './manual-function.component.html',
  styleUrls: ['./manual-function.component.scss']
})
export class ManualFunctionComponent implements OnInit {
  private subscription: Subscription;
  private timer: Observable<any>;

  fileName = "";
  myFile: File;
  fileForUpload: File;
  @Input() displayJobName = "";
  @Input() jobName = "";
  @Input() fileUpload: boolean = false;

  successMsg = "";
  runningMsg = "";
  errorMsg = "";

  constructor(private http: HttpClient, private global: Globals, private manualFunctionService: ManualFunctionService) { }

  ngOnInit() { }

  ngOnDestroy() {
    if ( this.subscription && this.subscription instanceof Subscription) {
      this.subscription.unsubscribe();
    }
  }

  updateMessage(successMsg, runningMsg, errorMsg) {
    this.successMsg = successMsg;
    this.runningMsg = runningMsg;
    this.errorMsg = errorMsg;
  }


  fileChange(files: any) {
    this.fileName = files[0].name;
    this.myFile = files[0].nativeElement;
    this.fileForUpload = files[0];
  }

  onSubmit(manualFunctionForm): void {
    if (this.fileUpload) {
      let headers = new HttpHeaders({ 'AdsFile': "AdsFile-BROWSER WILL REPLACE" });
      this.manualFunctionService.postFileAndRunJob(this.fileForUpload, this.jobName).subscribe(data => {
        this.updateMessage("", "File Uploaded. Job Running.", "");
      }, error => {
        this.updateMessage("", "", "Error running job.");
        console.log(error);
      });

    } else {

      // This is for Talend Jobs.
      this.updateMessage("", "Job Submitted...", "");
      this.manualFunctionService.runJob(this.jobName).subscribe(data => {
          // this.message = data;
          console.log("data from job request", data);
          this.runningJobName = data.jobName;
          this.updateMessage("", "Job Running...", "");
          this.timer = Observable.timer(5000); // 5000 millisecond means 5 seconds
          this.pollForProgress();
        }, error => {
          this.updateMessage("", "", "Error running job.");
          console.log(error);
        });
    }
  }

  runningJobName = '';
pollingCount = 0;

  public pollForProgress(){    
    this.subscription = this.timer.subscribe(() => {
      this.manualFunctionService.getJobStatus(this.runningJobName).subscribe(data => {
        console.log(data);
        if (data.status = 'InProgress' && this.pollingCount< 5) {
          this.timer = Observable.timer(5000);
          this.pollForProgress();
          this.pollingCount++;
        }
      });
    });
  }




}

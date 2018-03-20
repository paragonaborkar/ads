import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Globals } from '../../globals';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { ManualFunctionService } from './manual-function.service';

@Component({
  selector: 'app-manual-function',
  templateUrl: './manual-function.component.html',
  styleUrls: ['./manual-function.component.scss']
})
export class ManualFunctionComponent implements OnInit {

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

      this.updateMessage("", "Job Running...", "");
      this.manualFunctionService.runJob(this.jobName).subscribe(data => {
          // this.message = data;
          this.updateMessage("Completed", "", "");
        });
    }
  }




}

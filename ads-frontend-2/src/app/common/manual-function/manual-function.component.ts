import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

import { HttpClient, HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'app-manual-function',
  templateUrl: './manual-function.component.html',
  styleUrls: ['./manual-function.component.scss']
})
export class ManualFunctionComponent implements OnInit {

  fileName = "";
  myFile: File;
  @Input() displayJobName = "";
  @Input() jobName = "";
  @Input() fileUpload: boolean = false;

  successMsg = "";
  runningMsg = "";
  errorMsg = "";

  constructor(private http: HttpClient) { }

  ngOnInit() { }

 
  updateMessage(successMsg, runningMsg, errorMsg) {
    this.successMsg = successMsg;
    this.runningMsg = runningMsg;
    this.errorMsg = errorMsg;
  }
    
 
  fileChange(files: any) {
    console.log(files);
    this.fileName = files[0].name;
    this.myFile = files[0].nativeElement;
  }

  onSubmit(): void {
    if (this.fileUpload) {
      let headers = new HttpHeaders({ 'Content-Type': "multipart/*" });
      let _formData = new FormData();
      // _formData.append("Name", this.fileName);
      _formData.append("file", this.myFile);

      this.http.post("http://localhost:8080/talendJobs/" + this.jobName, _formData, { headers: headers, reportProgress: true })
        .map((response) => response)
        .subscribe((data) => {
          // this.message = data;
          console.log(data);
        });
    } else {
      this.http.post("http://localhost:8080/talendJobs/" + this.jobName, null)
        .map((response) => response)
        .subscribe((response) => {
          // this.message = data;
          console.log(response);
          this.updateMessage("Completed", "", "");
        });
    }
  }

}

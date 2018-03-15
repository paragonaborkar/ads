import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

import { HttpClient, HttpHeaders } from '@angular/common/http';


import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

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
    this.fileForUpload = files[0];
  }

  onSubmit(manualFunctionForm): void {

    console.log(this.fileForUpload);
    if (this.fileUpload) {
      // let headers = new HttpHeaders({ 'content-type': "application/x-www-form-urlencoded" });
      // let headers = new HttpHeaders({ 'content-type': "multipart/*" });
      let headers = new HttpHeaders({ 'AdsFile': "AdsFile-TOBEREMOVED" });
      // let headers = new HttpHeaders();


      this.postFile(this.fileForUpload).subscribe(data => {
        // do something, if upload success
        console.log("File upload success");
        console.log(data);
        }, error => {
          console.log(error);
        });

      // let _formData = new FormData();
      // // _formData.append("Name", this.fileName);
      // _formData.append("file", this.myFile);
    
      // console.log("_formData", _formData);


      // this.http.post("http://localhost:8080/" + this.jobName, _formData, { headers: headers, reportProgress: true })
      //   .map((response) => response)
      //   .subscribe((data) => {
      //     // this.message = data;
      //     console.log(data);
      //   });
    } else {
      
      this.http.post("http://localhost:8080/" + this.jobName, null)
        .map((response) => response)
        .subscribe((response) => {
          // this.message = data;
          console.log(response);
          this.updateMessage("Completed", "", "");
        });
    }
  }


  postFile(fileToUpload: File): Observable<boolean> {
    let headers = new HttpHeaders({ 'AdsFile': "AdsFile-TOBEREMOVED" });
    const formData: FormData = new FormData();
    formData.append('file', fileToUpload, fileToUpload.name);
    
    return this.http
      .post("http://localhost:8080/" + this.jobName, formData, { headers: headers, reportProgress: true })
      .map(() => { return true; });
     
}

}

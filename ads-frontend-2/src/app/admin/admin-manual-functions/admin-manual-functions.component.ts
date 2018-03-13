import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

import { HttpClient,HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-admin-manual-functions',
  templateUrl: './admin-manual-functions.component.html',
  styleUrls: ['./admin-manual-functions.component.scss']
})
export class AdminManualFunctionsComponent implements OnInit {
  fileName = "";
  myFile: File;
  displayJobName = "1. Load User Roles";
  jobName = "userRoles";


  constructor(private http: HttpClient) { }

  ngOnInit() { }

  
  fileChange(files: any) {
    console.log(files);
    this.fileName = files[0].name;
    this.myFile = files[0].nativeElement;
  }

  /* Now send your form using FormData */
  onSubmit(): void {

    let headers = new HttpHeaders({ 'Content-Type': "multipart/*" });

    let _formData = new FormData();
    _formData.append("Name", this.fileName);
    _formData.append("MyFile", this.myFile);
    let body = _formData;
    // let headers = new Headers({ 'Accept': type });
    // let options = new Options({
    //     headers: headers
    // });
    //

    // ,  /
    this.http.post("http://localhost:8080/talendJobs/" + this.jobName, body, { headers: headers, reportProgress: true })
      .map((response) => response )
      .subscribe((data) => {
        // this.message = data;
        console.log(data);
      }

      );
  }

}

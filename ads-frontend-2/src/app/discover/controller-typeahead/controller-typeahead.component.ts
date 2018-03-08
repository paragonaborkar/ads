import { Component, OnInit } from '@angular/core';
import { EventEmitter, Output, Input } from '@angular/core';
// import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';


import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead';

import { ControllerReleaseService } from '../controller-release/controller-release.service';

@Component({
  selector: 'app-controller-typeahead',
  templateUrl: './controller-typeahead.component.html',
  styleUrls: ['./controller-typeahead.component.scss']
})
export class ControllerTypeaheadComponent implements OnInit {

  @Output() selectedController = new EventEmitter();

  @Input() valueRequired: string;
  
  asyncSelected: any;
  typeaheadLoading: boolean;
  typeaheadNoResults: boolean;
  dataSource: Observable<any>;

  constructor(private controllerReleaseService: ControllerReleaseService) {
    
    this.dataSource = Observable.create((observer: any) => {
      // Runs on every search
      observer.next(this.asyncSelected);
    }).mergeMap((token: string) => this.getStatesAsObservable(token));

  }

  ngOnInit() {  }


  getStatesAsObservable(token: string) {
    console.log(token);
    return this.controllerReleaseService.searchForController(token);
  }

  changeTypeaheadLoading(e: boolean): void {
    this.typeaheadLoading = e;
  }

  changeTypeaheadNoResults(e: boolean): void {
    this.typeaheadNoResults = e;
    this.selectedController.emit({ selectedItem: null });
  }

  typeaheadOnSelect(e: TypeaheadMatch): void {
    console.log('Selected value: ', e);
    console.log('Selected value: ', e.item);
    console.log('Selected value: ', e.value);
    this.asyncSelected = e.value;
    this.selectedController.emit({ selectedItem: e.item });

  }
}

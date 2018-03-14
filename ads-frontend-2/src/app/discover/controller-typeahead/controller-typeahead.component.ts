import { Component, OnInit } from '@angular/core';
import { EventEmitter, Output, Input } from '@angular/core';
// import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';


import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead';

import { ControllerTypeaheadService } from './controller-typeahead.service';

@Component({
  selector: 'app-controller-typeahead',
  templateUrl: './controller-typeahead.component.html',
  styleUrls: ['./controller-typeahead.component.scss']
})
export class ControllerTypeaheadComponent implements OnInit {

  @Output() selectedController = new EventEmitter();

  @Input() valueRequired: string;
  @Input() controllerTypeName: string;
  @Input() controllerName: string;
  @Input() selectOptionsDataSource: string;
 
  selectedItem: any;
  asyncSelected: any;
  typeaheadLoading: boolean;
  typeaheadNoResults: boolean;
  dataSource: Observable<any>;

  constructor(private controllerTypeaheadService: ControllerTypeaheadService) {
    
    this.dataSource = Observable.create((observer: any) => {
      // Runs on every search
      observer.next(this.asyncSelected);
    }).mergeMap((token: string) => this.getStatesAsObservable(token));

  }

  ngOnInit() {  }

  getStatesAsObservable(token: string) {
    return this.controllerTypeaheadService.getData(this.selectOptionsDataSource, token);
  }

  changeTypeaheadLoading(e: boolean): void {
    this.typeaheadLoading = e;
  }

  changeTypeaheadNoResults(e: boolean): void {
    this.typeaheadNoResults = e;
    this.selectedItem = null;
    this.selectedController.emit({ selectedItem: null });
  }

  typeaheadOnSelect(e: TypeaheadMatch): void {
    console.log('Selected value: ', e);
    this.selectedItem = e.item;
    this.asyncSelected = e.value;
    this.selectedController.emit({ selectedItem: this.selectedItem, controllerName: this.controllerName});

  }
}

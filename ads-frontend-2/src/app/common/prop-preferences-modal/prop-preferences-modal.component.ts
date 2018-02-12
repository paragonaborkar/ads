import { Component, ViewChild, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { ModalDirective } from 'ngx-bootstrap/modal';


import { SortableModule } from 'ngx-bootstrap/sortable';
import { ApplicationConfigService } from '../application-config.service';
import { PropertyPreferenceConstants } from '../prop-preferences/prop-preferences-const';
import { FriendlyLabelPipePipe } from '../../pipes/friendly-label-pipe.pipe';


@Component({
  selector: 'app-prop-preferences-modal',
  templateUrl: './prop-preferences-modal.component.html',
  styleUrls: ['./prop-preferences-modal.component.scss']
})

export class PropPreferencesModalComponent implements OnInit {

  @ViewChild('propPreferenceModal') public propPreferenceModal: ModalDirective;
  @Output() done = new EventEmitter();
  @Input() pageName: String;


  public itemObjectsLeft: any[] = [];
  public itemObjectsRight: any[] = [];

  preferences: any[];
  preferenceDetails: any[];
  selectedPreferenceId: String;
  updatedPreference: any;
  updatedPreferences: any[] = [];

  showSettingsPanel = false;

  constructor(private applicationConfigService: ApplicationConfigService) { }

  ngOnInit() {
    this.getPreferenceDetails(this.pageName);
  }

  close() {
    console.log("Close() props");
    console.log(event);
    this.done.emit(event);
  }

  getPreferenceDetails(pageName: String) {

    if (pageName !== '' && pageName !== undefined) {

      this.applicationConfigService.getPreferencesForUser(pageName, 2, 0).subscribe(
        preference => {

          this.applicationConfigService.getPreferenceDetailsForPreference(preference._links.preferenceDetails.href)
            .subscribe(preferenceDetails => {
              
              this.itemObjectsLeft = [];
              this.itemObjectsRight = [];

              // For each column that's available, put it in the right "bucket" or in our case, items on the left or items on the right of the screen.
              preferenceDetails._embedded.preferenceDetails.forEach(preferenceDetail => {
             
                if (preferenceDetail.fieldVisible === 1) {
                  this.itemObjectsLeft.push(preferenceDetail);
                } else {
                  this.itemObjectsRight.push(preferenceDetail);
                }
              
              });

              // Put the items on the left and right in the right order for display.
              this.sortItems(this.itemObjectsLeft);
              this.sortItems(this.itemObjectsRight);
              this.showSettingsPanel = true;

            });
        });
    } else {
      this.showSettingsPanel = false;
    }
  }

  // When items are droped or moved this function is call to keep track of the updates.
  drop() {
    this.updatedPreferences = [];
    console.log(this.itemObjectsLeft);

    this.itemObjectsLeft.forEach((leftItem, index) => {
      this.updatedPreference = {
        fieldOrder: index + 1,
        fieldVisible: 1,
        patchLink: leftItem._links.preferenceDetail.templated === true ? leftItem._links.preferenceDetail.href.substring(0, leftItem._links.preferenceDetail.href.indexOf('{')) : leftItem._links.preferenceDetail.href
      };
      this.updatedPreferences.push(this.updatedPreference);
    });

    this.itemObjectsRight.forEach((rightItem, index) => {
      this.updatedPreference = {
        fieldOrder: index + 1,
        fieldVisible: 0,
        patchLink: rightItem._links.preferenceDetail.templated === true ? rightItem._links.preferenceDetail.href.substring(0, rightItem._links.preferenceDetail.href.indexOf('{')) : rightItem._links.preferenceDetail.href
      };
      this.updatedPreferences.push(this.updatedPreference);
    });

    // Save each of the column information. 
    // TODO: Only make 1 call.
    this.updatedPreferences.forEach(updatedPreference => {
      this.applicationConfigService.updatePreferenceDetails(updatedPreference).subscribe(function (response) {
        console.log('Preference details were updated successfully.');
      }, function (error) {
        console.log(error);
      });
    });
  }

  sortItems(items: any[]) {
    items.sort(function (item1, item2) {
      if (item1.fieldOrder > item2.fieldOrder) {
        return 1;
      } else {
        return -1;
      }
    });
  }

}

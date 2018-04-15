import { Component, ViewChild, OnInit } from '@angular/core';
import { EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { ModalDirective } from 'ngx-bootstrap/modal';


import { SortableModule } from 'ngx-bootstrap/sortable';
import { ApplicationConfigService } from '../application-config.service';
import { FriendlyLabelPipePipe } from '../../pipes/friendly-label-pipe.pipe';
import { SessionHelper } from '../../auth/session.helper';
import { AdsErrorService } from '../../common/ads-error.service';


@Component({
  selector: 'prop-preferences-modal',
  templateUrl: './prop-preferences-modal.component.html',
  styleUrls: ['./prop-preferences-modal.component.scss']
})

export class PropPreferencesModalComponent implements OnInit {
  public errorMessage:string = "";

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

  constructor(private applicationConfigService: ApplicationConfigService, private sessionHelper: SessionHelper, private errorService: AdsErrorService) { }

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

      console.log("applyPreferences Start");
      
      // Since this modal allows users to modify and save their column preferences for a page, 
      // We will request that this service creates Preferences and Preference Details for this User by copying from the existing SYSTEM preference info.

      this.applicationConfigService.getPreferencesForUser(pageName, this.sessionHelper.get("nativeUserId"), this.sessionHelper.get("corpUserId"), true)

        .subscribe(columnPreferences => {

          this.itemObjectsLeft = [];
          this.itemObjectsRight = [];

          // For each column that's available, put it in the right "bucket" or in our case, items on the left or items on the right of the screen.
          columnPreferences._embedded.preferenceDetails.forEach(preferenceDetail => {

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

        }, err => {
          // Get the ADS configured error message to display.
          this.errorMessage = this.errorService.processError(err, "propPreferenceModal", "GET");
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
      if (this.errorMessage == '') {
        this.applicationConfigService.updatePreferenceDetails(updatedPreference).subscribe(function (response) {
          console.log('Preference details were updated successfully.');
        }, err => {
          // Get the ADS configured error message to display.
          this.errorMessage = this.errorService.processError(err, "propPreferenceModal", "POST");
        });
      }
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

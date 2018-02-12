import { Component, OnInit, Input } from '@angular/core';

import { SortableModule } from 'ngx-bootstrap/sortable';
import { ApplicationConfigService } from '../application-config.service';
import { PropertyPreferenceConstants } from './prop-preferences-const';
import { FriendlyLabelPipePipe } from '../../pipes/friendly-label-pipe.pipe';


@Component({
  selector: 'app-prop-preferences',
  templateUrl: './prop-preferences.component.html',
  styleUrls: ['./prop-preferences.component.scss']
})

export class PropPreferencesComponent implements OnInit {

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
    // Get the prefereces available. 
    this.applicationConfigService.getPreferencesForSystemAdmin()
      .subscribe(
      preferences => {
        this.preferences = preferences._embedded.preferences;

        console.log("this.preferences");
        console.log(this.preferences);
      });
  }

  getDisplayNameForPreferencePageName(pageName: String): String {
    console.log(PropertyPreferenceConstants.PAGES.get(pageName));
    return PropertyPreferenceConstants.PAGES.get(pageName);
  }

  getPreferenceDetails(selectedPreferenceDetailsResource: String) {

    // console.log("getPreferenceDetails() selectedPreferenceDetailsResource:");
    // console.log( selectedPreferenceDetailsResource);
    if (selectedPreferenceDetailsResource !== '' && selectedPreferenceDetailsResource !== undefined) {

      this.applicationConfigService.getPreferenceDetailsForPreference(selectedPreferenceDetailsResource).subscribe(
        preferenceDetails => {
          this.preferenceDetails = preferenceDetails._embedded.preferenceDetails;
          // console.log("this.preferenceDetails");
          // console.log(this.preferenceDetails);

          if (this.preferenceDetails !== undefined && this.preferenceDetails.length > 0) {
            this.showSettingsPanel = true;
            this.itemObjectsLeft = [];
            this.itemObjectsRight = [];

            // For each column that's available, put it in the right "bucket" or in our case, items on the left or items on the right of the screen.
            for (let j = 0; j < this.preferenceDetails.length; j++) {

              if (this.preferenceDetails[j].fieldVisible === 1) {
                this.itemObjectsLeft.push(this.preferenceDetails[j]);
              } else {
                this.itemObjectsRight.push(this.preferenceDetails[j]);
              }
            }

            // Put the items on the left and right in the right order for display.
            this.sortItems(this.itemObjectsLeft);
            this.sortItems(this.itemObjectsRight);
          } else {
            this.showSettingsPanel = false;
          }
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

import { Component, OnInit, Input } from '@angular/core';

import { SortableModule } from 'ngx-bootstrap/sortable';
import { ApplicationConfigService } from '../services/application-config.service';
import { Headers, Http, Response } from '@angular/http';

@Component({
  selector: 'app-application-config',
  templateUrl: './application-config.component.html',
  styleUrls: ['./application-config.component.scss']
})
export class ApplicationConfigComponent implements OnInit {
  private headers = new Headers({ 'Content-Type': 'application/json' });

  public itemObjectsLeft: any[] = [
  
  ];

  public itemObjectsRight: any[] = [
    { id: 4, name: 'Tornado', truncateAtChars: 12 },
    { id: 5, name: 'Mr. O', truncateAtChars: 34 },
    { id: 6, name: 'Tomato', truncateAtChars: 45 }
  ];

  preferences: any[];
  preferenceDetails: any[];
  selectedPreferenceId: String;
  updatedPreference: any;
  updatedPreferences: any[] = [];

  columnMap: Map<String, String> = new Map();
  
  showSettingsPanel = false;
  constructor(
    private applicationConfigService: ApplicationConfigService
  ) {
    
   }

  ngOnInit() {
    this.columnMap.set('firstName', "First Name");
    this.columnMap.set('lastName', "Last Name");
    this.columnMap.set('email', "Email");
    this.columnMap.set('enabled', "Enabled");
    this.columnMap.set('userRoleId', "Roles");
    this.applicationConfigService.getPreferences().subscribe(preferences => this.preferences = preferences);
  }

  getColumnDisplayName(columnName: String) {
    return this.columnMap.get(columnName);
  }

  getPreferenceDetails(selectedPreferenceId: String) {
    if (selectedPreferenceId !== undefined && selectedPreferenceId !== 'undefined'.toString()) {
      for (let i = 0; i < this.preferences.length; i++) {
        // console.log(this.preferences[i]);
        if (this.preferences[i].id.toString() === selectedPreferenceId) {
          // console.log('Found preference.');
          const tempPreference = this.preferences[i];
          this.applicationConfigService.getPreferenceDetailsForPreference(tempPreference)
            .then(preferenceDetails => {
              this.preferenceDetails = preferenceDetails;
              if (preferenceDetails !== undefined && preferenceDetails !== 'undefined'.toString() && preferenceDetails.length > 0) {
                this.showSettingsPanel = true;
                this.itemObjectsLeft = [];
                this.itemObjectsRight = [];
                for (let j = 0; j < this.preferenceDetails.length; j++) {
                  // console.log(this.preferenceDetails[j]);
                  if (this.preferenceDetails[j].fieldVisible === 1) {

                    this.itemObjectsLeft.push(this.preferenceDetails[j]);
                  } else {
                    this.itemObjectsRight.push(this.preferenceDetails[j]);
                  }
                }
                this.sortItems(this.itemObjectsLeft);
                this.sortItems(this.itemObjectsRight);
              } else {
                this.showSettingsPanel = false;
              }
            });
          break;
        }
      }
    } else {
      this.showSettingsPanel = false;
    }
  }

  drop() {
    this.updatedPreferences = [];
    this.itemObjectsLeft.forEach((leftItem, index) => {
      this.updatedPreference = {
        fieldOrder: index + 1,
        fieldVisible: 1,
        patchLink: leftItem._links.preferenceDetail.href
      };
      this.updatedPreferences.push(this.updatedPreference);
    });
    this.itemObjectsRight.forEach((rightItem, index) => {
      this.updatedPreference = {
        fieldOrder: index + 1,
        fieldVisible: 0,
        patchLink: rightItem._links.preferenceDetail.href
      };
      this.updatedPreferences.push(this.updatedPreference);
    });
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

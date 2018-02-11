import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { Subject } from 'rxjs/Subject';

import { FriendlyLabelPipePipe } from '../../pipes/friendly-label-pipe.pipe';

import { ApplicationConfigService } from '../../common/application-config.service';

import { SpringRestResponse } from '../../spring-rest-response';
import { UserAdminService } from './user-admin.service';

import { ModalDirective } from 'ngx-bootstrap';
import {Page} from "../../common/page";

import { AdsHelperService } from '../../common/ads-helper.service';

/**
 * An array of data with an associated page object used for paging
 */
export class PagedData<T> {
  data = new Array<T>();
  page = new Page();
}

@Component({
  selector: 'admin-native-user',
  templateUrl: './admin-native-user.component.html',
  styleUrls: ['./admin-native-user.component.scss']

})
export class AdminNativeUserComponent implements OnInit {
  @ViewChild('hdrTmpl') hdrTmpl: TemplateRef<any>;
  @ViewChild('actionTmpl') actionTmpl: TemplateRef<any>;

  @ViewChild('updateModal') public updateModal: ModalDirective;

  @ViewChild('propPreferenceModal') public propPreferenceModal: ModalDirective;

  page = new Page();

  // Listing of native users to display 
  rows: any[] = [];
  columns: any = [];

  // User to update or delete or change password
  public User = {};
  public pageName = "UserListing";
  public isAddUserModal = false;
  public isUpdateModal = false;
  public isDeleteModal = false;
  public isPropPreferenceModal = false;

  constructor(private usersService: UserAdminService, private applicationConfigService: ApplicationConfigService, private adsHelper: AdsHelperService) {
    this.page.number = 1;
    this.page.pageNumber = 1;
    this.page.size = 3;
  }


  ngOnInit() {
    this.setPage({ offset: 0 });
    this.applyPreferences();
  }


  /**
   * Populate the table with new data based on the page number
   * @param page The page to select
   */
  setPage(pageInfo){
    this.page.number = pageInfo.offset;
    this.page.pageNumber = pageInfo.offset;

     // This method is to get all the values from user_native table
     this.usersService.getUserNativesPaging(this.page).subscribe(
      usersNativeResponse => {
        console.log(usersNativeResponse);
        this.page = usersNativeResponse.page;
        this.page.pageNumber = this.page.number;
        this.rows = this.adsHelper.ungroupJson(usersNativeResponse._embedded.userNatives, "userRole", ["createTime", "updateTime"]);
        console.log("******************");
        console.log(this.rows);
        console.log(this.page);
        console.log("****");
      });

  }

  

  delete(row) {
    console.log(row._links.self.href);
  }

  update(row) {
    console.log(row._links.self.href);
    this.User = row;
    this.isUpdateModal = true;
  }

  updateUser(data): void {
    this.usersService.update(data).subscribe(function (resp) {
      this.getUserNatives();
      this.editModal.hide();
    }, function (error) {
      alert('Error to update user ' + data.firstName);
    });
  }

  showPropertyModal() {
    this.isPropPreferenceModal = true;
  }

  changePassword(row) {
    console.log(row._links.self.href);
  }

  // This method is to hide the modals  
  onHide(event): void {
    if (event === 'add') {
      this.isAddUserModal = false;
    } else if (event === 'delete') {
      this.isDeleteModal = false;
    } else if (event === 'edit') {
      this.isUpdateModal = false;
    } else if (event === 'propPreferenceModal') {
      this.isPropPreferenceModal = false;
      // this.setPage({ offset: this.page.pageNumber });
      this.applyPreferences();
    }
  }




  applyPreferences(): void {

    this.applicationConfigService.getPreferencesForUser("UserListing", 2, 0)
      .subscribe(
      columnPreferences => {

        console.log(columnPreferences);
        console.log(columnPreferences._links.preferenceDetails.href);

        this.applicationConfigService.getPreferenceDetailsForPreference(columnPreferences._links.preferenceDetails.href)
          .subscribe(preferenceDetails => {

            console.log(preferenceDetails);

            preferenceDetails._embedded.preferenceDetails.forEach(preferenceDetail => {

              var obj = this.columns.find(function (obj) {
                return obj.name === preferenceDetail.fieldName;
              }, preferenceDetail.fieldName);

              if (obj == undefined) {
                if (preferenceDetail.fieldVisible === 1) {
                  this.columns.push({
                    name: new FriendlyLabelPipePipe().transform(preferenceDetail.fieldName),
                    prop: preferenceDetail.fieldName,
                    order: preferenceDetail.fieldOrder
                  });
                }

              } else {
                // This is when we initialize the list of columns manually through this component.
                this.columns.find(column => {
                  if (column.name === preferenceDetail.fieldName) {
                    // column.hidden = preferenceDetail.fieldVisible === 1 ? false : true;
                    return true;
                  }
                });
              }
            });

            this.columns.push({
              headerTemplate: this.hdrTmpl,
              cellTemplate: this.actionTmpl,
              order: 1000
            });


            // Display the columns in the correct order now that we have the complete set of them.
            this.sortColumns(this.columns);
            console.log("Sorted: this.columns");
            console.log(this.columns);
          });

        // });


      });
  }

  sortColumns(items: any[]) {
    items.sort(function (item1, item2) {
      if (item1.order > item2.order) {
        return 1;
      } else {
        return -1;
      }
    });
  }
}

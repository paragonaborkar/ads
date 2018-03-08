import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';
import 'rxjs/add/operator/map';

import { ModalDirective } from 'ngx-bootstrap';

import { FriendlyLabelPipePipe } from '../../pipes/friendly-label-pipe.pipe';

import { ApplicationConfigService } from '../../common/application-config.service';
import { UserAdminService } from './user-admin.service';
import { AdsHelperService } from '../../common/ads-helper.service';

import { SpringRestResponse } from '../../spring-rest-response';

import { SessionHelper } from '../../auth/session.helper';

import { Page } from "../../common/page";

import { DataTableColTemplatesComponent } from '../../common/data-table-col-templates/data-table-col-templates.component'


@Component({
  selector: 'admin-native-user',
  templateUrl: './admin-native-user.component.html',
  styleUrls: ['./admin-native-user.component.scss']

})
export class AdminNativeUserComponent implements OnInit {
  @ViewChild(DataTableColTemplatesComponent) dataTableColsTemplate: DataTableColTemplatesComponent;
  columnTemplates = {};
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
  public isCreateModal = false;
  public isUpdateModal = false;
  public isDeleteModal = false;
  public isPropPreferenceModal = false;

  constructor(private usersService: UserAdminService, private applicationConfigService: ApplicationConfigService, private adsHelper: AdsHelperService, private sessionHelper: SessionHelper) {
    this.page.number = 1;
    this.page.pageNumber = 1;
    this.page.size = 3;
  }


  ngOnInit() {
  }

  ngAfterViewInit() {
    this.columnTemplates = this.dataTableColsTemplate.getTemplates();
    this.columnTemplates["actionTmpl"] = this.actionTmpl;

    this.setPage({ offset: 0 });
    this.applyPreferences();
  }



  /**
   * Populate the table with new data based on the page number
   * @param page The page to select
   */
  setPage(pageInfo) {
    console.log("Loading page...");
    this.page.number = pageInfo.offset;
    this.page.pageNumber = pageInfo.offset;

    // This method is to get all the values from user_native table
    this.usersService.getUserNativesPaging(this.page).subscribe(
      usersNativeResponse => {
        console.log(usersNativeResponse);
        this.page = usersNativeResponse.page;
        this.page.pageNumber = this.page.number;
        if (usersNativeResponse.page.totalElements > 0) {
          this.rows = this.adsHelper.ungroupJson(usersNativeResponse._embedded.userNatives, "userRole", ["createTime", "updateTime"]);
        }
        console.log("******************");
        console.log(this.rows);
        console.log(this.page);
        console.log("****");
        if (this.page.number > 0 && this.rows.length == 0) {
          pageInfo.offset = pageInfo.offset - 1;
          this.setPage(pageInfo);
        }
      });
  }


  showCreateModal() {
    this.isCreateModal = true;
  }

  showUpdateModal(row) {
    console.log(row._links.self.href);
    this.User = row;
    this.isUpdateModal = true;
  }

  showDeleteModal(row) {
    console.log(row._links.self.href);
    this.User = row;
    this.isDeleteModal = true;
  }

  // TODO: This need to be implemented
  showChangePassword(row) {
    console.log(row._links.self.href);
  }

  showPropertyModal() {
    this.isPropPreferenceModal = true;
  }

  // updateUser(data): void {
  //   console.log("updateUser");
  //   this.isUpdateModal = false;
  // }



  // This method is to hide the modals  
  onHide(modalToHide): void {
    console.log("onHide(event)");
    console.log(modalToHide);

    if (modalToHide === 'create') {
      this.isCreateModal = false;
    } else if (modalToHide === 'delete') {
      this.isDeleteModal = false;
      this.setPage({ offset: this.page.pageNumber });
    } else if (modalToHide === 'update') {
      this.isUpdateModal = false;
      this.setPage({ offset: this.page.pageNumber });
    } else if (modalToHide === 'propPreferenceModal') {
      this.isPropPreferenceModal = false;
      this.columns = [];    // This makes the columns display refresh after the user updates it.
      this.applyPreferences();
    }
  }


  applyPreferences(): void {
    console.log("applyPreferences Start");

    this.applicationConfigService.getPreferencesForColumns(this.pageName, this.columns, this.columnTemplates)
      .subscribe(columnPreferences => {
        console.log("columnPreferences");
        console.log(columnPreferences);
        this.columns = columnPreferences;
      });

  }


}

import { Component, OnInit, ViewChild } from '@angular/core';
import { SpringRestResponse } from '../spring-rest-response';
import { UserAdminService } from '../user-admin.service';
import { ModalDirective } from 'ngx-bootstrap';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { PagerService } from '../pager.service';
import { ApplicationConfigService } from '../services/application-config.service';


import * as _ from 'underscore';
import { SelectItem } from 'primeng/primeng';


@Component({
  selector: 'app-user-admin',
  templateUrl: './user-admin.component.html',
  styleUrls: ['./user-admin.component.scss']
})
export class UserAdminComponent implements OnInit {
  @ViewChild('addModal') public addModal: ModalDirective;
  @ViewChild('editModal') public editModal: ModalDirective;
  @ViewChild('deleteModal') public deleteModal: ModalDirective;

  roleArray = ['Migration Specialist', 'Storage Owner', 'ADS Admin'];
  role: string;
  public users: any;
  public isAddUserModal = false;
  public isEditModal = false;
  public isDeleteModal = false;

  public User = {};
  public addPersonError = '';
  pager: any = {};
  enabledValues: SelectItem[];
  roles: SelectItem[];
  preference: any;
  preferences: any[];
  preferenceDetails: any;

  

  columns: any[] = [
    {
      field: 'firstName',
      header: 'First Name',
      template: false,
      filterMatchMode: 'contains',
      hidden: false
    },
    {
      field: 'lastName',
      header: 'Last Name',
      template: false,
      filterMatchMode: 'contains',
      hidden: false
    },
    {
      field: 'email',
      header: 'Email Address',
      template: false,
      filterMatchMode: 'contains',
      hidden: false
    },
    {
      field: 'userRoleId',
      header: 'Role',
      template: true,
      filterMatchMode: 'equals',
      hidden: false
    },
    {
      field: 'enabled',
      header: 'Active',
      template: true,
      filterMatchMode: 'equals',
      hidden: false
    }
  ];
  columnOptions: any[];

  // paged items
  pagedItems: any[];

  constructor(private usersService: UserAdminService,
    private pagerService: PagerService,
    private applicationConfigService: ApplicationConfigService) {

  }

  ngOnInit() {
    const that = this;
    this.usersService.getUserNatives().subscribe(
      response => {
        //   console.log('REsponse ==> ' + JSON.stringify(response))
        this.users = response._embedded.userNatives;

        this.setPage(1);
      });
    this.enabledValues = [];
    this.enabledValues.push({ label: 'All', value: null });
    this.enabledValues.push({ label: 'Yes', value: 1 });
    this.enabledValues.push({ label: 'No', value: 0 });

    this.roles = [];
    // ideally the roles must be fetched from the backend
    // 'Migration Specialist', 'Storage Owner', 'ADS Admin'
    this.roles.push({ label: 'All Roles', value: null });
    this.roles.push({ label: 'Migration Specialist', value: 0 });
    this.roles.push({ label: 'Storage Owner', value: 1 });
    this.roles.push({ label: 'ADS Admin', value: 2 });
    this.applyPreferences();

    // console.log("wow sai common "+JSON.stringify(this.users));
  }

  showAddUser() {
    this.isAddUserModal = true;
  }

  edit(obj) {
    this.User = JSON.parse(JSON.stringify(obj));
    this.isEditModal = true;
  }

  addUser(event) {
    const that = this;
    console.log(event);
    this.usersService.addUser(event).subscribe(function (resp) {
      that.getUserNatives();
      that.addModal.hide();
    }, function (error) {
      alert('Person add error ' + event.firstName);
    });
  }

  /**
   * This method is to get all the values from usernatives table
   * @param
   */

  getUserNatives() {
    const that = this;
    this.usersService.getUserNatives().subscribe(function (resp) {
      that.users = resp._embedded.userNatives;
      that.pagedItems = resp._embedded.userNatives;
      console.log(resp._embedded.userNatives);
    }, function (error) {
      alert('Error in getting persons');
    });
  }
  /**
   * This method is to close the modals
   *
   */

  onClose(event) {
    if (event === 'add') {
      this.addModal.hide();
    } else if (event === 'edit') {
      this.editModal.hide();
    } else if (event === 'delete') {
      this.deleteModal.hide();
    }
  }

  /**
   * Delete user
   * @param obj
   */
  delete(obj) {
    this.User = JSON.parse(JSON.stringify(obj));
    //console.log(obj);
    this.isDeleteModal = true;
  }

  /**
   * Delete user
   * @param event
   */
  deleteUser(event) {
    //console.log(event);
    const that = this;
    this.usersService.delete(event).subscribe(function (resp) {
      that.getUserNatives();
      that.deleteModal.hide();
    }, function (error) {
      alert('Error in delete person ' + event.firstName);
    });
  }

  /**
   * edit user
   * @param data
   */
  editUser(data) {
    const that = this;
    this.usersService.update(data).subscribe(function (resp) {
      that.getUserNatives();
      that.editModal.hide();
    }, function (error) {
      alert('Error to update user ' + data.firstName);
    });
  }

  setPage(page: number) {
    if (page < 1 || page > this.pager.totalPages) {
      return;
    }

    // get pager object from service
    this.pager = this.pagerService.getPager(this.users.length, page);

    // get current page of items
    this.pagedItems = this.users.slice(this.pager.startIndex, this.pager.endIndex + 1);
  }
  /**
   * This method is to hide the modals
   * @param event
   */

  onHide(event) {
    if (event === 'add') {
      this.isAddUserModal = false;
    } else if (event === 'delete') {
      this.isDeleteModal = false;
    } else if (event === 'edit') {
      this.isEditModal = false;
    }
  }

  applyPreferences() {
    console.log('In preferences...');
    const that = this;
    this.applicationConfigService.getPreferences().subscribe(function (response) {
      that.preferences = response;
      //console.log(response);
      that.preferences.forEach(pref => {
        //console.log(pref);
        if (pref.pageName === 'UserAdmin') {
          //console.log('Inside PageName');
          that.preference = pref;
          that.applicationConfigService.getPreferenceDetailsForPreference(that.preference)
            .then(preferenceDetails => {
              that.preferenceDetails = preferenceDetails;
              that.preferenceDetails.forEach(preferenceDetail => {
                that.columns.find(column => {
                  if (column.field === preferenceDetail.fieldName) {
                    column.hidden = preferenceDetail.fieldVisible === 1 ? false : true;
                    return true;
                  } else {
                    return false;
                  }
                });
              });
            });
        }
      });
    }, function(error) {
      console.log(error);
    });

    // console.log(this.preference);

    //console.log(this.columns);
  }
}



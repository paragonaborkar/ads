import { Component, OnInit, ViewChild } from '@angular/core';
import { Headers, RequestOptions, Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

import { ModalDirective } from 'ngx-bootstrap';
import { SelectItem } from 'primeng/primeng';

import { PagerService } from '../../common/pager.service';
import { ApplicationConfigService } from '../../common/application-config.service';

import { SpringRestResponse } from '../../spring-rest-response';
import { UserAdminService } from './user-admin.service';


import { Subject } from 'rxjs/Subject';
import 'rxjs/add/operator/map';

import { FriendlyLabelPipePipe } from '../../pipes/friendly-label-pipe.pipe';
import { ArrayFilterPipePipe } from '../../pipes/array-filter-pipe.pipe';
import { ColumnConfig } from '../../pipes/column-config';

@Component({
  selector: 'app-user-admin',
  templateUrl: './user-admin.component.html',
  styleUrls: ['./user-admin.component.scss']
})
export class UserAdminComponent implements OnInit {

  @ViewChild('addModal') public addModal: ModalDirective;
  @ViewChild('updateModal') public updateModal: ModalDirective;
  @ViewChild('deleteModal') public deleteModal: ModalDirective;

  columnFilterArgs = {hidden: false};

  // TODO: load this from REST call... don't default it. We have a user_role table.
  roleArray = ['Migration Specialist', 'Storage Owner', 'ADS Admin'];
  role: string;
  public users: any;
  public isAddUserModal = false;
  public isUpdateModal = false;
  public isDeleteModal = false;

  public User = {};
  public addPersonError = '';
  pager: any = {};
  enabledValues: SelectItem[];
  roles: SelectItem[];
  preference: any;
  preferences: any[];
  preferenceDetails: any;

  // TODO: load this from REST call... don't default it.
  // For now, we may have to default the Role as example data until the REST call provide it easily.
  columns: ColumnConfig[] = [
    // {
    //   field: 'firstName',
    //   header: 'First Name',
    //   template: false,
    //   filterMatchMode: 'contains',
    //   hidden: false
    // },
    // {
    //   field: 'lastName',
    //   header: 'Last Name',
    //   template: false,
    //   filterMatchMode: 'contains',
    //   hidden: false
    // },
    // {
    //   field: 'email',
    //   header: 'Email Address',
    //   template: false,
    //   filterMatchMode: 'contains',
    //   hidden: false
    // },
    // {
    //   field: 'userRoleId',
    //   header: 'Role',
    //   template: true,
    //   filterMatchMode: 'equals',
    //   hidden: false,
    //   order: 99
    // }
    // },
    // {
    //   field: 'enabled',
    //   header: 'Active',
    //   template: true,
    //   filterMatchMode: 'equals',
    //   hidden: false,
    //   order: 100
    // }
    // ,
    // {
    //   field: 'Actions',
    //   header: 'Actions',
    //   template: true,
    //   filterMatchMode: 'equals',
    //   hidden: false,
    //   order: 1000
    // }
  ];

  columnOptions: any[];

  // paged items
  pagedItems: any[];



  constructor(private usersService: UserAdminService, private pagerService: PagerService, private applicationConfigService: ApplicationConfigService) { }

  dtOptions: DataTables.Settings = {};
  // We use this trigger because fetching the list of persons can be quite long,
  // thus we ensure the data is fetched before rendering
  dtTrigger: Subject<any> = new Subject();


  ngOnInit() {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 2
    };

    const that = this;
    this.usersService.getUserNatives().subscribe(
      usersNativeResponse => {
        //   console.log('REsponse ==> ' + JSON.stringify(response))
        this.users = usersNativeResponse._embedded.userNatives;

        this.setPage(1);
        console.log(usersNativeResponse);
        // Calling the DT trigger to manually render the table
        this.dtTrigger.next();


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

    // We need to page this result:
    // console.log("wow sai common "+JSON.stringify(this.users));
  }

  showAddUser() {
    this.isAddUserModal = true;
  }

  edit(obj) {
    this.User = obj; 
    this.isUpdateModal = true;
  }

  addUser(event) {
    const that = this;
    console.log(event);
    this.usersService.addUser(event).subscribe(function (resp) {
      that.getUserNatives();
      // that.addModal.hide();
    }, function (error) {
      alert('Person add error ' + event.firstName);
    });
  }


  // This method is to get all the values from user_native table
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


  // Close the modals...
  onClose(event) {
    if (event === 'add') {
      this.addModal.hide();
    } else if (event === 'update') {
      this.updateModal.hide();
    } else if (event === 'delete') {
      this.deleteModal.hide();
    }
  }


  // we have delete() and deleteUser() - which one is used?
  delete(obj) {
    this.User = JSON.parse(JSON.stringify(obj));
    //console.log(obj);
    this.isDeleteModal = true;
  }


  deleteUser(event) {
    //console.log(event);
    const that = this;
    this.usersService.delete(event).subscribe(function (resp) {
      that.getUserNatives();
      // that.deleteModal.hide();
    }, function (error) {
      alert('Error in delete person ' + event.firstName);
    });
  }


  updateUser(data) {
    const that = this;
    this.usersService.update(data).subscribe(function (resp) {
      that.getUserNatives();
      // that.editModal.hide();
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


  // This method is to hide the modals  
  onHide(event) {
    if (event === 'add') {
      this.isAddUserModal = false;
    } else if (event === 'delete') {
      this.isDeleteModal = false;
    } else if (event === 'edit') {
      this.isUpdateModal = false;
    }
  }

  columnPreferences: any;

  applyPreferences(): void {
    console.log('In preferences...');
    // const that = this;
    this.applicationConfigService.getPreferences()
      .subscribe(
      columnPreferences => {
        this.columnPreferences = columnPreferences;
        console.log("this.columnPreferences");
        console.log(this.columnPreferences);

        this.columnPreferences._embedded.preferences.forEach(pref => {

          if (pref.pageName === 'UserListing') {

            this.applicationConfigService.getPreferenceDetailsForPreference(pref._links.preferenceDetails.href)
              .subscribe(preferenceDetails => {
                this.preferenceDetails = preferenceDetails;
                console.log("this.preferenceDetails");
                console.log(this.preferenceDetails);

                this.preferenceDetails._embedded.preferenceDetails.forEach(preferenceDetail => {

                  var obj = this.columns.find(function (obj) {
                    return obj.field === preferenceDetail.fieldName;
                  }, preferenceDetail.fieldName);

                  if (obj == undefined) {
                    this.columns.push({
                      field: preferenceDetail.fieldName,
                      header: preferenceDetail.fieldName,
                      template: false,
                      filterMatchMode: 'contains',
                      hidden: preferenceDetail.fieldVisible === 1 ? false : true,
                      order: preferenceDetail.fieldOrder
                    });

                  } else {
                    this.columns.find(column => {
                      if (column.field === preferenceDetail.fieldName) {
                        column.hidden = preferenceDetail.fieldVisible === 1 ? false : true;
                        return true;
                      }
                    });
                  }
                });

                // Display the columns in the correct order now that we have the complete set of them.
                this.sortColumns(this.columns);
                console.log("Sorted: this.columns");
                console.log(this.columns);
              });
          }
        });


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
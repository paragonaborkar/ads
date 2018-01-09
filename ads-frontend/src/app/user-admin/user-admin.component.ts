import { Component, OnInit, ViewChild } from '@angular/core';
import { SpringRestResponse } from '../spring-rest-response';
import { UserAdminService } from '../user-admin.service';
import { ModalDirective } from 'ngx-bootstrap';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { PagerService } from '../pager.service';


import * as _ from 'underscore';


@Component({
  selector: 'app-user-admin',
  templateUrl: './user-admin.component.html',
  styleUrls: ['./user-admin.component.scss']
})
export class UserAdminComponent implements OnInit {
  @ViewChild('addModal') public addModal: ModalDirective;
  @ViewChild('editModal') public editModal: ModalDirective;
  @ViewChild('deleteModal') public deleteModal: ModalDirective;


  public users: any;
  public isAddUserModal = false;
  public isEditModal = false;
  public isDeleteModal = false;

  public User = {};
  public addPersonError = '';
  pager: any = {};

  // paged items
  pagedItems: any[];

  constructor(private usersService: UserAdminService,
    private pagerService: PagerService) {

  }

  ngOnInit() {
    this.usersService.getUserNatives().subscribe(
      response => {
        //   console.log('REsponse ==> ' + JSON.stringify(response))
        this.users = response._embedded.userNatives;
        this.setPage(1);
      });

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

  getUserNatives() {
    const that = this;
    this.usersService.getUserNatives().subscribe(function (resp) {
      that.users = resp._embedded.userNatives;
      that.pagedItems = resp._embedded.userNatives;
      // console.log(resp._embedded.userNatives);
    }, function (error) {
      alert('Error in getting persons');
    });
  }

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
   * Delete person
   * @param obj
   */
  delete(obj) {
    this.User = JSON.parse(JSON.stringify(obj));
    console.log(obj);
    this.isDeleteModal = true;
  }

  deleteUser(event) {
    console.log(event);
    const that = this;
    this.usersService.delete(event).subscribe(function (resp) {
      that.getUserNatives();
      that.deleteModal.hide();
    }, function (error) {
      alert('Error in delete person ' + event.firstName);
    });
  }

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

  onHide(event) {
    if (event === 'add') {
      this.isAddUserModal = false;
    } else if (event === 'delete') {
      this.isDeleteModal = false;
    } else if (event === 'edit') {
      this.isEditModal = false;
    }
  }
}



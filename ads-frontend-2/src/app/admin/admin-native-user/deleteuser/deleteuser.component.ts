import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

import { UserAdminService } from '../user-admin.service';

@Component({
  selector: 'app-deleteuser',
  templateUrl: './deleteuser.component.html',
  styleUrls: ['./deleteuser.component.css']
})
export class DeleteUserComponent implements OnInit {
  
  ngOnInit(): void {}

  @Output() delete = new EventEmitter();
  @Output() cancel = new EventEmitter();
  @Input()  User: any;

  constructor(private usersService: UserAdminService) { }

  deleteConfirmed() {
    console.log("Delete modal delete()");
    console.log(this.User);

    // TODO: Handle an error and display a message in the modal.
    this.usersService.delete(this.User).subscribe(
      response => {
        console.log(response);
        console.log("Saved in modal");
        this.delete.emit(this.User);
      });

  }


  close() {
    console.log("Calling close");
    this.cancel.emit();
  }
}

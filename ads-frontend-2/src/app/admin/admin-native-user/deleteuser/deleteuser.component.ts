import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { UserAdminService } from '../user-admin.service';
import { AdsErrorService } from '../../../common/ads-error.service';

@Component({
  selector: 'app-deleteuser',
  templateUrl: './deleteuser.component.html',
  styleUrls: ['./deleteuser.component.css']
})
export class DeleteUserComponent implements OnInit {
  public errorMessage = "";

  @Output() delete = new EventEmitter();
  @Output() cancel = new EventEmitter();
  @Input() User: any;
  
  constructor(private usersService: UserAdminService, private errorService: AdsErrorService) { }

  ngOnInit(): void { }

  deleteConfirmed() {
    this.usersService.delete(this.User).subscribe(
      response => {
        console.log(response);
        this.delete.emit(this.User);
      },
      err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "deleteNativeUser", "delete");
      }
    );
  }

  close() {
    this.cancel.emit();
  }
}

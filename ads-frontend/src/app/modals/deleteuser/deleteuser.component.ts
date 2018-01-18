import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-deleteuser',
  templateUrl: './deleteuser.component.html',
  styleUrls: ['./deleteuser.component.css']
})
export class DeleteuserComponent implements OnInit {
  ngOnInit(): void {
  }



  @Output() yes = new EventEmitter();
  @Output() cancel = new EventEmitter();
  @Input() User: any;

  constructor() {
  }

  /**
   * This method is to delete user from the table
   * @param
   */

  okay() {
    console.log(this.User);
    this.yes.emit(this.User);
  }
  /**
   * This method is to close the deleteuser modal
   * @param
   */

  close(event) {
    this.cancel.emit(event);
  }
}

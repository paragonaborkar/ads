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



  okay() {
    console.log(this.User);
    this.yes.emit(this.User);
  }

  close(event) {
    this.cancel.emit(event);
  }
}

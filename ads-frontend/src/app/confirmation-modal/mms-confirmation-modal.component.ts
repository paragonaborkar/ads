import {Component, ViewChild, Input, Output, EventEmitter} from "@angular/core";

import { ModalDirective } from 'ngx-bootstrap/modal';
import {MmsConfirmationResponse} from './mms-confirmation-response';

@Component({
  selector: 'confirmation-modal',
  templateUrl: './mms-confirmation-modal.component.html',
})
export class MmsConfirmationModalComponent {
  @ViewChild('confirmationModal') public confirmationModal:ModalDirective;

  @Input() action: string;
  @Input() title?: string;
  @Input() subject: Object;

  @Output() onConfirm: EventEmitter<MmsConfirmationResponse> = new EventEmitter<MmsConfirmationResponse>();
  
  subjectName:string;

  constructor() { }

  
  show(subject: Object, subjectName:string): void {   	
  	this.subject = subject;  	
    this.subjectName = subjectName;

    this.confirmationModal.show();
  }


  hide(confirmed: boolean): void {
  	let confirmResponse:MmsConfirmationResponse = new MmsConfirmationResponse(confirmed, this.action, this.subject)
  	this.onConfirm.emit(confirmResponse);	
    this.confirmationModal.hide();
  }

}
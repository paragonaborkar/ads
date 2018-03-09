import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { ControllerTargetService} from '../controller-target.service';
import { AdsErrorService } from '../../../common/ads-error.service';

@Component({
  selector: 'controller-targets-delete',
  templateUrl: './controller-targets-delete.component.html',
  styleUrls: ['./controller-targets-delete.component.css']
})
export class ControllerTargetsDeleteComponent implements OnInit {
  public errorMessage = "";

  @Output() delete = new EventEmitter();
  @Output() cancel = new EventEmitter();
  @Input() controllerTargetAvailable: any;
  
  constructor(private controllerTargetService: ControllerTargetService, private errorService: AdsErrorService) { }

  ngOnInit(): void { }

  deleteConfirmed() {
    this.controllerTargetService.delete(this.controllerTargetAvailable).subscribe(
      response => {
        console.log(response);
        this.delete.emit(this.controllerTargetAvailable);
      },
      err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "deleteControllerTargetAvailable", "DELETE");
      }
    );
  }

  close() {
    this.cancel.emit();
  }
}

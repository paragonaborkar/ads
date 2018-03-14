import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { ControllerWorkPackageService} from '../controller-work-package.service';
import { AdsErrorService } from '../../../common/ads-error.service';

@Component({
  selector: 'controller-work-package-delete',
  templateUrl: './controller-work-package-delete.component.html',
  styleUrls: ['./controller-work-package-delete.component.css']
})
export class ControllerWorkPackageDeleteComponent implements OnInit {
  public errorMessage = "";

  @Output() delete = new EventEmitter();
  @Output() cancel = new EventEmitter();
  @Input() controllerTargetAvailable: any;
  
  constructor(private controllerWorkPackageService: ControllerWorkPackageService, private errorService: AdsErrorService) { }

  ngOnInit(): void { }

  deleteConfirmed() {
    this.controllerWorkPackageService.delete(this.controllerTargetAvailable).subscribe(
      response => {
        console.log(response);
        this.delete.emit(this.controllerTargetAvailable);
      },
      err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "deleteControllerWorkPackage", "DELETE");
      }
    );
  }

  close() {
    this.cancel.emit();
  }
}

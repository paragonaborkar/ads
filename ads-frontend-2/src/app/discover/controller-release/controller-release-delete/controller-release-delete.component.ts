import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { ControllerReleaseService} from '../controller-release.service';
import { AdsErrorService } from '../../../common/ads-error.service';

@Component({
  selector: 'app-controller-release-delete',
  templateUrl: './controller-release-delete.component.html',
  styleUrls: ['./controller-release-delete.component.scss']
})
export class ControllerReleaseDeleteComponent implements OnInit {

  public errorMessage = "";

  @Output() delete = new EventEmitter();
  @Output() cancel = new EventEmitter();
  @Input() controllerRelease: any;

  constructor(private controllerReleaseService: ControllerReleaseService, private errorService: AdsErrorService) { }

  ngOnInit() {
  }

  deleteConfirmed() {
    this.controllerReleaseService.delete(this.controllerRelease).subscribe(
      response => {
        console.log(response);
        this.delete.emit(this.controllerRelease);
      },
      err => {
        // Get the ADS configured error message to display.
        this.errorMessage = this.errorService.processError(err, "deleteControllerRelease", "DELETE");
      }
    );
  }

  close() {
    this.cancel.emit();
  }

}

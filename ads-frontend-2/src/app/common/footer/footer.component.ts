import { Component, OnInit } from '@angular/core';

import { NGXLogger } from 'ngx-logger';
import { Globals } from '../../globals';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css'],
  providers: [NGXLogger]
})
export class FooterComponent implements OnInit {
  askAQuestionUrl;
  reportAProblemUrl;

  constructor(private logger: NGXLogger, private global: Globals) {
    this.askAQuestionUrl = global.askAQuestionUrl;
    this.reportAProblemUrl = global.reportAProblemUrl;
   }
  
    ngOnInit() {
      
    }
  
    logTest() {
      this.logger.debug('Not logged on server - example log output');
      this.logger.error('Single message string logged on server');
      this.logger.error('Multiple', 'Argument', 'support');
    }
}

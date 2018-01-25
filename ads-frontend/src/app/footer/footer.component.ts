import { Component, OnInit } from '@angular/core';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
  providers: [NGXLogger]
})
export class FooterComponent implements OnInit {

  constructor(private logger: NGXLogger) { }

  ngOnInit() {
  	
  }

  logTest() {
 	  this.logger.debug('Not on server - Your log message goes here');
  	this.logger.error('Pm server = Your log message goes here');
    this.logger.error('Multiple', 'Argument', 'support');
  }

}

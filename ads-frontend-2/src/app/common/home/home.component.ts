import { Component, OnInit } from '@angular/core';
import { Globals } from '../../globals';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  modulesAvailable: any = [];

  constructor(private globals: Globals) {
    
    this.modulesAvailable = globals.appModulesAvailable;
    
    // this.modulesAvailable.connections = true;
    // this.modulesAvailable.discover = true;
    // this.modulesAvailable.execute = false;
    // this.modulesAvailable.planning = false;
    // this.modulesAvailable.reports = false;
    // this.modulesAvailable.schedule = false;
    
      console.log(this.modulesAvailable);
  }

  ngOnInit() {

  }

}

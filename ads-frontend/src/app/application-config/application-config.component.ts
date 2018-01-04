import { Component, OnInit } from '@angular/core';

import { SortableModule } from 'ngx-bootstrap/sortable';

@Component({
  selector: 'app-application-config',
  templateUrl: './application-config.component.html',
  styleUrls: ['./application-config.component.scss']
})
export class ApplicationConfigComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
 public itemObjectsLeft: any[] = [
    { id: 1, name: 'Windstorm', truncateAtChars: 128},
    { id: 2, name: 'Bombasto', truncateAtChars: 50},
    { id: 3, name: 'Magneta', truncateAtChars: 35}
  ];
 
  public itemObjectsRight: any[] = [
    { id: 4, name: 'Tornado', truncateAtChars: 12 },
    { id: 5, name: 'Mr. O', truncateAtChars: 34},
    { id: 6, name: 'Tomato', truncateAtChars: 45}
  ];
}
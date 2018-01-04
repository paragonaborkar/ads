import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  selectedSideBarLink: String;

  onSelect(selectedLink: String): void {
	this.selectedSideBarLink = selectedLink;
  }

}

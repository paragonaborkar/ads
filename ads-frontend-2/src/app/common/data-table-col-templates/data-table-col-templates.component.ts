import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';


@Component({
  selector: 'app-data-table-col-templates',
  templateUrl: './data-table-col-templates.component.html',
  styleUrls: ['./data-table-col-templates.component.scss']
})
export class DataTableColTemplatesComponent implements OnInit {
  @ViewChild('actionHeaderTmpl') actionHeaderTmpl: TemplateRef<any>;
  
  @ViewChild('dateTimeTmpl') dateTimeTmpl: TemplateRef<any>;
  @ViewChild('asIsTmpl') asIsTmpl: TemplateRef<any>;
  @ViewChild('dateTmpl') dateTmpl: TemplateRef<any>;
  @ViewChild('yesNoTmpl') yesNoTmpl: TemplateRef<any>;


  constructor() { }

  ngOnInit() {
  }

  getTemplates() {
    return {
      actionHeaderTmpl: this.actionHeaderTmpl,
      dateTimeTmpl: this.dateTimeTmpl,
      asIsTmpl: this.asIsTmpl,
      dateTmpl: this.dateTmpl,
      yesNoTmpl: this.yesNoTmpl
    };
    
  }

}

import { Component, OnInit } from '@angular/core';
import { SessionHelper } from '../../auth/session.helper';
import { Router, ActivatedRoute } from '@angular/router';
import { QtreesService } from './qtrees-ownership.service';
import { Globals } from '../../globals';

@Component({
  selector: 'app-qtrees-ownership',
  templateUrl: './qtrees-ownership.component.html',
  styleUrls: ['./qtrees-ownership.component.scss']
})
export class QtreesOwnershipComponent implements OnInit {

  constructor(private _sessionHelper: SessionHelper,
              private activatedRoute: ActivatedRoute, 
              private qtreesService: QtreesService, 
              private router: Router,
              private globals: Globals) { }

  ngOnInit() {
    let migKeyQueryParam = (this.activatedRoute.snapshot.queryParams["migKey"]);
    let accessTokenInfo = JSON.parse(sessionStorage.getItem('accessTokenInfo'));
    let userCorporateId = (accessTokenInfo !== undefined && accessTokenInfo !== null) ? accessTokenInfo.corpUserId : null;
    let migKeyLocalStorage = localStorage.getItem('migKey');
    if ((migKeyQueryParam !== null && migKeyQueryParam !== undefined)) {
      localStorage.setItem('migKey', migKeyQueryParam);
      window.location.href = this.globals.apiUrl+'/sso';
    }
    else if (accessTokenInfo!==null) {
      this.qtreesService.isMigKeyExists(migKeyLocalStorage, userCorporateId).subscribe(result => {
        if (!result) {
          alert('Please contact Help Desk');
        }
      },
        error => {
          console.error(error.status);
        }
      );
    } 
    else {
      this.router.navigateByUrl('/');
    }
  }

}





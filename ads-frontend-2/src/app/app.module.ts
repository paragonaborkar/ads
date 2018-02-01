import { NgModule } from '@angular/core';
import { HttpModule, Http } from '@angular/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// Imports
import { BrowserModule } from '@angular/platform-browser';
import { LoggerModule, NgxLoggerLevel } from 'ngx-logger';
import { AppRoutingModule } from './app-routing.module';
import { saveAs as importedSaveAs} from "file-saver";
import { ModalModule } from 'ngx-bootstrap/modal';
import { SortableModule } from 'ngx-bootstrap/sortable';

import { DataTableModule, SharedModule, DropdownModule } from 'primeng/primeng';

import { DataTablesModule } from 'angular-datatables';


import {Ng2SearchTableModule} from "ng2-search-table/ng2-search-table";


// Providers
import {Globals} from './globals';

import { AuthGuard } from './auth/guards/auth-guard.service';
import { SessionHelper } from './auth/session.helper';
import { UserService } from './common/login/user.service';
import { LoginService } from './common/login/login.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './auth/token.interceptor';

import { ReportService } from './admin/report-listing/report.service';   // RENAME TO "admin-."
import { AppPropertiesService } from './common/app-properties/app-properties.service'

import { UserAdminService } from './admin/user-admin/user-admin.service';
import { PagerService } from './common/pager.service';      // Currently used in user admin. Possibly many pages.
import { ApplicationConfigService } from './common/application-config.service';

// Declarations
import { AppComponent } from './app.component';
import { HomeComponent } from './common/home/home.component';
import { LoginComponent } from './common/login/login.component';
import { NavComponent } from './common/nav/nav.component';
import { FooterComponent } from './common/footer/footer.component';
import { ReportListingComponent } from './admin/report-listing/report-listing.component';

import { UserAdminComponent } from './admin/user-admin/user-admin.component';

import { AddUserComponent } from './admin/user-admin/adduser/adduser.component';
import { UpdateUserComponent } from './admin/user-admin/edituser/edituser.component';
import { DeleteUserComponent } from './admin/user-admin/deleteuser/deleteuser.component';
import { PropPreferencesComponent } from './common/prop-preferences/prop-preferences.component';
import { AppPropertiesComponent } from './common/app-properties/app-properties.component';
import { SysConfigPipe } from './common/app-properties/sysconfig.pipe';
/*import { TableSortComponent } from './common/table-sort/table-sort.component';*/



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavComponent,
    ReportListingComponent,
    UserAdminComponent,
    AddUserComponent,
    UpdateUserComponent,
    DeleteUserComponent,

    FooterComponent,

    PropPreferencesComponent,

    AppPropertiesComponent,
    SysConfigPipe,
    

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    DataTableModule,
    DropdownModule,
    SharedModule,
    DataTablesModule,
    Ng2SearchTableModule.forRoot(),
    ModalModule.forRoot(), 
    SortableModule.forRoot(),
    LoggerModule.forRoot({serverLoggingUrl: 'http://localhost:8080/remoteLog', level: NgxLoggerLevel.DEBUG, serverLogLevel: NgxLoggerLevel.ERROR})
  ],
  providers: [Globals, AuthGuard,  SessionHelper, UserService, LoginService,
    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true},
    ReportService,
    UserAdminService,
    PagerService,
    ApplicationConfigService,
    AppPropertiesService
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }

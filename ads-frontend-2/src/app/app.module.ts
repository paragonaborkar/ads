import { NgModule } from '@angular/core';
// import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// Imports
import { BrowserModule } from '@angular/platform-browser';
import { LoggerModule, NgxLoggerLevel } from 'ngx-logger';
import { AppRoutingModule } from './app-routing.module';
import { saveAs as importedSaveAs} from "file-saver";

// NGX Modules: https://valor-software.com/ngx-bootstrap/#/getting-started
import { ModalModule } from 'ngx-bootstrap/modal';
import { SortableModule } from 'ngx-bootstrap/sortable';
import { TypeaheadModule } from 'ngx-bootstrap/typeahead';

//  Data Table
import { DataTablesModule } from 'angular-datatables';

import { Ng2SearchTableModule } from "ng2-search-table/ng2-search-table";
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';

// Providers
import {Globals} from './globals';
import { AdsHelperService } from './common/ads-helper.service';
import { AdsErrorService } from './common/ads-error.service';

import { AuthGuard } from './auth/guards/auth-guard.service';
import { SessionHelper } from './auth/session.helper';
import { UserService } from './common/login/user.service';
import { LoginService } from './common/login/login.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './auth/token.interceptor';

import { ReportService } from './admin/report-listing/report.service';   // RENAME TO "admin-."

import { AppPropsService } from './admin/app-props/app-props.service';


import { UserAdminService } from './admin/admin-native-user/user-admin.service';
import { PagerService } from './common/pager.service';      // Currently used in user admin. Possibly many pages.
import { ApplicationConfigService } from './common/application-config.service';

import { OwnerService } from './discover/owner.service';
import { ControllerReleaseService } from './discover/controller-release/controller-release.service';
import { ControllerTargetService } from './discover/controller-targets/controller-target.service';
import { ControllerTypeaheadService } from './discover/controller-typeahead/controller-typeahead.service';


// Declarations
import { AppComponent } from './app.component';
import { HomeComponent } from './common/home/home.component';
import { LoginComponent } from './common/login/login.component';
import { NavComponent } from './common/nav/nav.component';
import { FooterComponent } from './common/footer/footer.component';
import { ReportListingComponent } from './admin/report-listing/report-listing.component';

// import { UserAdminComponent } from './admin/user-admin/user-admin.component';

import { NativeUserCreateComponent } from './admin/admin-native-user/native-user-create/native-user-create.component';
import { NativeUserUpdateComponent } from './admin/admin-native-user/native-user-update/native-user-update.component';
import { NativeUserDeleteComponent } from './admin/admin-native-user/native-user-delete/native-user-delete.component';
import { AdminManualFunctionsComponent } from './admin/admin-manual-functions/admin-manual-functions.component';
import { PropPreferencesComponent } from './common/prop-preferences/prop-preferences.component';
import { PropPreferencesModalComponent } from './common/prop-preferences-modal/prop-preferences-modal.component';

import { ArrayFilterPipePipe } from './pipes/array-filter-pipe.pipe';
import { YesNoPipe } from './pipes/yes-no-pipe.pipe';

import { ConnectionsManualFunctionsComponent } from './connections/connections-manual-functions/connections-manual-functions.component';
import { DiscoverManualFunctionsComponent } from './discover/discover-manual-functions/discover-manual-functions.component';
import { FriendlyLabelPipePipe } from './pipes/friendly-label-pipe.pipe';
import { AdminNativeUserComponent } from './admin/admin-native-user/admin-native-user.component';

import { QtreesOwnershipComponent } from './discover/qtrees-ownership/qtrees-ownership.component';
import { QtreesService } from './discover/qtrees-ownership/qtrees-ownership.service';

import { OwnerComponent } from './discover/owner/owner.component';
import { OwnerNotFoundComponent } from './discover/owner-not-found/owner-not-found.component';
import { ScheduleComponent } from './discover/owner/schedule/schedule.component';
import { ReportListingDisComponent } from './discover/report-listing-dis/report-listing-dis.component';

import { ReportListingConnComponent } from './connections/report-listing-conn/report-listing-conn.component';
import { AppPropsComponent } from './admin/app-props/app-props.component';
import { Error404Component } from './error-404/error-404.component';
import { ControllerReleaseComponent } from './discover/controller-release/controller-release.component';
import { ControllerReleaseCreateComponent } from './discover/controller-release/controller-release-create/controller-release-create.component';
import { ControllerTypeaheadComponent } from './discover/controller-typeahead/controller-typeahead.component';
import { ControllerTargetsComponent } from './discover/controller-targets/controller-targets.component';
import { ControllerTargetsCreateComponent } from './discover/controller-targets/controller-targets-create/controller-targets-create.component';
import { SaveMessageTimerComponent } from './common/save-message-timer/save-message-timer.component';
import { DataTableColTemplatesComponent } from './common/data-table-col-templates/data-table-col-templates.component';

import { ControllerTargetsDeleteComponent } from './discover/controller-targets/controller-targets-delete/controller-targets-delete.component';

/*import { TableSortComponent } from './common/table-sort/table-sort.component';*/


@NgModule({
  declarations: [
    // ADS Foundational
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavComponent,
    FooterComponent,

    SaveMessageTimerComponent,
    DataTableColTemplatesComponent,

    // ADS Adminstration & Settings
    ReportListingComponent,
    NativeUserCreateComponent,
    NativeUserUpdateComponent,
    NativeUserDeleteComponent,
    AdminManualFunctionsComponent,
    PropPreferencesComponent,
    PropPreferencesModalComponent,
    
    // Pipes
    ArrayFilterPipePipe,
    FriendlyLabelPipePipe,
    YesNoPipe,

    // Host Connections
    ConnectionsManualFunctionsComponent,


    // Discovery
    DiscoverManualFunctionsComponent,
    AdminNativeUserComponent,

    QtreesOwnershipComponent,

    OwnerComponent,
    OwnerNotFoundComponent,
    ScheduleComponent,
    ReportListingDisComponent,
    ReportListingConnComponent,
    AppPropsComponent,
    Error404Component,
    ControllerReleaseComponent,
    ControllerReleaseCreateComponent,
    
    ControllerTypeaheadComponent,

    ControllerTargetsComponent,
    ControllerTargetsCreateComponent,
    ControllerTargetsDeleteComponent

    

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    DataTablesModule,
    NgxDatatableModule,
    TypeaheadModule.forRoot(),
    Ng2SearchTableModule.forRoot(),
    ModalModule.forRoot(), 
    SortableModule.forRoot(),
    BsDatepickerModule.forRoot(),
    LoggerModule.forRoot({serverLoggingUrl: 'http://localhost:8080/remoteLog', level: NgxLoggerLevel.DEBUG, serverLogLevel: NgxLoggerLevel.ERROR})
  ],
  providers: [Globals, AuthGuard,  SessionHelper, UserService, LoginService, AdsHelperService, AdsErrorService, 
    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true},
    ReportService,
    UserAdminService,
    PagerService,
    ApplicationConfigService,
    AppPropsService,

    QtreesService,
    OwnerService,
    ControllerReleaseService,
    ControllerTargetService,
    ControllerTypeaheadService

    ],
  bootstrap: [AppComponent]
})
export class AppModule { }

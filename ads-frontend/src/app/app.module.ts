import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule, Http } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';
import { AuthConfig, AuthHttp, tokenNotExpired, AUTH_PROVIDERS, provideAuth } from 'angular2-jwt';

import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './core/token.interceptor'; // rename core to auth

import { UserService } from './login/user.service';
import { LoginService } from './login/login.service';
// import { ACCESS_TOKEN_NAME } from './login/auth.constant';
import { AuthGuard } from './guards/auth-guard.service';
import { TokenService } from './token.service';

import { saveAs as importedSaveAs } from 'file-saver';

import { ModalModule } from 'ngx-bootstrap/modal';
import { DatepickerModule } from 'ngx-bootstrap/datepicker';
import { PopoverModule } from 'ngx-bootstrap';
import { SortableModule } from 'ngx-bootstrap/sortable';

import { SessionHelper } from './core/session.helper';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { FooterComponent } from './footer/footer.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ReportListingComponent } from './report-listing/report-listing.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { LoggerModule, NgxLoggerLevel } from 'ngx-logger';

// TODO: Need to server correct 404 or 500 page depending on User's session.
import { Error404LoggedInComponent } from './error-404-logged-in/error-404-logged-in.component';
import { Error404LoggedOutComponent } from './error-404-logged-out/error-404-logged-out.component';
import { Error500LoggedInComponent } from './error-500-logged-in/error-500-logged-in.component';
import { Error500LoggedOutComponent } from './error-500-logged-out/error-500-logged-out.component';

import { MigrationProjectService } from './migration-project.service';
import { VolumeOwersServiceService } from './volume-owners/volume-owers-service.service';
import { OwnersOfAVolumeService } from './volume-owners/schedule-volume-modal/owners-of-a-volume.service';
import { ProjectsService } from './assign-mig-specialist/projects.service';

import { MmsMigrationProjectComponent } from './mms-migration-project/mms-migration-project.component';
import { MmsConfirmationModalComponent } from './confirmation-modal/mms-confirmation-modal.component';
import { VolumeOwnersComponent } from './volume-owners/volume-owners.component';
import { ScheduleVolumeModalComponent } from './volume-owners/schedule-volume-modal/schedule-volume-modal.component';
import { DataCenterSummaryComponent } from './data-center-summary/data-center-summary.component';
import { DataCenterDetailsComponent } from './data-center-details/data-center-details.component';
import { ReplicationPatternComponent } from './replication-pattern/replication-pattern.component';
import { ManualFunctionsComponent } from './manual-functions/manual-functions.component';
import { WfaMgmtComponent } from './wfa-mgmt/wfa-mgmt.component';
import { MigExecutionComponent } from './mig-execution/mig-execution.component';
import { AssignMigSpecialistComponent } from './assign-mig-specialist/assign-mig-specialist.component';
import { StorageXComponent } from './storage-x/storage-x.component';
import { ApplicationPropertiesComponent } from './application-properties/application-properties.component';
import { WorkPackagesComponent } from './work-packages/work-packages.component';
import { OperationalOverrideComponent } from './operational-override/operational-override.component';
import { BatchReleaseComponent } from './batch-release/batch-release.component';
import { ServerAdminReferenceComponent } from './server-admin-reference/server-admin-reference.component';
import { UserAdminComponent } from './user-admin/user-admin.component';
import { ApplicationConfigComponent } from './application-config/application-config.component';
import { HomeComponent } from './home/home.component';
import { ReportService } from './report-listing/report.service';
import { LoginComponent } from './login/login.component';
import { AdduserComponent } from './modals/adduser/adduser.component';
import { UserAdminService } from './user-admin.service';
import { EdituserComponent } from './modals/edituser/edituser.component';
import { DeleteuserComponent } from './modals/deleteuser/deleteuser.component';
import { PagerService } from './pager.service';


import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DataTableModule, SharedModule } from 'primeng/primeng';
import { PaginatorModule } from 'primeng/primeng';

import { ApplicationConfigService } from './services/application-config.service';

import {Globals} from './globals';

export function authHttpServiceFactory(http: Http, globals: Globals) {
  return new AuthHttp(new AuthConfig({
    headerPrefix: 'Bearer',
    tokenName: globals.ACCESS_TOKEN_NAME,
    globalHeaders: [{ 'Content-Type': 'application/json' }],
    noJwtError: false,
    noTokenScheme: true,
    tokenGetter: (() => sessionStorage.getItem(globals.ACCESS_TOKEN_NAME))
  }), http);
}
@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    SidebarComponent,

    /* Error Section */
    Error404LoggedInComponent,
    Error404LoggedOutComponent,
    Error500LoggedInComponent,
    Error500LoggedOutComponent,

    /* MMS App Common and Reusable Section */
    MmsConfirmationModalComponent,

    /* MMS App Components */
    MmsMigrationProjectComponent,
    ReportListingComponent,
    VolumeOwnersComponent,
    ScheduleVolumeModalComponent,
    DataCenterSummaryComponent,
    DataCenterDetailsComponent,
    ReplicationPatternComponent,
    ManualFunctionsComponent,
    WfaMgmtComponent,
    MigExecutionComponent,
    AssignMigSpecialistComponent,
    StorageXComponent,
    ApplicationPropertiesComponent,
    WorkPackagesComponent,
    OperationalOverrideComponent,
    BatchReleaseComponent,
    ServerAdminReferenceComponent,
    UserAdminComponent,
    ApplicationConfigComponent,
    HomeComponent,
    LoginComponent,
    AdduserComponent,
    EdituserComponent,
    DeleteuserComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AppRoutingModule,
    ModalModule.forRoot(),
    DatepickerModule.forRoot(),
    PopoverModule.forRoot(),
    SortableModule.forRoot(),
    NgxPaginationModule,
    BrowserAnimationsModule,
    DataTableModule,
    SharedModule,
    PaginatorModule,
    LoggerModule.forRoot({serverLoggingUrl: 'http://localhost:8080/remoteLog', level: NgxLoggerLevel.DEBUG, serverLogLevel: NgxLoggerLevel.ERROR})
  ],
  providers: [
    { provide: AuthHttp, useFactory: authHttpServiceFactory, deps: [Http] },
    SessionHelper,
    MigrationProjectService,
    VolumeOwersServiceService,
    OwnersOfAVolumeService,
    ProjectsService,
    ReportService,
    LoginService,
    UserService,
    UserAdminService,
    PagerService,
    AuthGuard,
    ApplicationConfigService,
    TokenService,
    Globals,
    { 
        provide: HTTP_INTERCEPTORS,
        useClass: TokenInterceptor,
        multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }


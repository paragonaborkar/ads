import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// Imports
import { BrowserModule } from '@angular/platform-browser';
import { LoggerModule, NgxLoggerLevel } from 'ngx-logger';
import { AppRoutingModule } from './app-routing.module';
import { saveAs as importedSaveAs} from "file-saver";
import { ModalModule } from 'ngx-bootstrap/modal';
import { SortableModule } from 'ngx-bootstrap/sortable';

import { DataTablesModule } from 'angular-datatables';

import { Ng2SearchTableModule } from "ng2-search-table/ng2-search-table";
import { NgxDatatableModule } from '@swimlane/ngx-datatable';

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
import { AppPropertiesService } from './admin/app-properties/app-properties.service'

import { UserAdminService } from './admin/admin-native-user/user-admin.service';
import { PagerService } from './common/pager.service';      // Currently used in user admin. Possibly many pages.
import { ApplicationConfigService } from './common/application-config.service';

import { OwnerService } from './discover/owner.service';

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

import { PropPreferencesComponent } from './common/prop-preferences/prop-preferences.component';
import { PropPreferencesModalComponent } from './common/prop-preferences-modal/prop-preferences-modal.component';

import { AppPropertiesComponent } from './admin/app-properties/app-properties.component';
import { ArrayFilterPipePipe } from './pipes/array-filter-pipe.pipe';

import { ConnectionsManualFunctionsComponent } from './connections/connections-manual-functions/connections-manual-functions.component';
import { DiscoverManualFunctionsComponent } from './discover/discover-manual-functions/discover-manual-functions.component';
import { FriendlyLabelPipePipe } from './pipes/friendly-label-pipe.pipe';
import { AdminNativeUserComponent } from './admin/admin-native-user/admin-native-user.component';

import { QtreesOwnershipComponent } from './discover/qtrees-ownership/qtrees-ownership.component';
import { QtreesService } from './discover/qtrees-ownership/qtrees-ownership.service';

import { OwnerComponent } from './discover/owner/owner.component';
import { OwnerNotFoundComponent } from './discover/owner-not-found/owner-not-found.component';

/*import { TableSortComponent } from './common/table-sort/table-sort.component';*/


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavComponent,
    ReportListingComponent,
    // UserAdminComponent,
    NativeUserCreateComponent,
    NativeUserUpdateComponent,
    NativeUserDeleteComponent,
    FooterComponent,
    PropPreferencesComponent,
    PropPreferencesModalComponent,
    AppPropertiesComponent,
    ArrayFilterPipePipe,
    FriendlyLabelPipePipe,
    ConnectionsManualFunctionsComponent,
    DiscoverManualFunctionsComponent,
    AdminNativeUserComponent,

    QtreesOwnershipComponent

    OwnerComponent,
    OwnerNotFoundComponent

    

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    DataTablesModule,
    NgxDatatableModule,
    Ng2SearchTableModule.forRoot(),
    ModalModule.forRoot(), 
    SortableModule.forRoot(),
    LoggerModule.forRoot({serverLoggingUrl: 'http://localhost:8080/remoteLog', level: NgxLoggerLevel.DEBUG, serverLogLevel: NgxLoggerLevel.ERROR})
  ],
  providers: [Globals, AuthGuard,  SessionHelper, UserService, LoginService, AdsHelperService, AdsErrorService, 
    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true},
    ReportService,
    UserAdminService,
    PagerService,
    ApplicationConfigService,
    AppPropertiesService,

    QtreesService

    OwnerService

    ],
  bootstrap: [AppComponent]
})
export class AppModule { }

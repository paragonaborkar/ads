import { NgModule }             from '@angular/core';
import { RouterModule, Routes, PreloadAllModules } from '@angular/router';

import { AuthGuard } from './auth/guards/auth-guard.service';

import { HomeComponent } from './common/home/home.component';
import { LoginComponent } from './common/login/login.component';
import { ReportListingComponent } from './admin/report-listing/report-listing.component';
// import { UserAdminComponent } from './admin/user-admin/user-admin.component';
import { PropPreferencesComponent } from './common/prop-preferences/prop-preferences.component';
import { AppPropertiesComponent } from './admin/app-properties/app-properties.component';

import { ConnectionsManualFunctionsComponent } from './connections/connections-manual-functions/connections-manual-functions.component';
import { DiscoverManualFunctionsComponent } from './discover/discover-manual-functions/discover-manual-functions.component';
import { AdminNativeUserComponent } from './admin/admin-native-user/admin-native-user.component';
import { QtreesOwnershipComponent } from './discover/qtrees-ownership/qtrees-ownership.component';


import { OwnerComponent } from './discover/owner/owner.component';
import { OwnerNotFoundComponent } from './discover/owner-not-found/owner-not-found.component';
import { ReportListingDisComponent } from './discover/report-listing-dis/report-listing-dis.component';
import { ReportListingConnComponent } from './connections/report-listing-conn/report-listing-conn.component';

import { AppPropsComponent } from './admin/app-props/app-props.component';

// import { Error404LoggedInComponent } from './common/error-404-logged-in/error-404-logged-in.component';

const routes: Routes = [
  //{ path: '', redirectTo: '/', pathMatch: 'full' },
  { path: 'login',  component: LoginComponent },
   
  {path: 'admin/native-user-mgmt', component: AdminNativeUserComponent, canActivate: [AuthGuard] },

  { path: 'home',  component: HomeComponent, canActivate: [AuthGuard] },
 
  { path: 'admin/report-listing',  component: ReportListingComponent, canActivate: [AuthGuard] },
  // { path: 'admin/native-user-mgmt',  component: UserAdminComponent, canActivate: [AuthGuard] },
  { path: 'admin/property-preferences',  component: PropPreferencesComponent, canActivate: [AuthGuard] },
  { path: 'admin/application-properties',  component: AppPropertiesComponent, canActivate: [AuthGuard] },

  { path: 'admin/application-props',  component: AppPropsComponent, canActivate: [AuthGuard] },

  { path: 'connections/manual-function',  component: ConnectionsManualFunctionsComponent, canActivate: [AuthGuard] },
  { path: 'connections/report-listing',  component: ReportListingConnComponent, canActivate: [AuthGuard] },

  
  { path: 'discover/manual-function',  component: DiscoverManualFunctionsComponent, canActivate: [AuthGuard] },

  { path: 'discover/qtrees-ownership',  component: QtreesOwnershipComponent },
  { path: 'discover/owner',  component: OwnerNotFoundComponent, canActivate: [AuthGuard] },
  { path: 'discover/owner/:migKey',  component: OwnerComponent, canActivate: [AuthGuard] },
 
  { path: 'discover/report-listing',  component: ReportListingDisComponent, canActivate: [AuthGuard] },
  

  { path: '',   component: LoginComponent},


  // Error paths
//   { path: '404', component: Error404LoggedInComponent},
  { path: '**', redirectTo: '/404'}

];

@NgModule({
  imports: [ RouterModule.forRoot(routes, {preloadingStrategy: PreloadAllModules}) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}

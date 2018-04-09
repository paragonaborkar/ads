import { NgModule }             from '@angular/core';
import { RouterModule, Routes, PreloadAllModules } from '@angular/router';

import { AuthGuard } from './auth/guards/auth-guard.service';
import { RoleGuard } from './auth/guards/role-guard.service';

import { HomeComponent } from './common/home/home.component';
import { LoginComponent } from './common/login/login.component';
import { PropPreferencesComponent } from './common/prop-preferences/prop-preferences.component';

import { ReportListingComponent } from './admin/report-listing/report-listing.component';
// import { UserAdminComponent } from './admin/user-admin/user-admin.component';


import { AdminManualFunctionsComponent } from './admin/admin-manual-functions/admin-manual-functions.component';
import { AdminNativeUserComponent } from './admin/admin-native-user/admin-native-user.component';
import { OperationalOverrideComponent } from './admin/operational-override/operational-override.component';
import { AppPropsComponent } from './admin/app-props/app-props.component';

import { ConnectionsManualFunctionsComponent } from './connections/connections-manual-functions/connections-manual-functions.component';
import { ReportListingConnComponent } from './connections/report-listing-conn/report-listing-conn.component';


import { DiscoverManualFunctionsComponent } from './discover/discover-manual-functions/discover-manual-functions.component';
import { OwnerComponent } from './discover/owner/owner.component';
import { OwnerNotFoundComponent } from './discover/owner-not-found/owner-not-found.component';
import { ReportListingDisComponent } from './discover/report-listing-dis/report-listing-dis.component';
import { ControllerReleaseComponent } from './discover/controller-release/controller-release.component';
import { ControllerWorkPackageCreateComponent } from './discover/controller-work-package/controller-work-package-create/controller-work-package-create.component';


import { Error404Component } from './error-404/error-404.component';

import { ControllerWorkPackageComponent } from './discover/controller-work-package/controller-work-package.component';
import { OwnerHomeComponent } from './common/owner-home/owner-home.component';


// import { Error404LoggedInComponent } from './common/error-404-logged-in/error-404-logged-in.component';

const routes: Routes = [
  //{ path: '', redirectTo: '/', pathMatch: 'full' },
  
  { path: 'login',  component: LoginComponent },
   
  { path: 'admin/admin-user-mgmt', component: AdminNativeUserComponent, canActivate: [AuthGuard] },
  { path: 'index',  component: OwnerHomeComponent, canActivate: [AuthGuard] },
  
 
  { path: 'admin/report-listing',  component: ReportListingComponent, canActivate: [AuthGuard] },
  // { path: 'admin/native-user-mgmt',  component: UserAdminComponent, canActivate: [AuthGuard] },
  { path: 'admin/property-preferences',  component: PropPreferencesComponent, canActivate: [AuthGuard] },
  { path: 'admin/application-properties',  component: AppPropsComponent, canActivate: [AuthGuard] },
  { path: 'admin/manual-functions',  component: AdminManualFunctionsComponent, canActivate: [AuthGuard] },
  { path: 'admin/operational-override',  component: OperationalOverrideComponent, canActivate: [AuthGuard] },
  

  { path: 'connections/manual-functions',  component: ConnectionsManualFunctionsComponent, canActivate: [AuthGuard] },
  { path: 'connections/report-listing',  component: ReportListingConnComponent, canActivate: [AuthGuard] },

  
  { path: 'discover/manual-functions',  component: DiscoverManualFunctionsComponent, canActivate: [AuthGuard] },

  { path: 'home',  component: HomeComponent, canActivate: [AuthGuard], data: {expectedRole: 'ROLE_USER'}  },
  { path: 'owner',  component: OwnerNotFoundComponent, canActivate: [RoleGuard], data: {expectedRole: 'ROLE_USER'}  },
  { path: 'discover/owner/:migKey',  component: OwnerComponent, canActivate:  [RoleGuard], data: {expectedRole: 'ROLE_USER'}  },
  { path: 'owner/:migKey',  component: OwnerComponent, canActivate:  [RoleGuard], data: {expectedRole: 'ROLE_USER'}  },

  
  { path: 'discover/controller-release',  component: ControllerReleaseComponent, canActivate: [AuthGuard] },
  { path: 'discover/report-listing',  component: ReportListingDisComponent, canActivate: [AuthGuard] },
  { path: 'discover/controller-target',  component: ControllerWorkPackageComponent, canActivate: [AuthGuard] },
  


  

  { path: '',   component: LoginComponent},


  // Error paths
  { path: '404', component:Error404Component},
  { path: '**', redirectTo: '/404'}

];

@NgModule({
  imports: [ RouterModule.forRoot(routes, {preloadingStrategy: PreloadAllModules}) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}

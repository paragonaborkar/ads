import { NgModule }             from '@angular/core';
import { RouterModule, Routes, PreloadAllModules } from '@angular/router';

import { AuthGuard } from './auth/guards/auth-guard.service';

import { HomeComponent } from './common/home/home.component';
import { LoginComponent } from './common/login/login.component';
import { ReportListingComponent } from './admin/report-listing/report-listing.component';
import { UserAdminComponent } from './admin/user-admin/user-admin.component';
import { PropPreferencesComponent } from './common/prop-preferences/prop-preferences.component';
import { AppPropertiesComponent } from './common/app-properties/app-properties.component';


// import { Error404LoggedInComponent } from './common/error-404-logged-in/error-404-logged-in.component';

const routes: Routes = [
  //{ path: '', redirectTo: '/', pathMatch: 'full' },
  { path: 'login',  component: LoginComponent },

  { path: 'home',  component: HomeComponent, canActivate: [AuthGuard] },
 
  { path: 'admin/report-listing',  component: ReportListingComponent, canActivate: [AuthGuard] },
  { path: 'admin/native-user-mgmt',  component: UserAdminComponent, canActivate: [AuthGuard] },
  { path: 'admin/property-preferences',  component: PropPreferencesComponent, canActivate: [AuthGuard] },
  { path: 'admin/application-properties',  component: AppPropertiesComponent, canActivate: [AuthGuard] },
 
  
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

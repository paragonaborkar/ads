import { NgModule }             from '@angular/core';
import { RouterModule, Routes, PreloadAllModules } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ReportListingComponent }  from './report-listing/report-listing.component';
import { MmsMigrationProjectComponent } from './mms-migration-project/mms-migration-project.component';
import { VolumeOwnersComponent } from './volume-owners/volume-owners.component';
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
import {AuthGuard} from './guards/auth-guard.service';



import { Error404LoggedInComponent } from './error-404-logged-in/error-404-logged-in.component';

const routes: Routes = [
  //{ path: '', redirectTo: '/', pathMatch: 'full' },


  { path: 'home',  component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'login',  component: LoginComponent },
  { path: 'migration-project',  component: MmsMigrationProjectComponent, canActivate: [AuthGuard] },
  { path: 'report-listing',     component: ReportListingComponent, canActivate: [AuthGuard] },
  { path: 'volume-owners',      component: VolumeOwnersComponent, canActivate: [AuthGuard]},
  { path: 'data-center-summary',   component: DataCenterSummaryComponent, canActivate: [AuthGuard] },
  { path: 'data-center-detail',    component: DataCenterDetailsComponent , canActivate: [AuthGuard]},
  { path: 'replication-pattern',   component: ReplicationPatternComponent, canActivate: [AuthGuard]},
  { path: 'manual-functions',   component: ManualFunctionsComponent, canActivate: [AuthGuard]},
  { path: 'wfa-mgmt',   component: WfaMgmtComponent, canActivate: [AuthGuard]},
  { path: 'migration-execution',   component: MigExecutionComponent, canActivate: [AuthGuard]},
  { path: 'assign-migration-specialist',   component: AssignMigSpecialistComponent, canActivate: [AuthGuard]},
  { path: 'storage-x',   component: StorageXComponent, canActivate: [AuthGuard]},
  { path: 'application-properties',   component: ApplicationPropertiesComponent, canActivate: [AuthGuard]},
  { path: 'application-config',   component: ApplicationConfigComponent, canActivate: [AuthGuard]},


  { path: 'work-packages',   component: WorkPackagesComponent, canActivate: [AuthGuard]},
  { path: 'operational-override',   component: OperationalOverrideComponent, canActivate: [AuthGuard]},
  { path: 'batch-release',   component: BatchReleaseComponent, canActivate: [AuthGuard]},
  { path: 'server-admin-reference',   component: ServerAdminReferenceComponent, canActivate: [AuthGuard]},
  { path: 'user-admin',   component: UserAdminComponent, /*canActivate: [AuthGuard] */},
  { path: '',   component: LoginComponent},


  // Error paths
  { path: '404', component: Error404LoggedInComponent},
  { path: '**', redirectTo: '/404'}

];

@NgModule({
  imports: [ RouterModule.forRoot(routes, {preloadingStrategy: PreloadAllModules}) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}

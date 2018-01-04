import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
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



import { Error404LoggedInComponent } from './error-404-logged-in/error-404-logged-in.component';

const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },


  { path: '',  component: HomeComponent },
  { path: 'migration-project',  component: MmsMigrationProjectComponent },
  { path: 'report-listing',     component: ReportListingComponent },
  { path: 'volume-owners',      component: VolumeOwnersComponent },
  { path: 'data-center-summary',   component: DataCenterSummaryComponent },
  { path: 'data-center-detail',    component: DataCenterDetailsComponent },
  { path: 'replication-pattern',   component: ReplicationPatternComponent},
  { path: 'manual-functions',   component: ManualFunctionsComponent},
  { path: 'wfa-mgmt',   component: WfaMgmtComponent},
  { path: 'migration-execution',   component: MigExecutionComponent},
  { path: 'assign-migration-specialist',   component: AssignMigSpecialistComponent},
  { path: 'storage-x',   component: StorageXComponent}, 
  { path: 'application-properties',   component: ApplicationPropertiesComponent}, 
  { path: 'application-config',   component: ApplicationConfigComponent}, 


  { path: 'work-packages',   component: WorkPackagesComponent}, 
  { path: 'operational-override',   component: OperationalOverrideComponent}, 
  { path: 'batch-release',   component: BatchReleaseComponent}, 
  { path: 'server-admin-reference',   component: ServerAdminReferenceComponent}, 
  { path: 'user-admin',   component: UserAdminComponent}, 


  // Error paths
  { path: '404', component: Error404LoggedInComponent},
  { path: '**', redirectTo: '/404'}

];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}

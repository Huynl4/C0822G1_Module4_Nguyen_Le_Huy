import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ManageComponent} from "./manage/manage.component";


const routes: Routes = [
  {path: '', component: ManageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

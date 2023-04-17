import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {QrcoceComponent} from "./qrcoce/qrcoce.component";


const routes: Routes = [
  {path: '', component: QrcoceComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

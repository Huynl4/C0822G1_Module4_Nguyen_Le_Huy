import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SanBongComponent} from "./sanbong/san-bong/san-bong.component";
import {CreateComponent} from "./sanbong/create/create.component";


const routes: Routes = [
  {path:'',component:SanBongComponent},
  {path: 'create', component: CreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BodyComponent} from './home/body/body.component';
import {HomeRoutingModule} from './home/home-routing.module';
import {LoginComponent} from './log-in/login/login.component';
import {DetailComponent} from './home/detail/detail.component';
import {ListSearchComponent} from './list-search/list-search/list-search.component';


const routes: Routes = [
  {path: '', component: BodyComponent},
  {path: 'login', component: LoginComponent},
  {path: 'detail/:id', component: DetailComponent},
  {path: 'listSearch',component:ListSearchComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShareddRoutingModule } from './sharedd-routing.module';
import { NavBarComponent } from './nav-bar/nav-bar.component';


@NgModule({
  declarations: [NavBarComponent],
  imports: [
    CommonModule,
    ShareddRoutingModule
  ]
})
export class ShareddModule { }

import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {HomeRoutingModule} from './home-routing.module';
import {BodyComponent} from './body/body.component';
import {AppModule} from "../app.module";
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from './footer/footer.component';


@NgModule({
  declarations: [
    BodyComponent,
    HeaderComponent,
    FooterComponent
  ],
  exports: [
    BodyComponent,
    HeaderComponent,
    FooterComponent

  ],
  imports: [
    CommonModule,
    HomeRoutingModule,

  ]
})
export class HomeModule {
}

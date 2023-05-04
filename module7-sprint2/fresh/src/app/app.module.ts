import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HomeModule} from "./home/home.module";
import {LogInModule} from "./log-in/log-in.module";
import {HttpClientModule} from '@angular/common/http';
import { ListSearchComponent } from './list-search/list-search/list-search.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ListSearchComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HomeModule,
        LogInModule,
        HttpClientModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

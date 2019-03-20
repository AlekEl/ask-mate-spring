import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from "@angular/common/http";
import { FormsModule} from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { QuestionListComponent } from './question-list/question-list.component';
import { NavbarComponent } from './navbar/navbar.component';
import { QuestionEditComponent } from './question-edit/question-edit.component';
import { QuestionViewComponent } from './question-view/question-view.component';

@NgModule({
  declarations: [
    AppComponent,
    QuestionListComponent,
    NavbarComponent,
    QuestionEditComponent,
    QuestionViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

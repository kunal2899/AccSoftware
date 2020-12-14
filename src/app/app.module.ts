import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MyNavComponent } from './my-nav/my-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { ExpcatComponent } from './expcat/expcat.component';
import { IncatComponent } from './incat/incat.component';
import { ExpenseComponent } from './expense/expense.component';
import { IncomeComponent } from './income/income.component';
import { CashbComponent } from './cashb/cashb.component';
import { BankbComponent } from './bankb/bankb.component';
import { DaybComponent } from './dayb/dayb.component';
import { BsheetComponent } from './bsheet/bsheet.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ToDashGuard } from './to-dash.guard';
import { UserService } from './user.service';
import { NotPermittedComponent } from './not-permitted/not-permitted.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpIntercepterBasicAuthService } from './services/http/http-intercepter-basic-auth.service';
import { HomeComponent } from './home/home.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { NgxPaginationModule } from 'ngx-pagination';
import { ExpiredComponent } from './expired/expired.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MyNavComponent,
    ExpcatComponent,
    IncatComponent,
    ExpenseComponent,
    IncomeComponent,
    CashbComponent,
    BankbComponent,
    DaybComponent,
    BsheetComponent,
    PageNotFoundComponent,
    NotPermittedComponent,
    UpdateProfileComponent,
    HomeComponent,
    ExpiredComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatTableModule,
    MatPaginatorModule,
    NgxPaginationModule
  ],
  providers: [
    ToDashGuard,
    UserService,
    { provide: HTTP_INTERCEPTORS, useClass: HttpIntercepterBasicAuthService, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

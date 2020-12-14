import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MyNavComponent } from './my-nav/my-nav.component';
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
import { NotPermittedComponent } from './not-permitted/not-permitted.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  { path: '', redirectTo: '/log-reg', pathMatch: 'full' },
  { path: 'log-reg', component: LoginComponent },
  { path: 'dashboard', component: MyNavComponent,
    canActivate: [ToDashGuard],
    children:[
      { path: 'home', component: HomeComponent },
      { path: 'update-profile', component: UpdateProfileComponent },
      { path: 'expenses-cat', component: ExpcatComponent },
      { path: 'expenses-cat/:id', component: ExpcatComponent },
      { path: 'income-cat', component: IncatComponent },
      { path: 'expenses', component: ExpenseComponent },
      { path: 'income', component: IncomeComponent },
      { path: 'cash-book', component: CashbComponent },
      { path: 'bank-book', component: BankbComponent },
      { path: 'day-book', component: DaybComponent },
      { path: 'bal-sheet', component: BsheetComponent }
    ]
  },
  { path: 'forbidden' , component: NotPermittedComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

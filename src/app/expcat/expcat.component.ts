import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ExpCatService } from '../services/ecat/exp-cat.service';
import { UserService } from '../user.service';

export class ExpenseCategories {

  constructor(
    public id: number,
    public name: string,
    public details: string,
    public userId: number
  ) { }

  public getExpenseCategoryId(): number {
    return this.id;
  }
  public getExpenseCategoryName(): string {
    return this.name;
  }
  public getExpenseCategoryDetails(): string {
    return this.details;
  }
  public getUserId(): number {
    return this.userId;
  }
}

@Component({
  selector: 'app-expcat',
  templateUrl: './expcat.component.html',
  styleUrls: ['./expcat.component.css']
})
export class ExpcatComponent implements OnInit {

  message: string;
  details: ExpenseCategories[];
  expenseCategory: ExpenseCategories;

  totalRecords:number;
  page:number = 1
  items:number = 3

  anyof:boolean

  constructor(
    private service: ExpCatService,
    private us: UserService,
    private router:Router
  ) {
    this.expenseCategory = new ExpenseCategories(0, '', '', this.us.getAuthenticatedUserId());
  }

  refreshAllCategories() {
    this.service.findAllExpenseCategoriesByUserId(this.us.getAuthenticatedUserId()).subscribe(
      response => {
        this.details = response;
        this.totalRecords = this.details.length
        this.anyof = (this.totalRecords != 0)?true:false;
      },
      error => {
        console.log(error)
      }
    );
  }

  ngOnInit(): void {
    this.refreshAllCategories();
  }

  

  untouch(form) {
    Object.keys(form.controls).forEach(key => {
      form.get(key).markAsUntouched();
    });
  }
  addExpenseCategory(ecat_id) {
    if (ecat_id === 0) {
      this.service.addExpenseCategory(this.expenseCategory).subscribe(
        response => {
          this.refreshAllCategories();
          this.message = "New Expense Category added successfully";
          this.expenseCategory = new ExpenseCategories(0, '', '', this.us.getAuthenticatedUserId());
        }
      );
      setTimeout(() => this.message = '', 3000);
    }
    else {
      this.service.updateExpenseCategory(this.expenseCategory).subscribe(
        response => {
          this.refreshAllCategories();
          this.message = "Expense Category updated successfully";
          this.expenseCategory = new ExpenseCategories(0, '', '', this.us.getAuthenticatedUserId());
        }
      );
      setTimeout(() => this.message = '', 3000);
    }
  }

  removeExpenseCategory(expcat_id, name) {
    let cnfrm = confirm("Are you sure to delete this expense category? Changes are not revertible.");
    if (cnfrm) {
      this.service.removeExpenseCategory(expcat_id).subscribe(
        response => {
          this.refreshAllCategories();
          this.message = 'Expense Category named "' + name + '" is removed successfully';
        }
      );
      setTimeout(() => this.message = '', 3000);
    }
  }

  updateExpenseCategory(ecat_id: number, ecat_name, ecat_details) {
    this.expenseCategory = new ExpenseCategories(ecat_id, ecat_name, ecat_details, this.us.getAuthenticatedUserId());
  }

}

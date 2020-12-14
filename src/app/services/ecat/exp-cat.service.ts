import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ExpenseCategories } from 'src/app/expcat/expcat.component';
import { APP_URL } from 'src/app.constants';


@Injectable({
  providedIn: 'root'
})
export class ExpCatService {

  constructor(private http: HttpClient) { }

  findAllExpenseCategories(){
    return this.http.get<ExpenseCategories[]>(`${APP_URL}/expense-cat`);
  }

  findAllExpenseCategoriesByUserId(uid){
    return this.http.get<ExpenseCategories[]>(`${APP_URL}/users/${uid}/expense-cat`);
  }

  findExpenseCategory(ecid){
    return this.http.get<ExpenseCategories>(`${APP_URL}/expense-cat/${ecid}`);
  }

  addExpenseCategory(ec){
    return this.http.post(`${APP_URL}/expense-cat`,ec);
  }

  updateExpenseCategory(ec){
    return this.http.put<ExpenseCategories>(`${APP_URL}/expense-cat`,ec);
  }

  removeExpenseCategory(ecid){
    return this.http.delete<String>(`${APP_URL}/expense-cat/${ecid}`);
  }
}

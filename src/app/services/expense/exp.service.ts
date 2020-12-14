import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL, CORS_HEADERS } from 'src/app.constants';
import { Expenses } from 'src/app/expense/expense.component';

@Injectable({
  providedIn: 'root'
})
export class ExpService {

  

  constructor(private http:HttpClient) { }

  findAllExpenses(){
    return this.http.get<Expenses[]>(`${APP_URL}/expenses`);
  }

  findExpenseById(id:number){
    return this.http.get<Expenses>(`${APP_URL}/expenses/${id}`)
  }

  public addExpense(e:Expenses){
    return this.http.post(`${APP_URL}/expenses`,e,CORS_HEADERS);
  }

  updateExpense(e:Expenses){
    return this.http.put<Expenses>(`${APP_URL}/expenses`,e);
  }

  removeExpense(id:number){
    return this.http.delete(`${APP_URL}/expenses/${id}`);
  }
}

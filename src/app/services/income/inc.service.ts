import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL, CORS_HEADERS } from 'src/app.constants';
import { Income } from 'src/app/income/income.component';

@Injectable({
  providedIn: 'root'
})
export class IncService {

  constructor(private http:HttpClient) { }

  findAllIncomes(){
    return this.http.get<Income[]>(`${APP_URL}/incomes`,CORS_HEADERS)
  }

  findByRange(uid,start:Date,end:Date){
    return this.http.get<Income[]>(`${APP_URL}/${uid}/incomes/${start}/${end}`)
  }

  findIncome(id){
    return this.http.get<Income>(`${APP_URL}/incomes/${id}`)
  }

  addIncome(inc){
    return this.http.post(`${APP_URL}/incomes`,inc,CORS_HEADERS)
  }

  updateIncome(inc){
    return this.http.put<Income>(`${APP_URL}/incomes`,inc,CORS_HEADERS)
  }

  removeIncome(id){
    return this.http.delete(`${APP_URL}/incomes/${id}`)
  }
}

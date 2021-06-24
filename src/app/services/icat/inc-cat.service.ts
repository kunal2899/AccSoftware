import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL , CORS_HEADERS } from 'src/app.constants';
import { IncomeCategories } from 'src/app/incat/incat.component';

@Injectable({
  providedIn: 'root'
})
export class IncCatService {

  constructor(private http:HttpClient) { }

  findAllIncomeCategories(){
    return this.http.get<IncomeCategories[]>(`${APP_URL}/income-cat`)
  }

  findAllIncomeCategoriesByUserId(uid){
    return this.http.get<IncomeCategories[]>(`${APP_URL}/users/${uid}/income-cat`,CORS_HEADERS)
  }

  findIncomeCategory(id){
    return this.http.get<IncomeCategories>(`${APP_URL}/income-cat/${id}`)
  }

  addIncomeCategory(ic){
    return this.http.post(`${APP_URL}/income-cat`,ic,CORS_HEADERS)
  }

  updateIncomeCategory(ic){
    return this.http.put<IncomeCategories>(`${APP_URL}/income-cat`,ic)
  }

  removeIncomeCategory(id){
    return this.http.delete<String>(`${APP_URL}/income-cat/${id}`)
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';
import { CashBook } from 'src/app/cashb/cashb.component';

@Injectable({
  providedIn: 'root'
})
export class CashBookService {

  constructor(private http:HttpClient) { }

  findAllinRange(uid,start:Date,end:Date){
    return this.http.get<CashBook[]>(`${APP_URL}/${uid}/cash-book/${start}/${end}`)
  }

  getCbal(uid,start:Date,end:Date){
    return this.http.get<number>(`${APP_URL}/${uid}/cash-book/cbal/${start}/${end}`)
  }
}

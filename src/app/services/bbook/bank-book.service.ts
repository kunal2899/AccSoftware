import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';
import { BankBook } from 'src/app/bankb/bankb.component';

@Injectable({
  providedIn: 'root'
})
export class BankBookService {

  constructor(private http:HttpClient) { }

  findAllinRange(uid,start:Date,end:Date){
    return this.http.get<BankBook[]>(`${APP_URL}/${uid}/bank-book/${start}/${end}`)
  }

  getCbal(uid,start:Date,end:Date){
    return this.http.get<number>(`${APP_URL}/${uid}/bank-book/cbal/${start}/${end}`)
  }
}

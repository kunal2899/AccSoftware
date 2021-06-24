import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { ExpenseCategories } from '../expcat/expcat.component';
import { ExpCatService } from '../services/ecat/exp-cat.service';
import { ExpService } from '../services/expense/exp.service';
import { UserService } from '../user.service';

export class Expenses {
  constructor(
    public id:number,
    public name:string,
    public amount:number,
    public payby:string,
    public remark:string,
    public date:Date,
    public expCatId:number,
    public userId:number
  ){}

  public getId(){
    return this.id;
  }

  public setAmount(amt){
    this.amount = amt;
  }

  public getName(){
    return this.name;
  }  

  public getAmount(){
    return this.amount;
  }

  public getPayBy(){
    return this.payby;
  }

  public getRemark(){
    return this.remark;
  }

  public getDate(){
    return this.date;
  }

  public getEcId(){
    return this.expCatId;
  }

  public getUserId(){
    return this.userId;
  }

}

@Component({
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrls: ['./expense.component.css']
})
export class ExpenseComponent implements OnInit {

  category: ExpenseCategories[];
  message:string;
  err:string;
  expense:Expenses;
  anyof:boolean
  config: Partial<BsDatepickerConfig>;

  constructor(private service:ExpCatService, private us:UserService, private es:ExpService) { 
    let now = new Date()
    this.expense = new Expenses(0,'',0,'Cash','',now,0,us.getAuthenticatedUserId());
    this.config = Object.assign({},{ containerClass : 'theme-dark-blue', showWeekNumbers: false,
      dateInputFormat: 'DD-MM-YYYY' });
  }

  ngOnInit(): void {
    this.service.findAllExpenseCategoriesByUserId(this.us.getAuthenticatedUserId()).subscribe(
      response => {
        this.category = response
        this.anyof = (this.category.length != 0)?true:false

      },
      error=>{
        console.log(error)
      }
    );
  }

  public paymodes = ['Cash','Bank'];
  catHasError = false;
  pbHasError = true;

  untouch(form) {
    Object.keys(form.controls).forEach(key => {
      form.get(key).markAsUntouched();
    });
  }

  addExpense(form:FormGroup){
    if(form.valid){
     
      this.catHasError = false

      console.log(this.expense.date);
      
      this.es.addExpense(this.expense).subscribe(
        response => {
          console.log(response)
          this.message = 'New Expense named "' + this.expense.getName() + '" added successfully!'
          let now = new Date()
          this.expense = new Expenses(0,'',0,'Cash','',now,0,this.us.getAuthenticatedUserId());
        },
        error => {
          console.log(error)
          this.err = "Server facing issues right now, Try to adding later."
          let now = new Date()
          this.expense = new Expenses(0,'',0,'Cash','',now,0,this.us.getAuthenticatedUserId());
        }
      );
      
      setTimeout(()=>this.message = '',3000);
      setTimeout(()=>this.err = '',3000);
    }
    else{
      form.markAllAsTouched();
      form.get('payby').markAsUntouched()
      this.catHasError = true
    }
    
  }

  public validateCat(n){
    let flag = 0;
    for(let i in this.category){
      if((n == this.category[i].id)){
        flag = 1;
        this.catHasError = false;
      }
    }
    if(flag == 0){
      this.catHasError = true;
    }
  }
  public validatePB(n){
    for(let i in this.paymodes){
      if((n === this.paymodes[i])){
        this.pbHasError = false;
        break;
      }
      else{
        this.pbHasError = true;
      }
    }
  }
}

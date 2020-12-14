import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { $ } from 'protractor';
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
    public dat:Date,
    public ecId:number,
    public uid:number
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
    return this.dat;
  }

  public getEcId(){
    return this.ecId;
  }

  public getUserId(){
    return this.uid;
  }

}

@Component({
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrls: ['./expense.component.css']
})
export class ExpenseComponent implements OnInit {

  constructor(private service:ExpCatService, private us:UserService, private es:ExpService) { 
    // this.expense = new Expenses(0,'',"amount",'Cash','',new Date(),0,us.getAuthenticatedUserId());
    // let dt = new Date().toLocaleDateString("fr-CA");
    // let dt = new Date()
    // var datepipe = new DatePipe("en-US");
    //   let formatted = datepipe.transform(dt,"yyyy-MM-dd");
    //   alert(new Date(formatted))
    this.expense = new Expenses(0,'',0,'Cash','',new Date(),0,us.getAuthenticatedUserId());
  }

  category: ExpenseCategories[];
  message:string;
  err:string;
  expense:Expenses;

  ngOnInit(): void {
    this.service.findAllExpenseCategoriesByUserId(this.us.getAuthenticatedUserId()).subscribe(
      response => {
        this.category = response;
      }
    );
  }

  public paymodes = ['Cash','Cheque'];
  catHasError = false;
  pbHasError = true;

  untouch(form) {
    Object.keys(form.controls).forEach(key => {
      form.get(key).markAsUntouched();
    });
  }

  addExpense(form:FormGroup){
    if(form.valid){
      var datepipe = new DatePipe("en-US");
      let formatted = datepipe.transform(this.expense.dat,"MM/dd/yyyy");
      alert(formatted)
      this.expense.dat = new Date(formatted)
      this.catHasError = false
      this.es.addExpense(this.expense).subscribe(
        response => {
          console.log(response)
          this.message = 'New Expense named "' + this.expense.getName() + '" added successfully!'
        },
        error => {
          console.log(error)
          this.err = "Server facing issues right now, Try to adding later."
          this.expense = new Expenses(0,'',0,'Cash','',new Date(),0,this.us.getAuthenticatedUserId());
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

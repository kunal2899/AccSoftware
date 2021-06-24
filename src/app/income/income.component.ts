import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { IncomeCategories } from '../incat/incat.component';
import { IncCatService } from '../services/icat/inc-cat.service';
import { IncService } from '../services/income/inc.service';
import { UserService } from '../user.service';

export class Income{
  constructor(
    public id:number,
    public name:string,
    public amount:number,
    public recieveby:string,
    public remark:string,
    public date:Date,
    public incCatId:number,
    public userId:number
  ){}
}

@Component({
  selector: 'app-income',
  templateUrl: './income.component.html',
  styleUrls: ['./income.component.css']
})
export class IncomeComponent implements OnInit {

  category: IncomeCategories[];
  message:string;
  err:string;
  income:Income;
  anyof:boolean;
  config: Partial<BsDatepickerConfig>;

  constructor(private service:IncService, private us:UserService, private ics:IncCatService) { 
    let now = new Date()
    this.income = new Income(0,'',0,'Cash','',now,0,us.getAuthenticatedUserId())
    this.config = Object.assign({},{ containerClass : 'theme-dark-blue', showWeekNumbers: false,
      dateInputFormat: 'DD-MM-YYYY' });
  }

  ngOnInit(): void {
    this.ics.findAllIncomeCategoriesByUserId(this.us.getAuthenticatedUserId()).subscribe(
      response=>{
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

  addIncome(form:FormGroup){
    if(form.valid){
      this.catHasError = false
      
      this.service.addIncome(this.income).subscribe(
        response => {
          console.log(response)
          this.message = 'New Income named "' + this.income.name + '" added successfully!'
          let now = new Date()
          this.income = new Income(0,'',0,'Cash','',now,0,this.us.getAuthenticatedUserId());
        },
        error => {
          console.log(error)
          this.err = "Server facing issues right now, Try to adding later."
          let now = new Date()
          this.income = new Income(0,'',0,'Cash','',now,0,this.us.getAuthenticatedUserId());
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

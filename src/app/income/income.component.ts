import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-income',
  templateUrl: './income.component.html',
  styleUrls: ['./income.component.css']
})
export class IncomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  public category = ['Pay','Recieve'];
  public paymodes = ['Cash','Cheque'];
  catHasError = true;
  pbHasError = true;

  public validateCat(n){
    if(!(n === 'Pay' || n === 'Recieve')){
      this.catHasError = true;
    } else{
      this.catHasError = false;
    }
  }
  public validatePB(n){
    if(!(n === 'Cash' || n === 'Cheque')){
      this.pbHasError = true;
    } else{
      this.pbHasError = false;
    }
  }

}

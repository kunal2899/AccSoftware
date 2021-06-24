import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { CashBookService } from '../services/cbook/cash-book.service';
import { ExpService } from '../services/expense/exp.service';
import { IncService } from '../services/income/inc.service';
import { UserService } from '../user.service';


export class CashBook{
  constructor(
    public id:number,
    public date:Date,
    public amount:number,
    public mode:string
  ){}
}

@Component({
  selector: 'app-cashb',
  templateUrl: './cashb.component.html',
  styleUrls: ['./cashb.component.css']
})
export class CashbComponent implements OnInit {

  config: Partial<BsDatepickerConfig>;

  constructor(private cb:CashBookService, private es:ExpService, private is:IncService, private us:UserService) {
    this.config = Object.assign({},{ containerClass : 'theme-dark-blue', showWeekNumbers: false,
    dateInputFormat: 'DD-MM-YYYY' });
  }

  bal = 0
  result_fetched = false;
  s: Date
  e: Date
  result = []
  totalRecords: number;
  page: number = 1
  items: number = 5
  anyrec

  ngOnInit(): void {

  }

  show(form) {
    if (form.valid) {
      let start, end
      this.page = 1
      start = this.s.getFullYear() + '-' + (this.s.getMonth()+1) + '-' + this.s.getDate()
      end = this.e.getFullYear() + '-' +(this.e.getMonth()+1) + '-' + this.e.getDate()
      $('.find').css('margin-bottom',0);
      $('.find .control').addClass("additional").removeClass("control")
      $('.find .control label').css('margin-left', '20px')
      this.cb.findAllinRange(this.us.getAuthenticatedUserId(),start,end).subscribe(
        response => {
          this.result = response
          this.result_fetched = true
          this.totalRecords = this.result.length
          this.anyrec = (this.totalRecords > 0) ? true : false
          this.result.forEach(x => {
            x.date = x.date.split('T')[0]
            x.date = x.date.split('-')[2] + '-' + x.date.split('-')[1] + '-' + x.date.split('-')[0]
          })
        }
      )
      this.cb.getCbal(this.us.getAuthenticatedUserId(),start,end).subscribe(
        response => {
          this.bal = response
        }
      )
    } else {
      this.result_fetched = false;
    }
  }

}

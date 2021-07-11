import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { ExpService } from '../services/expense/exp.service';
import { IncService } from '../services/income/inc.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-bsheet',
  templateUrl: './bsheet.component.html',
  styleUrls: ['./bsheet.component.css']
})
export class BsheetComponent implements OnInit {

  config: Partial<BsDatepickerConfig>;
  constructor(
    private es:ExpService,
    private is:IncService,
    private us:UserService
  ) {
      this.config = Object.assign({},{ containerClass : 'theme-dark-blue', showWeekNumbers: false,
      dateInputFormat: 'DD-MM-YYYY' });
   }

  result_fetched = false;
  s: Date
  e: Date
  exp = []
  inc = []
  totalExp: number
  totalInc: number
  epage: number = 1
  ipage: number = 1
  items: number = 3
  anyexp
  anyinc
  anyrec
  total_exp:number = 0
  total_inc:number = 0

  ngOnInit(): void {
  }

  nloaded = false

  show(form) {
    if (form.valid) {
      this.nloaded = true
      let start, end
      this.epage = 1
      this.ipage = 1
      start = this.s.getFullYear() + '-' + (this.s.getMonth()+1) + '-' + this.s.getDate()
      end = this.e.getFullYear() + '-' + (this.e.getMonth()+1) + '-' + this.e.getDate()
      $('.find').css('margin-bottom',0);
      $('.find .control').addClass("additional").removeClass("control")
      $('.find .control label').css('margin-left', '20px')
      this.es.findByRange(this.us.getAuthenticatedUserId(),start,end).subscribe(
        response => {
          this.nloaded = false
          this.exp = response
          this.result_fetched = true
          this.totalExp = this.exp.length
          this.anyexp = (this.totalExp > 0)?true:false
          this.exp.forEach(x => {
            let d = new Date(x.date);
            let pipe = new DatePipe("en-US").transform(d,"dd-MM-yyyy",'+0530')
            x.date = pipe
            // x.date = x.date.split('T')[0]
            // x.date = x.date.split('-')[2] + '-' + x.date.split('-')[1] + '-' + x.date.split('-')[0]
            this.total_exp += x.amount
          })
        },
        error => {
          console.log(error)
        }
      )
      this.is.findByRange(this.us.getAuthenticatedUserId(),start,end).subscribe(
        response => {
          this.inc = response
          this.result_fetched = true
          this.totalInc = this.inc.length
          this.anyinc = (this.totalInc > 0)?true:false
          this.inc.forEach(x => {
            // x.date = x.date.split('T')[0]
            // x.date = x.date.split('-')[2] + '-' + x.date.split('-')[1] + '-' + x.date.split('-')[0]
            let d = new Date(x.date);
            let pipe = new DatePipe("en-US").transform(d,"dd-MM-yyyy",'+0530')
            x.date = pipe
            this.total_inc += x.amount
          })
        },
        error => {
          console.log(error)
        }
      )
    } else {
      this.result_fetched = false;
    }
  }

}

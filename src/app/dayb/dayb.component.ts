import { Component, OnInit } from '@angular/core';
import { ExpService } from '../services/expense/exp.service';
import { IncService } from '../services/income/inc.service';
import { UserService } from '../user.service';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';

@Component({
  selector: 'app-dayb',
  templateUrl: './dayb.component.html',
  styleUrls: ['./dayb.component.css']
})
export class DaybComponent implements OnInit {

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
  items: number = 5
  anyexp
  anyinc
  anyrec

  ngOnInit(): void {
  }

  toggles(n){
    if(n=='i'){
      $('.result').css('overflow','visible');
      $('.result').css('transform','translateX(-100%)');
      // $('.navigation .inc').css('opacity',0);
      // $('.navigation .exp').css('opacity',1);
    } 
    if(n=='e'){
      $('.result').css('transform','translateX(0%)');
      setTimeout(()=>{
        $('.result').css('overflow','hidden');
      },1000)
      // $('.navigation .exp').css('opacity',0);
      // $('.navigation .inc').css('opacity',1);
    }
  }

  show(form) {
    if (form.valid) {
      let start, end
      this.epage = 1
      this.ipage = 1
      start = this.s.getFullYear() + '-' + this.s.getMonth()+1 + '-' + this.s.getDate()
      end = this.e.getFullYear() + '-' + this.e.getMonth()+1 + '-' + this.e.getDate()
      $('.find').css('margin-bottom',0);
      $('.find .control').addClass("additional").removeClass("control")
      $('.find .control label').css('margin-left', '20px')
      this.es.findByRange(this.us.getAuthenticatedUserId(),start,end).subscribe(
        response => {
          this.exp = response
          this.result_fetched = true
          this.totalExp = this.exp.length
          this.anyexp = (this.totalExp > 0)?true:false
          this.exp.forEach(x => {
            x.date = x.date.split('T')[0]
            x.date = x.date.split('-')[2] + '-' + x.date.split('-')[1] + '-' + x.date.split('-')[0]
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
            x.date = x.date.split('T')[0]
            x.date = x.date.split('-')[2] + '-' + x.date.split('-')[1] + '-' + x.date.split('-')[0]
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

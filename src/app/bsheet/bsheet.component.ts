import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bsheet',
  templateUrl: './bsheet.component.html',
  styleUrls: ['./bsheet.component.css']
})
export class BsheetComponent implements OnInit {

  constructor() { }

  total_inc = 10000;
  total_exp = 500;
  gp = this.total_inc - this.total_exp;

  ngOnInit(): void {
  }

}

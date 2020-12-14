import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cashb',
  templateUrl: './cashb.component.html',
  styleUrls: ['./cashb.component.css']
})
export class CashbComponent implements OnInit {

  constructor() { }

  bal = 567;

  ngOnInit(): void {
  }

}

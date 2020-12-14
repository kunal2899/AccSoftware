import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bankb',
  templateUrl: './bankb.component.html',
  styleUrls: ['./bankb.component.css']
})
export class BankbComponent implements OnInit {

  constructor() { }

  bal= 567;

  ngOnInit(): void {
  }

}

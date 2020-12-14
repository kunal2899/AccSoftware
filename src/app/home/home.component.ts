import { useAnimation } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { User } from '../user';
import { AUTHENTICATED_USER, UserService } from '../user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private us:UserService) { }

  name:string = '';
  u = this.us.findUserByUsername(sessionStorage.getItem(AUTHENTICATED_USER)).subscribe(
    data => {
      console.log(data);
      this.name = data.name.toUpperCase().split(' ')[0];
    },
    error => {
      console.log(error);
    }
  )

  ngOnInit(): void {
    $('.qlinks .part h3 a').click(function(){
      setTimeout(function(){
        location.reload();
      },1000);
    });
  }

}

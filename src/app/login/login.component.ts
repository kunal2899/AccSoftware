import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../user';
import { FormGroup } from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  u:User = new User(0,'kj','kj','9999999999','kj@gmail.com','kj','Kunal2000@',true);
  // u = new User(0,'','','','','','');

  username:string = '';
  password:string = '';
  invalidCredentials:boolean;
  isempty:boolean;
  invalidu:boolean;
  invalidp:boolean;
  serror:boolean;


  constructor(private us:UserService, private router:Router) { 
    this.invalidCredentials = false;
    this.isempty = false;
    this.invalidu = false;
    this.invalidp = false;
    this.serror = false;
  }

  signIn(form:FormGroup) {
    if(form.valid){
      this.us.authenticate(this.username,this.password).subscribe(
        data => {
          console.log(data);
          this.router.navigate(['dashboard/home']);
        },
        error => {
          console.log(error);
          this.invalidCredentials = true;
        }
      )
    }
    else{
      form.markAllAsTouched()
    }
  }

  signup(form:FormGroup){
    if(form.valid){
      this.us.addUser(this.u).subscribe(
        response => {
          alert("Your account is created, please login to continue.");
          location.reload()
        },
        error => {
          console.log(error);
          this.serror = true;
        }
      )
    }
    else{
      form.markAllAsTouched()
    }
  }

  ngOnInit(): void {
    $('.container #show-reg').on('click', function () {
      $('.log').css('display', 'none');
      $('.reg').fadeIn(500);
    });
    $('.container #show-log').on('click', function () {
      $('.reg').css('display', 'none');
      $('.log').fadeIn(500);
    });
    $('.pass input').on('focus', function () {
      $(this).css('margin-left','15px');
      $('#eye').show();
    });
    $('.pass input').on('blur', function () {
      $('#eye').hide();
      $(this).css('margin-left','0px');
    });
    $('#eye').on('mouseover',function(){
      $('.pass input').attr('type','text');
    });
    $('#eye').on('mouseout',function(){
      $('.pass input').attr('type','password');
    });
  }
}

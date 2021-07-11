import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import * as $ from 'jquery';
import { User } from '../user';
var tocheck:boolean = false
import { AUTHENTICATED_USER, UserService } from '../user.service';

export class UpdateDTO{
  constructor(
    public id: number,
    public name: string,
    public address: string,
    public mobile: string,
    public email: string,
    public username: string,
    public curr_password: string,
    public new_password: string,
    public entered_password: string
){ }
} 

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {
  @ViewChild('cpwd',{static:true}) cp:FormControl
  user:User
  pass = ''
  currpass = ''
  ud:UpdateDTO
  emsg = ''
  smsg = ''

  constructor(private us:UserService) { }

  edit(n){
    let e = document.getElementsByName(n)[0]
    $(e).removeAttr('readonly')
    $(e).trigger('focus')
    $(e).siblings('i').hide()
  }

  loadUser(){
    this.us.findUserByUsername(sessionStorage.getItem(AUTHENTICATED_USER)).subscribe(
      data => {
        this.user = data
      }
    );
  }

  update(f:FormGroup){
    if(f.valid){
      if(tocheck && this.pass != ''){
        this.ud = new UpdateDTO(this.user.id,this.user.name,this.user.address,
          this.user.mobile,this.user.email,this.user.username,this.user.password,this.pass,this.currpass);
      }
      else{
        this.ud = new UpdateDTO(this.user.id,this.user.name,this.user.address,
          this.user.mobile,this.user.email,this.user.username,this.user.password,this.currpass,this.currpass);
      }
      this.us.updateUser(this.ud).subscribe(
        response=>{
            this.loadUser()
            this.currpass = ''
            this.pass = ''
            f.get('cpwd').markAsUntouched()
            $('input').each(function(x,e){
              $(e).attr('readonly','true')
              $(e).siblings('i').show()
            })
            $('#newp').removeAttr('readonly')
            $('#cpwd').removeAttr('readonly')
            this.smsg = 'Your profile is updated.'
            setTimeout(()=>{this.smsg=''},3000)
        },
        error=>{
          if(error.error == "Password is incorrect"){
            this.currpass = ''
            this.pass = ''
            $('input').each(function(x,e){
              $(e).attr('readonly','true')
              $(e).siblings('i').show()
            })
            $('#newp').removeAttr('readonly')
            $('#cpwd').removeAttr('readonly')
            f.get('cpwd').markAsUntouched()
            this.emsg = 'Incorrect Password'
            setTimeout(()=>{this.emsg=''},3000)
          }
        }
      )
    }
  }

  ngOnInit(): void {

      this.loadUser()

      $('#qw').on('click',function(){
        $('.newpass').toggle(500);
        $('#nohere').toggle();
        $('#here').toggle();
        if($(this).is(':checked')){
          $('#newp').attr('required','true');
          tocheck = true
          $('#newp').attr('aria-required','true');
          $('#newp').attr('ng-reflect-required','required');
        }
        else{
          $('#newp').removeAttr('required');
          tocheck = false
          $('#newp').attr('aria-required','false');
          $('#newp').attr('ng-reflect-required','false');
        }
        
      });
  }

}

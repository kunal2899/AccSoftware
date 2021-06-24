import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { User } from '../user';
import { AUTHENTICATED_USER, UserService } from '../user.service';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {

  user:User

  constructor(private us:UserService) { }


  ngOnInit(): void {
    $(document).ready(function(){
      $('#qw').click(function(){
        $('.newpass').toggle(500);
        $('#nohere').toggle();
        $('#here').toggle();
        if($(this).is(':checked'))
          $('#newp').attr('required','true');
        else
          $('#newp').attr('required','false');
      });
    });

    this.us.findUserByUsername(sessionStorage.getItem(AUTHENTICATED_USER)).subscribe(
      data => {
        this.user = data
      }
    );
  }

}

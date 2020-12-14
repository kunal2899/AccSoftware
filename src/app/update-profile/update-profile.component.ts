import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {

  constructor() { }

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
  }

}

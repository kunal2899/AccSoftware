import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import * as $ from 'jquery';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-nav',
  templateUrl: './my-nav.component.html',
  styleUrls: ['./my-nav.component.css']
})
export class MyNavComponent {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver,private us:UserService, private router:Router) { }

      logout(){
        if(confirm("Are you sure for logout?")){
          this.us.logout();
          this.router.navigate(['log-reg']);
        }
      }


  ngOnInit(): void {
    $(document).ready(function () {
      $('mat-nav-list a').on('click',function(){
        $(this).addClass('menu-active').siblings().removeClass('menu-active');
        $('.sel a').each(function(){
          $(this).removeClass('link-active').siblings().removeClass('link-active');
        });
      });

      $('.sel a').on('click',function(){
          $(this).addClass('link-active').siblings().removeClass('link-active');
          $('mat-nav-list a').each(function(){
            $(this).removeClass('menu-active').siblings().removeClass('menu-active');
          });
      });
      var path = window.location.href;
      $('mat-nav-list a').each(function(){
        if(this.href === path){
          $(this).addClass('menu-active').siblings().removeClass('menu-active');
        }
      });
      $('.sel a').each(function(){
        if(this.href === path){
          $(this).addClass('link-active').siblings().removeClass('link-active');
        }
      });
    });

  }

}

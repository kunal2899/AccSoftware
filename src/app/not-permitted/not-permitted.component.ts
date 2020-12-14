import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-not-permitted',
  templateUrl: './not-permitted.component.html',
  styleUrls: ['./not-permitted.component.css']
})
export class NotPermittedComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {

    var container = document.getElementById('cont');
    window.onmousemove = function(e){
      var x = -e.clientX/5, y = -e.clientY/5;
      container.style.backgroundPositionX = x + 'px';
      container.style.backgroundPositionY = y + 'px';
    }

  }

}

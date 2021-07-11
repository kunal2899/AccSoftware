import { Component, OnInit } from '@angular/core';
import { IncCatService } from '../services/icat/inc-cat.service';
import { UserService } from '../user.service';

export class IncomeCategories{
  constructor(
    public id: number,
    public name: string,
    public details: string,
    public userId: number
  ){}

  getId(){
    return this.id;
  }
  getName(){
    return this.name;
  }
  getDetails(){
    return this.details;
  }
}

@Component({
  selector: 'app-incat',
  templateUrl: './incat.component.html',
  styleUrls: ['./incat.component.css']
})
export class IncatComponent implements OnInit {

  message: string;
  details:IncomeCategories[];
  incomeCategory:IncomeCategories;
  totalRecords:number;
  page:number = 1
  items:number = 3
  anyof:boolean;

  constructor(
    private service:IncCatService,
    private us:UserService
    ) {
      this.incomeCategory = new IncomeCategories(0,'','',this.us.getAuthenticatedUserId())
     }

  nloaded = false;


  refreshAllCategories() {
    this.nloaded = true;
    this.service.findAllIncomeCategoriesByUserId(this.us.getAuthenticatedUserId()).subscribe(
      response => {
        this.nloaded = false;
        this.details = response;
        this.totalRecords = this.details.length
        this.anyof = (this.totalRecords != 0)?true:false
      },
      error => {
        this.nloaded = false;
        console.log(error)
      }
    );
  }

  ngOnInit(): void {
    this.refreshAllCategories();
  }

  untouch(form) {
    Object.keys(form.controls).forEach(key => {
      form.get(key).markAsUntouched();
    });
  }

  addIncomeCategory(id){
    if(id === 0){
      this.service.addIncomeCategory(this.incomeCategory).subscribe(
        response=>{
          this.refreshAllCategories()
          this.message = 'New Income Category added successfully'
          this.incomeCategory = new IncomeCategories(0,'','',this.us.getAuthenticatedUserId())
        },
        error=>{
          console.log(error)
        }
      );
      setTimeout(()=> this.message = '',3000);
    } else{
      this.service.updateIncomeCategory(this.incomeCategory).subscribe(
        response=>{
          this.refreshAllCategories()
          this.message = 'Income Category updated successfully'
          this.incomeCategory = new IncomeCategories(0,'','',this.us.getAuthenticatedUserId())
        },
        error=>{
          console.log(error)
        }
      );
      setTimeout(()=> this.message = '',3000);
    }
  }

  removeIncomeCategory(id,name){
    let cnfrm = confirm("Are you sure to delete this income category? Changes are not revertible.");
    if(cnfrm){
      this.service.removeIncomeCategory(id).subscribe(
        response=>{
          this.refreshAllCategories()
          this.message = 'Income category named "'+name+'" is removed successfully';
        },
        error=>{
          console.log(error)
        }
      );
      setTimeout(() => this.message = '', 3000);
    }
  }

  update(id,name,details){
    this.incomeCategory = new IncomeCategories(id,name,details,this.us.getAuthenticatedUserId())
  }

}

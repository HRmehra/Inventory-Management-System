import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { AdUserService } from 'src/app/services/ad-user.service';


@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {
  users: User[] = []

  constructor(private service: AdUserService) { }

  ngOnInit(): void {

    this.service.viewUser().subscribe(
      (data: User[]) => {
        this.users = data;
      })
  }

  delete(i){
    this.service.delUser(i).subscribe(
      data => {
        this.ngOnInit();
      console.log("deleted",data);
      }
    )
  }

}

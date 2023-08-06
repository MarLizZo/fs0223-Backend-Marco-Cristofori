import { Component } from '@angular/core';
import { Subscription, catchError, map } from 'rxjs';
import { IUser } from 'src/app/interfaces/iuser';
import { GestionaleService } from 'src/app/services/gestionale.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss'],
})
export class UsersComponent {
  usersArr: IUser[] = [];
  sub!: Subscription;

  constructor(private svc: GestionaleService) {}

  ngOnInit() {
    this.sub = this.svc
      .getAllUsers()
      .pipe(
        map((res) => {
          this.usersArr = res.content;
        }),
        catchError((errorM) => {
          throw errorM;
        })
      )
      .subscribe();
  }

  ngOnDestroy() {
    if (this.sub) this.sub.unsubscribe();
  }

  deleteUser(user: IUser) {
    this.svc
      .deleteUser(user)
      .pipe(
        map((res) => {
          console.log(res);
          this.usersArr.splice(
            this.usersArr.findIndex((el) => el.id == user.id),
            1
          );
        })
      )
      .subscribe();
  }
}

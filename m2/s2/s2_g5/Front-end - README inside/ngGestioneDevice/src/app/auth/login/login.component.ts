import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription, catchError, tap } from 'rxjs';
import { ILoginData } from 'src/app/interfaces/ilogin-data';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  message: String = '';
  data: ILoginData = {
    username: '',
    password: '',
  };
  logSub!: Subscription;

  constructor(private svc: AuthService, private router: Router) {}

  ngOnDestroy() {
    if (this.logSub) this.logSub.unsubscribe();
  }

  login() {
    this.logSub = this.svc
      .login(this.data)
      .pipe(
        tap((res) => {
          this.message =
            'Benvenuto, ' +
            res.username +
            ' ** redirect alla home in 2 secondi..';
          localStorage.setItem('user', JSON.stringify(res));
          setTimeout(() => {
            this.router.navigate(['/']);
          }, 2000);
        }),
        catchError((errorM) => {
          this.message = '** ERROR **';
          throw errorM;
        })
      )
      .subscribe();
  }
}

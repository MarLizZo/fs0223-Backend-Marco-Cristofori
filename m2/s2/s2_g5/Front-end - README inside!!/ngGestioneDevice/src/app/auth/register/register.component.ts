import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription, catchError, tap } from 'rxjs';
import { IRegisterData } from 'src/app/interfaces/iregister-data';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
})
export class RegisterComponent {
  message: String = '';
  data: IRegisterData = {
    name: '',
    username: '',
    email: '',
    password: '',
  };

  constructor(private svc: AuthService, private router: Router) {}

  regSub!: Subscription;

  ngOnDestroy() {
    if (this.regSub) this.regSub.unsubscribe();
  }

  register(): void {
    this.regSub = this.svc
      .register(this.data)
      .pipe(
        tap((res) => {
          this.message =
            'User ' + res.name + ' creato. Redirect in 2 secondi..';
          setTimeout(() => {
            this.router.navigate(['/auth/login']);
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

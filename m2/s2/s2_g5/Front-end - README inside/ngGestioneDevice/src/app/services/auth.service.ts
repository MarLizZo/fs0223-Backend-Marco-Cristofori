import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, map, take, tap } from 'rxjs';
import { IResponseUserData } from '../interfaces/iresponse-user-data';
import { HttpClient } from '@angular/common/http';
import { IRegisterData } from '../interfaces/iregister-data';
import { ILoginData } from '../interfaces/ilogin-data';
import { IUser } from '../interfaces/iuser';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  apiUrl: string = 'http://localhost:8080/api/';
  loginUrl: string = this.apiUrl + 'auth/login';
  registerUrl: string = this.apiUrl + 'auth/register';
  private subj = new BehaviorSubject<IResponseUserData | null>(null);
  user$ = this.subj.asObservable();
  isLogged$ = this.user$.pipe(map((l) => !!l));
  isModerator$ = false;
  isAdmin$ = false;

  constructor(private http: HttpClient) {
    this.getUserData();
  }

  getUserData(): void {
    let chk: string | null = localStorage.getItem('user');
    let user: IResponseUserData | null = null;

    if (chk) {
      user = JSON.parse(chk);
      this.subj.next(user);
      this.isModerator$ = user!.isMod;
      this.isAdmin$ = user!.isAdmin;
    }
  }

  register(data: IRegisterData): Observable<IUser> {
    return this.http.post<IUser>(this.registerUrl, data);
  }

  login(data: ILoginData): Observable<IResponseUserData> {
    return this.http.post<IResponseUserData>(this.loginUrl, data).pipe(
      take(1),
      tap((val) => {
        this.subj.next(val);
        this.isModerator$ = val.isMod;
        this.isAdmin$ = val.isAdmin;
      })
    );
  }

  logout(): void {
    this.subj.next(null);
    localStorage.removeItem('user');
  }
}

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IUser } from '../interfaces/iuser';
import { IResponseGetUsers } from '../interfaces/iresponse-get-users';

@Injectable({
  providedIn: 'root',
})
export class GestionaleService {
  apiUrl: string = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) {}

  getAllUsers(): Observable<IResponseGetUsers> {
    return this.http.get<IResponseGetUsers>(this.apiUrl + 'users');
  }

  getUser(id: number): Observable<IUser> {
    return this.http.get<IUser>(this.apiUrl + 'user/' + id);
  }

  deleteUser(user: IUser): Observable<any> {
    return this.http.delete<any>(this.apiUrl + 'user/' + user.id);
  }
}

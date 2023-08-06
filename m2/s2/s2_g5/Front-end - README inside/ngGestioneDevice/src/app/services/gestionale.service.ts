import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IUser } from '../interfaces/iuser';
import { IResponseGetUsers } from '../interfaces/iresponse-get-users';
import { IResponseGetDevices } from '../interfaces/iresponse-get-devices';
import { IDevice } from '../interfaces/idevice';

@Injectable({
  providedIn: 'root',
})
export class GestionaleService {
  apiUrl: string = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) {}

  getAllUsers(): Observable<IResponseGetUsers> {
    return this.http.get<IResponseGetUsers>(this.apiUrl + 'users');
  }

  getAllDevices(): Observable<IResponseGetDevices> {
    return this.http.get<IResponseGetDevices>(this.apiUrl + 'devices');
  }

  getUser(id: number): Observable<IUser> {
    return this.http.get<IUser>(this.apiUrl + 'user/' + id);
  }

  deleteUser(user: IUser): Observable<IUser> {
    return this.http.delete<IUser>(this.apiUrl + 'user/' + user.id);
  }

  deleteDevice(dev: IDevice): Observable<IDevice> {
    return this.http.delete<IDevice>(this.apiUrl + 'device/' + dev.id);
  }
}

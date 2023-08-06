import { Component } from '@angular/core';
import { Subscription, catchError, map } from 'rxjs';
import { IDevice } from 'src/app/interfaces/idevice';
import { AuthService } from 'src/app/services/auth.service';
import { GestionaleService } from 'src/app/services/gestionale.service';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.scss'],
})
export class DevicesComponent {
  devicesArr: IDevice[] = [];
  iAmAdmin: boolean = false;
  sub!: Subscription;

  constructor(private svc: GestionaleService, private authSvc: AuthService) {}

  ngOnInit() {
    this.iAmAdmin = this.authSvc.isAdmin$;
    this.sub = this.svc
      .getAllDevices()
      .pipe(
        map((res) => {
          this.devicesArr = res.content;
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

  deleteDevice(dev: IDevice) {
    this.devicesArr.splice(
      this.devicesArr.findIndex((el) => el.id == dev.id),
      1
    );
    this.svc
      .deleteDevice(dev)
      .pipe(
        map((res) => {
          console.log(res);
        }),
        catchError((errorM) => {
          throw errorM;
        })
      )
      .subscribe();
  }
}

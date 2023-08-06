import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  loggedSub!: Subscription;
  loggedStr: string | undefined = 'Not logged In';

  constructor(private svc: AuthService) {
    this.checkUserLogged();
  }

  ngOnDestroy() {
    this.loggedSub.unsubscribe();
  }

  checkUserLogged() {
    this.loggedSub = this.svc.isLogged$.subscribe((res) => {
      res ? this.getData() : null;
    });
  }

  getData(): void {
    this.svc.user$
      .subscribe(
        (res) =>
          (this.loggedStr = res?.isAdmin
            ? 'Admin ' + res.username
            : res?.isMod
            ? 'Moderator ' + res.username
            : res?.username)
      )
      .unsubscribe();
  }

  isHomePage(): boolean {
    return location.pathname == '/';
  }
  isUsersPage(): boolean {
    return location.pathname.includes('user');
  }
  isDevicesPage(): boolean {
    return location.pathname.includes('device');
  }
}

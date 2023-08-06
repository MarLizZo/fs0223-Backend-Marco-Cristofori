import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DevicesRoutingModule } from './devices-routing.module';
import { DevicesComponent } from './devices.component';
import { DevicecardComponent } from 'src/app/components/devicecard/devicecard.component';

@NgModule({
  declarations: [DevicesComponent],
  imports: [CommonModule, DevicesRoutingModule, DevicecardComponent],
})
export class DevicesModule {}

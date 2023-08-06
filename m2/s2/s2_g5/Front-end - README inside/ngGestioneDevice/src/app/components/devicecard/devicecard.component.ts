import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IDevice } from 'src/app/interfaces/idevice';

@Component({
  selector: 'app-devicecard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './devicecard.component.html',
  styleUrls: ['./devicecard.component.scss'],
})
export class DevicecardComponent {
  @Input() device!: IDevice;
  @Input() isAdmin!: boolean;

  @Output() onDelete = new EventEmitter();

  deleteDevice() {
    this.onDelete.emit(this.device);
  }
}

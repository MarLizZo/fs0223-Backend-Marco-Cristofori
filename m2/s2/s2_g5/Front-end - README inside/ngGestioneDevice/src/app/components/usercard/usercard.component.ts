import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IUser } from 'src/app/interfaces/iuser';

@Component({
  selector: 'app-usercard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './usercard.component.html',
  styleUrls: ['./usercard.component.scss'],
})
export class UsercardComponent {
  @Input() user!: IUser;
  @Input() isAdmin!: boolean;

  @Output() onDelete = new EventEmitter();

  deleteUser() {
    this.onDelete.emit(this.user);
  }
}

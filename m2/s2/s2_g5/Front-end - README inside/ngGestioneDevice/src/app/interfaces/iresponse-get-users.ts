import { IUser } from './iuser';

export interface IResponseGetUsers {
  content: IUser[];
  numberOfElements: number;
}

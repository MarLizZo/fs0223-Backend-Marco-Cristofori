export interface IDevice {
  id: number;
  name: string;
  type: string;
  state: string;
  storage: string | null;
  ram: string | null;
  os: string | null;
  inch: string | null;
  with_pen: boolean | null;
  camera: string | null;
}

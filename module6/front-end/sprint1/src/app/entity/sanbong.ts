import {Khuvuc} from "./khuvuc";
import {Loaisan} from "./loaisan";
import {Time} from "./time";

export interface Sanbong {
  id?: number;
  name?: string;
  address?: string;
  khuVuc?: Khuvuc;
  loaiSan?: Loaisan;
  time?: Time;
}

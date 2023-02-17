import {BenhNhan} from "./benh-nhan";

export interface BenhAn {
  id?: number;
  startDate?: string;
  endDate?: string;
  reason?: string;
  method?: string;
  doctor?: string;
  benhNhan?: BenhNhan;
}

import {Facility} from "./facility";
import {Customer} from "./customer";
import {ContractDetail} from "./contract-detail";

export interface Contract {
  id?: number;
  startDate?: string;
  endDate?: string;
  deposit?: number;
  facility?: Facility;
  customer?: Customer;
  contractDetail?: ContractDetail;
}

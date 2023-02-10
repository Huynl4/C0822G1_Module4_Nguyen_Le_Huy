import {Catelory} from "./catelory";

export interface Product {
  id?: number;
  name?: string;
  price?: number;
  description?: string;
  catelory?: Catelory
}

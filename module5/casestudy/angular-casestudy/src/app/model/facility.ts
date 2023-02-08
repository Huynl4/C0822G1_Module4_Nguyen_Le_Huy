import {RentType} from "./rent-type";
import {FacilityType} from "./facility-type";

export interface Facility {
  id?: number;
  name?: string;
  area?: number;
  cost?: number;
  maxPeople?: number;
  standardRoom?: string;
  description?: string;
  poolArea?: number;
  numberFloor?: number;
  facilityFree?: string;
  facilityType?: FacilityType;
  rentType?: RentType;
}

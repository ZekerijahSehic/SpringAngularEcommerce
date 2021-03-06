import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Purchase} from "../common/purchase";

@Injectable({
  providedIn: 'root'
})
export class CheckOutService {

  private purchaseUrl = 'http://localhost:9001/api/checkout/purchase';

  constructor(private httpClient: HttpClient) { }

  placeOrder(purchase: Purchase): Observable<any> {
    return this.httpClient.post<Purchase>(this.purchaseUrl, purchase);
  }
}

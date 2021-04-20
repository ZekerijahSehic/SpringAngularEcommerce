import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../common/product";
import {map} from "rxjs/operators";
import {ProductCategory} from "../common/product-category";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productsUrl = 'http://localhost:9001/api/products';
  private categoryUrl = 'http://localhost:9001/api/product-category';

  constructor(private httpClient: HttpClient) { }

  getProductList(theCatgoryId: number): Observable<Product[]> {

    const searchUrl = `${this.productsUrl}/search/findByCategoryId?id=${theCatgoryId}`;
    return this.getProducts(searchUrl);
  }

  searchProducts(theKeyword: string): Observable<Product[]> {

    const searchUrl = `${this.productsUrl}/search/findByNameContaining?name=${theKeyword}`;
    return this.getProducts(searchUrl);

  }

  private getProducts(searchUrl: string) {
    return this.httpClient.get<GetResponse>(searchUrl).pipe(
      map(response => response._embedded.products)
    );
  }

  getProductCategories(): Observable<ProductCategory[]> {
    return this.httpClient.get<GetResponseProductCategory>(this.categoryUrl).pipe(
      map( response => response._embedded.productCategory)
    )
  }



}

interface GetResponse {
  _embedded: {
    products: Product[];
  }
}

interface GetResponseProductCategory {
  _embedded: {
    productCategory: ProductCategory[];
  }
}



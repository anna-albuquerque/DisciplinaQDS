import { Injectable } from '@angular/core';
import { Cuidador } from '../Cuidador';
import { Observable, forkJoin } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Caracteristicas } from '../Caracteristicas';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CuidadorService {

  url = 'http://localhost:8000/api/v1/';

  constructor(private http: HttpClient) { }

  // Create a new cuidador
  createCuidador(cuidador: Cuidador): Observable<Cuidador> {
    console.log('Cuidador a ser enviado:', cuidador);
    return this.http.post<Cuidador>(this.url + 'cuidadores/', cuidador);
  }

  // Get all cuidadores
  getCuidadors(): Observable<Cuidador[]> {
    return this.http.get<Cuidador[]>(this.url + 'cuidadores/');
  }

  // Get características
  getCaracteristicas(): Observable<Caracteristicas[]> {
    return this.http.get<Caracteristicas[]>(this.url + 'caracteristicas/');
  }

  // Get all cuidadores with características
}

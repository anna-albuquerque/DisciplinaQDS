import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://127.0.0.1:8000/api/v1/';  // URL da sua API de login
  private loggedIn = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient) {
    // Verifica se o usuário já está logado ao iniciar
    this.loggedIn.next(!!localStorage.getItem('token'));
  }

  // Método para login
  login(username: string, password: string): Observable<any> {
    return this.http.post(this.baseUrl+'api/login/', { username, password }).pipe(
      tap((response: any) => {
        // Armazena o token no localStorage e atualiza o estado de login
        localStorage.setItem('token', response.token);
        this.loggedIn.next(true);
      })
    );
  }

  // Método para logout
  logout(): void {
    localStorage.removeItem('token');
    this.loggedIn.next(false);
  }

  // Verifica se o usuário está logado
  isLoggedIn(): Observable<boolean> {
    return this.loggedIn.asObservable();
  }

  // Obtém o token de autenticação
  getToken(): string | null {
    return localStorage.getItem('token');
  }
  register(username: string, password: string): Observable<any> {
    return this.http.post(`${this.baseUrl}register/`, { username, password });
  }
  setToken(token: string): void {
    if (typeof window !== 'undefined' && localStorage) {
      localStorage.setItem('token', token);
    }
  }
}

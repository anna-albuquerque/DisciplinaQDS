import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css']
})

export class CadastroUsuarioComponent {
  username: string = '';
  password: string = '';
  confirmPassword: string = '';
  errorMessage: string | null = null;

  constructor(private authService: AuthService, private router: Router) {}

  checkPasswords() {
    // Função para verificar se as senhas coincidem em tempo real
  }

  registerUser(): void { // Removi os parâmetros da função, pois você já está usando this.username e this.password
    this.authService.register(this.username, this.password).subscribe(
      (response: any) => {
        console.log('Usuário cadastrado com sucesso', response);
        this.router.navigate(['/login']); // Redireciona para a página de login após o cadastro
      },
      (error: any) => {
        console.error('Erro ao cadastrar usuário', error);
        this.errorMessage = 'Erro ao cadastrar usuário. Tente novamente.';
      }
    );
  }

  onSubmit(f: NgForm) {
    if (this.password !== this.confirmPassword) {
      this.errorMessage = 'As senhas não correspondem.';
      return;
    }
    this.registerUser(); // Agora, a função é chamada corretamente # o onSUbmit não podia ser chamado dentro do método registerUser
  }
}

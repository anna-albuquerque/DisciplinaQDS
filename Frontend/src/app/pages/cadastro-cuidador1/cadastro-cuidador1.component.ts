import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CuidadorService } from '../../services/cuidador.service';
import { CaracteristicasService } from '../../services/caracteristicas.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro-cuidador1',
  templateUrl: './cadastro-cuidador1.component.html',
  styleUrls: ['./cadastro-cuidador1.component.css']
})
export class CadastroCuidador1Component implements OnInit {
  cuidador = {
    nome: '',
    sobrenome: '',
    cpf: '',
    email: '',
    logradouro: '',
    data_nascimento: '',
    telefone: '',
    instagram: '',
    cep: '',
    localidade: '',
    uf: '',
    numero: 0,
    caracteristicas: [] as number[]
  };

  caracteristicas: any[] = [];

  constructor(
    private cuidadorService: CuidadorService,
    private caracteristicasService: CaracteristicasService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.caracteristicasService.getCaracteristicas().subscribe(
      (data) => {
        this.caracteristicas = data;
      },
      (error) => {
        console.error('Erro ao carregar características', error);
      }
    );
  }

  onSubmit(f: NgForm) {
    const caracteristicas = f.value.caracteristicas ? f.value.caracteristicas.map(Number) : [];

    const cuidadorData = {
      nome: f.value.nome,
      sobrenome: f.value.sobrenome,
      data_nascimento: f.value.data_nascimento,
      cpf: f.value.cpf,
      email: f.value.email,
      telefone: f.value.telefone,
      instagram: f.value.instagram,
      cep: f.value.cep,
      uf: f.value.uf,
      numero: f.value.numero,
      logradouro: f.value.logradouro,
      localidade: f.value.localidade,
      caracteristicas: caracteristicas
    };

    this.cuidadorService.createCuidador(cuidadorData).subscribe(
      (cuidadorResponse) => {
        console.log('Cuidador criado com sucesso', cuidadorResponse);
        if (cuidadorResponse.id !== undefined) {
          localStorage.setItem('cuidadorId', cuidadorResponse.id.toString());
        } else {
          console.error('ID do cuidador não definido');
        }
        this.router.navigate(['/cadastro-usuario']);  // Redireciona para o componente de cadastro de usuário
      },
      (error) => {
        console.error('Erro ao criar cuidador', error);
      }
    );
  }
}

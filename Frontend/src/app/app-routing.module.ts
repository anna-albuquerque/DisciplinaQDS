import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { CadastroTutor1Component } from './pages/cadastro-tutor1/cadastro-tutor1.component';
import { ListarCuidadoresComponent } from './pages/listar-cuidadores/listar-cuidadores.component';

import { BuscarCuidadorComponent } from './pages/buscar-cuidador/buscar-cuidador.component';
import { CadastroCuidador1Component } from './pages/cadastro-cuidador1/cadastro-cuidador1.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './guards/auth.guard';
import { CadastroUsuarioComponent } from './pages/cadastro-usuario/cadastro-usuario.component';


const routes: Routes = [
    {path: 'home', component: HomeComponent},
    {path: 'cadastrar', component: CadastroTutor1Component, canActivate: [AuthGuard]},
    {path: 'cuidadores', component: ListarCuidadoresComponent},
    {path: 'cadastro-cuidador', component: CadastroCuidador1Component},
    {path: 'buscar-cuidador', component: BuscarCuidadorComponent},
    {path: 'login', component: LoginComponent},
    {path: 'cadastro-usuario', component: CadastroUsuarioComponent},
    {path: 'signup', component: CadastroUsuarioComponent},
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

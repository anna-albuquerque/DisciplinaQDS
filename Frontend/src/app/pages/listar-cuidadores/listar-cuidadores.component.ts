import { Component, OnInit} from '@angular/core';
import { Cuidador } from '../../Cuidador';
import { CuidadorService } from '../../services/cuidador.service';

@Component({
  selector: 'app-listar-cuidadores',
  templateUrl: './listar-cuidadores.component.html',
  styleUrl: './listar-cuidadores.component.css'
})
export class ListarCuidadoresComponent implements OnInit{
  cuidadors: Cuidador[] = [];
  

  constructor(private service: CuidadorService){}
  
  ngOnInit() {
    this.service.getCuidadors().subscribe( data => this.cuidadors = data);
  }

  
}

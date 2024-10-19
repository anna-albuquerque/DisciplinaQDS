import { Component } from '@angular/core';
import { Tutor} from '../../Tutor';
import { Input } from '@angular/core';

@Component({
  selector: 'app-card-tutores',
  templateUrl: './card-tutores.component.html',
  styleUrl: './card-tutores.component.css'
})

export class CardTutoresComponent {
  @Input() tutor!: Tutor;

  whatsapp: string= 'https://wa.me/';
  

  

}

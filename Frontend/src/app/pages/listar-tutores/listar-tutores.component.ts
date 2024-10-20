import { Component, OnInit} from '@angular/core';
import { Tutor } from '../../Tutor';
import { TutorService } from '../../services/tutor.service';

@Component({
  selector: 'app-listar-tutores',
  templateUrl: './listar-tutores.component.html',
  styleUrl: './listar-tutores.component.css'
})
export class ListarTutoresComponent implements OnInit {
  tutors: Tutor[] = [];

  constructor(private service: TutorService){}
  
  ngOnInit() {
    this.service.getTutors().subscribe( data => this.tutors = data);
  }
}

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarTutoresComponent } from './listar-tutores.component';

describe('ListarTutoresComponent', () => {
  let component: ListarTutoresComponent;
  let fixture: ComponentFixture<ListarTutoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListarTutoresComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListarTutoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

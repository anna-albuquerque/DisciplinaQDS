import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListartutorComponent } from './listartutor.component';

describe('ListartutorComponent', () => {
  let component: ListartutorComponent;
  let fixture: ComponentFixture<ListartutorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListartutorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListartutorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

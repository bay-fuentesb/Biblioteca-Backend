import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibroComponents } from './libro-components';

describe('LibroComponents', () => {
  let component: LibroComponents;
  let fixture: ComponentFixture<LibroComponents>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LibroComponents],
    }).compileComponents();

    fixture = TestBed.createComponent(LibroComponents);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

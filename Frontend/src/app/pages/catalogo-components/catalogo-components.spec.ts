import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CatalogoComponents } from './catalogo-components';

describe('CatalogoComponents', () => {
  let component: CatalogoComponents;
  let fixture: ComponentFixture<CatalogoComponents>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CatalogoComponents],
    }).compileComponents();

    fixture = TestBed.createComponent(CatalogoComponents);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

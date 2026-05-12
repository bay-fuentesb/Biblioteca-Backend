import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioComponents } from './inicio-components';

describe('InicioComponents', () => {
  let component: InicioComponents;
  let fixture: ComponentFixture<InicioComponents>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InicioComponents],
    }).compileComponents();

    fixture = TestBed.createComponent(InicioComponents);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioComponets } from './inicio-componets';

describe('InicioComponets', () => {
  let component: InicioComponets;
  let fixture: ComponentFixture<InicioComponets>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InicioComponets],
    }).compileComponents();

    fixture = TestBed.createComponent(InicioComponets);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

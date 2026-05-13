import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotFoundComponents } from './not-found-components';

describe('NotFoundComponents', () => {
  let component: NotFoundComponents;
  let fixture: ComponentFixture<NotFoundComponents>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NotFoundComponents],
    }).compileComponents();

    fixture = TestBed.createComponent(NotFoundComponents);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

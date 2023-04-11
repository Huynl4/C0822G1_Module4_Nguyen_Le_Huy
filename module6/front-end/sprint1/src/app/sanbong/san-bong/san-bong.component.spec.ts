import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SanBongComponent } from './san-bong.component';

describe('SanBongComponent', () => {
  let component: SanBongComponent;
  let fixture: ComponentFixture<SanBongComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SanBongComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SanBongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

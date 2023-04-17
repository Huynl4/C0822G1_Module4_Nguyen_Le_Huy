import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QrcoceComponent } from './qrcoce.component';

describe('QrcoceComponent', () => {
  let component: QrcoceComponent;
  let fixture: ComponentFixture<QrcoceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QrcoceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QrcoceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

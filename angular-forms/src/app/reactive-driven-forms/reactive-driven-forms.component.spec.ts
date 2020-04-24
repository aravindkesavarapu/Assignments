import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReactiveDrivenFormsComponent } from './reactive-driven-forms.component';

describe('ReactiveDrivenFormsComponent', () => {
  let component: ReactiveDrivenFormsComponent;
  let fixture: ComponentFixture<ReactiveDrivenFormsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReactiveDrivenFormsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReactiveDrivenFormsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

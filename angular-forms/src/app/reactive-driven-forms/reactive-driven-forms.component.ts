import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormArray, Validators} from '@angular/forms';

@Component({
  selector: 'app-reactive-driven-forms',
  templateUrl: './reactive-driven-forms.component.html',
  styleUrls: ['./reactive-driven-forms.component.css']
})
export class ReactiveDrivenFormsComponent implements OnInit {

  constructor() { }

  regForm: FormGroup

  ngOnInit(): void {
    this.regForm = new FormGroup({
      email: new FormControl(null, [Validators.required, Validators.minLength(8)]),
      password: new FormControl(),
      skills: new FormArray([
        new FormControl()
      ])
    });
  }


  get email() {
    return this.regForm.get('email');
  }
  get password() {
    return this.regForm.get('password');
  }

  get skills() {
    return this.regForm.get('skills') as FormArray;
  }

  addSkill() {
    this.skills.push(new FormControl());
  }

  deleteSkill(index: number) {
    this.skills.removeAt(index);
  }
  submitForm() {
    //console.log(this.skills);
    console.log(this.regForm.value);  
   // console.log(this.email);
    //this.regForm.reset();
  }

}

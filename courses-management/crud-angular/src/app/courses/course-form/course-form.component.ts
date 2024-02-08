import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { CoursesService } from '../services/courses.service';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent implements OnInit {

  form: FormGroup;

  constructor(
      private formBuilder: FormBuilder,
      private service: CoursesService,
      private snackBar: MatSnackBar,
      private location: Location
    ) {
    this.form = this.formBuilder.group({
      name: [null],
      category: [null]
    });
   }

  ngOnInit(): void {
  }

  onSubmit() {
    this.service.save(this.form.value).subscribe(data => this.onSucces(), error => this.onError());
    this.onCancel();
  }

  onCancel() {
    this.location.back();
  }

  private onSucces() {
    this.snackBar.open('Course saved!', '', { duration: 5000 })
  }

  private onError() {
    this.snackBar.open('Error when saving new course ocurred!', '', { duration: 5000 })
  }

}

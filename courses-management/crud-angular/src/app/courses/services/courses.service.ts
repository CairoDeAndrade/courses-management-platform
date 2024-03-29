import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Course } from '../model/course';
import { Observable, delay, first } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private readonly API = '/api/courses';

  constructor(private httpClient: HttpClient) { }

  findAllCourses(): Observable<Course[]> {
    return this.httpClient.get<Course[]>(this.API)
    .pipe(
      first()
      //delay(5000),
    );
  }

  save(record: Course) {
    return this.httpClient.post<Course>(this.API, record);
  }
}

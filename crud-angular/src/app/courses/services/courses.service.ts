import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Course } from '../model/course';
import { delay, first, tap } from 'rxjs/operators';
import { CoursePage } from '../model/course-page';

@Injectable({
  providedIn: 'root',
})
export class CoursesService {
  private readonly API = 'api/courses';

  constructor(private httpClient: HttpClient) {}

  list(page = 0, pageSize = 10) {
    console.log(`${this.API}/`);
    return this.httpClient
      .get<CoursePage>(this.API, { params: { page, pageSize } })
      .pipe(
        first()
        //delay(1000),
        //tap((courses) => console.log(courses))
      );
  }

  loadById(id: string) {
    console.log(`${this.API}/${id}`);
    return this.httpClient.get<Course>(`${this.API}/${id}`);
  }

  save(record: Partial<Course>) {
    //console.log(record);
    if (record._id) {
      // console.log('update');
      return this.update(record);
    }
    // console.log('create');
    return this.create(record);
  }

  private create(record: Partial<Course>) {
    return this.httpClient.post<Course>(this.API, record).pipe(first());
  }

  private update(record: Partial<Course>) {
    return this.httpClient
      .put<Course>(`${this.API}/${record._id}`, record)
      .pipe(first());
  }

  remove(id: string) {
    return this.httpClient.delete(`${this.API}/${id}`).pipe(first());
  }
}

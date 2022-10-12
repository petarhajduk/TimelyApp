import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Entry } from './entry';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EntryService {
  constructor(private http: HttpClient) { }

  public getEntries(): Observable<Entry[]> {
    return this.http.get<Entry[]>('http://localhost:8081/get-all')
  }

  public addEntry(entry: Entry): Observable<Entry> {
    return this.http.post<Entry>('http://localhost:8081/add-new', entry)
  }

  public deleteAll(): Observable<void> {
    return this.http.delete<void>('http://localhost:8081/delete')
  }
}

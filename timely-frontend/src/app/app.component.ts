import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Entry } from './entry';
import { EntryService } from './entry.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public entries: Entry[] | undefined;

  constructor(private entryService: EntryService){}

  ngOnInit(): void {
    this.getEntries()
  }

  public getEntries(): void {
    this.entryService.getEntries().subscribe(
      (response: Entry[]) => {
        this.entries = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }



}

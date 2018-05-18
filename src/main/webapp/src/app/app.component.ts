import { Component } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';
 
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Pun Puzzle';
  result =  [''];
  textValue = 'Some Word';
  log = '';
 
  constructor(private http: Http){
  }
 
  search(word: string) {
  	let promise = new Promise((resolve, reject) => {
  		this.http.get(`http://localhost:8080/search?word=${word}&max=10`).toPromise().then(
  			res => {
  				this.result = [];
  				this.result = res.json();
  				console.log(this.result);
  				resolve();
  			},
  			msg => {
  				reject(msg);
  			});
  	});
  	return promise;
  }

  doSearch(value: string): void {
    this.result = ['loading...'];
    //this.http.get(`/search?word='${value}'&max=5`).subscribe(response => this.result = response.text());
    this.search(value);
    this.log += `Word Searched changed to '${value}' \n`;
  }
  
}
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { APP_URL, CORS_HEADERS } from 'src/app.constants';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

export const AUTHENTICATED_USER = 'authenticatedUser';
export const TOKEN = 'token';
export const USER_ID = 'userId';

export class AuthenticationBean {
  constructor(public userId: number,public token:string) { }
}

@Injectable({
  providedIn: 'root'
})

export class UserService {

constructor(private http: HttpClient,private router:Router){ 
  
}

findAllUsers(){
  return this.http.get<User[]>(`${APP_URL}/users`);
}

findUserById(uid){
  return this.http.get<User>(`${APP_URL}/users/${uid}`,CORS_HEADERS);
}

findUserByUsername(uname){
  return this.http.get<User>(`${APP_URL}/user/${uname}`,CORS_HEADERS);
}

addUser(u:User){
  return this.http.post(`${APP_URL}/users/add-user`,u,CORS_HEADERS);
}

updateUser(u){
  return this.http.put<User>(`${APP_URL}/users/update-user`,u);
}

removeUser(uid){
  return this.http.delete<String>(`${APP_URL}/remove-user/${uid}`);
}

authenticate(username: string, password: string) {
  // if (username === 'kunalj' && password === '2899') {
  //   sessionStorage.setItem('authenticateUser', username);
  //   return true;
  // }
  // else
  //   return false;
  // let basicAuthHeaderString = 'Basic ' + window.btoa(username + ":" + password);
    // let headers = new HttpHeaders(
    //   {
    //     Authorization: basicAuthHeaderString
    //   }
    // );
    // return this.http.get<AuthenticationBean>(`${APP_URL}/user/basicauth`, { headers }).pipe(
    //   map(
    //     data => {
    //       sessionStorage.setItem(USER_ID, "" + data.userId);
    //       sessionStorage.setItem(AUTHENTICATED_USER, username);
    //       sessionStorage.setItem(TOKEN, basicAuthHeaderString);
    //       return data;
    //     }
    //   )
    // );

    return this.http.post<AuthenticationBean>(`${APP_URL}/authenticate`, { username, password }, CORS_HEADERS).pipe(
      map(
        data => {
          sessionStorage.setItem(USER_ID, "" + data.userId);
          sessionStorage.setItem(AUTHENTICATED_USER, username);
          sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
          return data;
        },
        error => {
          console.log(error)
          alert('Session expired, Please login to continue!')
          this.router.navigate(['log-reg']);
        }
      )
    );
}

isUserLoggedIn() {
  let user = sessionStorage.getItem(AUTHENTICATED_USER);
  return !(user === null);
}

logout() {
    sessionStorage.removeItem(AUTHENTICATED_USER);
    sessionStorage.removeItem(TOKEN);
    sessionStorage.removeItem(USER_ID);
}

getAuthenticatedUserId(): number {
  return parseInt(sessionStorage.getItem(USER_ID));
}

getAuthenticatedUser() {
  return sessionStorage.getItem(AUTHENTICATED_USER);
}

getAuthenticatedToken() {
  if (this.getAuthenticatedUser())
    return sessionStorage.getItem(TOKEN);
}

// isTokenExpired(){

// }


}

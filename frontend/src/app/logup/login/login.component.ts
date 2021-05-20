import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User()
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private service: AuthService, private tokenstorage: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenstorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenstorage.getUser().roles;
    }
  }
  onSubmit(): void {

    this.service.login(this.user).subscribe(
      data => {
        this.tokenstorage.saveToken(data.accessToken);
        this.tokenstorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenstorage.getUser().roles;
        this.reloadPage();
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      });
  }

  reloadPage(): void {
    window.location.reload();
  }
}

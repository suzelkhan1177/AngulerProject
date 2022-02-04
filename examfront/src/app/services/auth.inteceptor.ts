import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginService } from "./login.service";

const TOKEN_HEADER = 'Authorization'; 

@Injectable()
export class AuthIntercepter  implements HttpInterceptor
{
  constructor(private login : LoginService){

  }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
  
        //add tha jwt  token (Localstorage) request
         let authReq = req;
        const token = this.login.getToken();
        console.log("Inside Intersecter");
        if(token != null)
        {
          
           authReq = authReq.clone({setHeaders:{Authorization:`Bearer ${token}`},
        
        });
        }

        return next.handle(authReq);
       
    }

}

export const AuthInterceptorProviders=[

    {
        provide :HTTP_INTERCEPTORS,
        useClass :AuthIntercepter,
        multi :true,
    },
];






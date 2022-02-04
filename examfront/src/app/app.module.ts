import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { MatButtonModule } from "@angular/material/button";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { FooterComponent } from "./components/footer/footer.component";
import { NavbarComponent } from "./components/navbar/navbar.component";
import { SingupComponent } from "./pages/singup/singup.component";
import { LoginComponent } from "./pages/login/login.component";
import { MatInputModule } from "@angular/material/input";
import { MatFormFieldModule } from "@angular/material/form-field";
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { MatIconModule } from "@angular/material/icon";
import { HomeComponent } from "./pages/home/home.component";
import { MatCommonModule } from "@angular/material/core";
import { MatCardModule } from "@angular/material/card";
import { MatToolbarModule } from "@angular/material/toolbar";
import { AuthInterceptorProviders } from "./services/auth.inteceptor";
import { DashbordComponent } from "./pages/admin/dashbord/dashbord.component";
import { UserDisbordComponent } from "./pages/user/user-disbord/user-disbord.component";
import { ProfileComponent } from "./pages/profile/profile.component";
import { MatListModule } from "@angular/material/list";
import { SidebarComponent } from "./pages/admin/sidebar/sidebar.component";
import { WelcomeComponent } from "./pages/admin/welcome/welcome.component";
import { VeiwCategrouesComponent } from "./pages/admin/veiw-categroues/veiw-categroues.component";
import { AddCategrouesComponent } from "./pages/admin/add-categroues/add-categroues.component";
import { ViewQuizzesComponent } from "./pages/admin/view-quizzes/view-quizzes.component";
import { AddQuizComponent } from "./pages/admin/add-quiz/add-quiz.component";
import { MatSlideToggleModule } from "@angular/material/slide-toggle";
import { MatSelectModule } from "@angular/material/select";
import { UpdateQuizComponent } from "./pages/admin/update-quiz/update-quiz.component";
import { ViewQuizQuestionsComponent } from "./pages/admin/view-quiz-questions/view-quiz-questions.component";
import { AddQuestionComponent } from "./pages/admin/add-question/add-question.component";

import { CKEditorModule } from "ckeditor4-angular";
import { SidebaruserComponent } from "./pages/user/sidebaruser/sidebaruser.component";
import { LoadQuizComponent } from "./pages/user/load-quiz/load-quiz.component";

import { InstructionComponent } from "./pages/user/instruction/instruction.component";
import { StartComponent } from "./pages/user/start/start.component";
import { MatRadioModule } from "@angular/material/radio";
import { MatProgressSpinnerModule } from "@angular/material/progress-spinner";
import { NgxUiLoaderHttpModule, NgxUiLoaderModule } from "ngx-ui-loader";
import { NgxSpinnerModule } from "ngx-spinner";

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavbarComponent,
    SingupComponent,
    LoginComponent,
    HomeComponent,
    DashbordComponent,
    UserDisbordComponent,
    ProfileComponent,
    SidebarComponent,
    WelcomeComponent,
    VeiwCategrouesComponent,
    AddCategrouesComponent,
    ViewQuizzesComponent,
    AddQuizComponent,
    UpdateQuizComponent,
    ViewQuizQuestionsComponent,
    AddQuestionComponent,
    SidebaruserComponent,
    LoadQuizComponent,

    InstructionComponent,
    StartComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    NgbModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatCommonModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatSlideToggleModule,
    MatSelectModule,
    CKEditorModule,
    MatRadioModule,
    MatProgressSpinnerModule,NgxUiLoaderModule,
    NgxUiLoaderHttpModule.forRoot({showForeground :true}), NgxSpinnerModule
  ],
  providers: [AuthInterceptorProviders],
  bootstrap: [AppComponent],
  schemas : [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule {}

import { ScrollStrategyOptions } from "@angular/cdk/overlay";
import { Component, NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AddCategrouesComponent } from "./pages/admin/add-categroues/add-categroues.component";
import { AddQuestionComponent } from "./pages/admin/add-question/add-question.component";
import { AddQuizComponent } from "./pages/admin/add-quiz/add-quiz.component";
import { DashbordComponent } from "./pages/admin/dashbord/dashbord.component";
import { UpdateQuizComponent } from "./pages/admin/update-quiz/update-quiz.component";
import { VeiwCategrouesComponent } from "./pages/admin/veiw-categroues/veiw-categroues.component";
import { ViewQuizQuestionsComponent } from "./pages/admin/view-quiz-questions/view-quiz-questions.component";
// import { ViewQuizQuestionsComponent } from './pages/admin/view-quiz-questions/view-quiz-questions.component';
import { ViewQuizzesComponent } from "./pages/admin/view-quizzes/view-quizzes.component";
import { WelcomeComponent } from "./pages/admin/welcome/welcome.component";
import { HomeComponent } from "./pages/home/home.component";
import { LoginComponent } from "./pages/login/login.component";
import { ProfileComponent } from "./pages/profile/profile.component";
import { SingupComponent } from "./pages/singup/singup.component";
import { InstructionComponent } from "./pages/user/instruction/instruction.component";
import { LoadQuizComponent } from "./pages/user/load-quiz/load-quiz.component";
import { StartComponent } from "./pages/user/start/start.component";

import { UserDisbordComponent } from "./pages/user/user-disbord/user-disbord.component";
import { AdminGuard } from "./services/admin.guard";
import { NormalGuard } from "./services/normal.guard";

const routes: Routes = [
  {
    path: "singup",
    component: SingupComponent,
    pathMatch: "full",
  },

  {
    path: "",
    component: HomeComponent,
    pathMatch: "full",
  },

  {
    path: "login",
    component: LoginComponent,
    pathMatch: "full",
  },

  {
    path: "admin",
    component: DashbordComponent,
    canActivate: [AdminGuard],

    children: [
      {
        path: "",
        component: WelcomeComponent,
      },
      {
        path: "profile",
        component: ProfileComponent,
      },

      {
        path: "categroues",
        component: VeiwCategrouesComponent,
      },
      {
        path: "add-category",
        component: AddCategrouesComponent,
      },
      {
        path: "quizzes",
        component: ViewQuizzesComponent,
      },
      {
        path: "add-quiz",
        component: AddQuizComponent,
      },
      {
        path: "quiz/:qid",
        component: UpdateQuizComponent,
      },
      {
        path: "view-questions/:qid/:title",
        component: ViewQuizQuestionsComponent,
      },
      {
        path: "add-questions/:qid/:title",
        component: AddQuestionComponent,
      },
    ],
  },
  {
    path: "user-dishbord",
    component: UserDisbordComponent,
    canActivate: [NormalGuard],
    children: [
      {
        path: "profile",
        component: ProfileComponent,
      },
      {
        path: ":catid",
        component: LoadQuizComponent,
      },
      {
        path: "instruction/:qid",
        component: InstructionComponent,
      },


    
    ],
  },

  {
    path: "start/:qid",
    component: StartComponent,
    canActivate: [NormalGuard],
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

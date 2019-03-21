import { Component, OnInit } from '@angular/core';
import {QuestionService} from "../shared/question/question.service";
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-question-view',
  templateUrl: './question-view.component.html',
  styleUrls: ['./question-view.component.css']
})
export class QuestionViewComponent implements OnInit {
  question: any = {};

  sub: Subscription;

  constructor(
    private questionService: QuestionService,
    private route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.questionService.get(id).subscribe((question: any) => {
          if (question) {
            this.question = question;
            this.question.href = question._links.self.href;
          } else {
            console.log(`Question with id '${id}' not found, returning to list`);
            this.gotoList();
          }
        });
      }
    });
  }

  private gotoList() {
    this.router.navigate(['/question-list']);
  }

}

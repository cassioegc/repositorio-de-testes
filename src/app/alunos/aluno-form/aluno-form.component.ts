import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { AlunosService } from '../alunos.service';
import { FormCanDeactivate } from '../../guards/form-candeactivate';

@Component({
  selector: 'app-aluno-form',
  templateUrl: './aluno-form.component.html',
  styleUrls: ['./aluno-form.component.css']
})
export class AlunoFormComponent implements OnInit, OnDestroy, FormCanDeactivate {

  aluno: any;
  alunoOriginal: any;
  inscricao: Subscription;
  private formMudou = false;

  constructor(
    private route: ActivatedRoute,
    private alunosService: AlunosService
  ) { }

  ngOnInit() {
    this.inscricao = this.route.params.subscribe(params => {
      this.aluno = this.alunosService.getAluno(params.id);
      if (!this.aluno) {

        this.aluno = {};
      }

      this.alunoOriginal = { ...this.aluno };
    });
  }

  ngOnDestroy() {
    this.inscricao.unsubscribe();
  }

  cancelar() {
    if (this.aluno !== this.alunoOriginal) {
      this.alunosService.restaurarAluno(this.alunoOriginal);
      this.aluno = this.alunoOriginal;
    }
  }

  onInput() {
    this.formMudou = true;
  }

  podeDesativar() {
    if (this.formMudou) {
      confirm('Tem certeza, amigão?');
    }
    return true;
  }

}

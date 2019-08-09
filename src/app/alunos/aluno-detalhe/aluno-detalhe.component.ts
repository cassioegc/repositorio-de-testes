import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { AlunosService } from '../alunos.service';
import { AuthService } from '../../login/auth.service';
import { Usuario } from '../../login/usuario';

@Component({
  selector: 'app-aluno-detalhe',
  templateUrl: './aluno-detalhe.component.html',
  styleUrls: ['./aluno-detalhe.component.css']
})
export class AlunoDetalheComponent implements OnInit, OnDestroy {

  aluno: Usuario;
  inscricao: Subscription;
  podeEditar = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private alunosService: AlunosService,
    private authService: AuthService
  ) { }

  ngOnInit() {
    this.inscricao = this.route.data.subscribe(
      info => {
        this.aluno = info.aluno;
        this.podeEditar = this.aluno.id == this.authService.getIdUsuarioLogado();
      }
    );
  }

  ngOnDestroy() {
    this.inscricao.unsubscribe();
  }

  editarAluno() {
    this.router.navigate(['alunos', this.aluno.id, 'editar']);
  }

}

import { Injectable } from '@angular/core';

import { Usuario } from '../login/usuario';

@Injectable({
  providedIn: 'root'
})
export class AlunosService {

  alunos: any[] = [
    new Usuario(1, 'Aluno 01', 'aluno01@email.com', '111'),
    new Usuario(2, 'Aluno 02', 'aluno02@email.com', '222'),
    new Usuario(3,  'Aluno 03',  'aluno03@email.com', '333')
  ];

  constructor() { }

  getAlunos() {
    return this.alunos;
  }

  getAluno(id: number) {
    return this.alunos.find(aluno => aluno.id == id);
  }

  restaurarAluno(aluno: any) {
    const index = this.alunos.findIndex(a => a.id == aluno.id);
    this.alunos[index] = aluno;
  }
}

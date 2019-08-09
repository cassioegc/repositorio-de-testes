import { EventEmitter, Injectable } from '@angular/core';

import { Usuario } from './usuario';
import { Router } from '@angular/router';
import { AlunosService } from '../alunos/alunos.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private usuarioAutenticado: Usuario;

  mostrarMenuEmitter = new EventEmitter<boolean>();

  constructor(
    private router: Router,
    private alunosService: AlunosService
  ) { }

  fazerLogin(usuario: Usuario) {
    const usuarioCadastrado = this.alunosService.getAlunos()
      .find(value => value.email === usuario.email);

    if (usuarioCadastrado !== undefined && usuario.senha === usuarioCadastrado.senha) {
      this.usuarioAutenticado = usuarioCadastrado;
      this.mostrarMenuEmitter.emit(true);
      this.router.navigate(['/']);
    }
  }

  usuarioEstaAutenticado(): boolean {
    return Boolean(this.usuarioAutenticado);
  }

  getIdUsuarioLogado() {
    return this.usuarioAutenticado.id;
  }
}

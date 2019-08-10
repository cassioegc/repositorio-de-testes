import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CursosService {

  constructor() { }

  getCursos() {
    return [
      { id: 1, nome: 'Clojure' },
      { id: 2, nome: 'Docker' }
    ];
  }

  getCurso(id: number) {
    const cursos = this.getCursos();
    return cursos.find(c => c.id == id);
  }
}

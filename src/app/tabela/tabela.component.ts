import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tabela',
  templateUrl: './tabela.component.html',
  styleUrls: ['./tabela.component.css']
})
export class TabelaComponent implements OnInit {

  dados = [
    {type: 'nome', values: ['a', 'b', 'c']},
    {type: 'nome', values: ['a', 'b', 'c']},
    {type: 'nome', values: ['a', 'b', 'c']},
    {type: 'nome', values: ['a', 'b', 'c']},
    {type: 'nome', values: ['a', 'b', 'c']}
  ];

  constructor() { }

  ngOnInit() {
  }

}

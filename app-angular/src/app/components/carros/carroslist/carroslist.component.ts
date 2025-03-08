import { Component } from '@angular/core';
import { Carro } from '../../../models/carro';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-carroslist',
  standalone: true,
  imports: [RouterLink, ],
  templateUrl: './carroslist.component.html',
  styleUrl: './carroslist.component.scss'
})
export class CarroslistComponent {
  route = new Router()
  carrosList: Carro[] = [];

  constructor() {
    this.carrosList = [
      { id: 1, marca: 'Ford', nome: 'Fiesta' },
      { id: 2, marca: 'Chevrolet', nome: 'Onix' },
      { id: 3, marca: 'Toyota', nome: 'Corolla' },
      { id: 4, marca: 'Honda', nome: 'Civic' },
      { id: 5, marca: 'Volkswagen', nome: 'Golf' },
      { id: 6, marca: 'Hyundai', nome: 'HB20' },
      { id: 7, marca: 'Renault', nome: 'Sandero' },
      { id: 8, marca: 'Fiat', nome: 'Argo' },
      { id: 9, marca: 'Peugeot', nome: '208' },
      { id: 10, marca: 'Nissan', nome: 'Kicks' }
    ]};

    excluir(id: number){
      // Implementar a exclusão
    }


}

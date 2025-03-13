import { Injectable } from '@angular/core';
import { Carro } from '../models/carro';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarrosService {
  private carrosSource = new BehaviorSubject<Carro[]>([
    { id: 1, marca: 'Ford', nome: 'Fiesta' },
    { id: 2, marca: 'Chevrolet', nome: 'Onix' },
    { id: 3, marca: 'Toyota', nome: 'Corolla' },
    { id: 4, marca: 'Honda', nome: 'Civic' },
    { id: 5, marca: 'Volkswagen', nome: 'Golf' },
    { id: 6, marca: 'Hyundai', nome: 'HB20' },
    { id: 7, marca: 'Renault', nome: 'Sandero' },
    { id: 8, marca: 'Fiat', nome: 'Argo' },
    { id: 9, marca: 'Peugeot', nome: '208' },
    { id: 10, marca: 'Nissan', nome: 'Kicks' },
    { id: 11, nome: 'Toyota', marca: 'Corolla'},
    { id: 12, nome: 'Honda', marca: 'Civic' },
  ]);

  carros$ = this.carrosSource.asObservable();

  constructor() { }

  adicionarCarro(carro: Carro) {
    const currentCarros = this.carrosSource.getValue();
    const novoId = Math.max(...currentCarros.map(c => c.id)) + 1;
    const novoCarro = { ...carro, id: novoId };
    this.carrosSource.next([...currentCarros, novoCarro]);
  }
}

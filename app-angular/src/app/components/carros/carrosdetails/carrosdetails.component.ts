import { Component, inject } from '@angular/core';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { FormsModule } from '@angular/forms';
import { Carro } from '../../../models/carro';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { CarrosService } from '../../../services/carros.service';

@Component({
  selector: 'app-carrosdetails',
  standalone: true,
  imports: [MdbFormsModule, FormsModule],
  templateUrl: './carrosdetails.component.html',
  styleUrl: './carrosdetails.component.scss'
})
export class CarrosdetailsComponent {
  novoCarro = {
    id: 0,
    nome: '',
    marca: ''
  };

  router = inject(Router);

  constructor(private carrosService: CarrosService) {};

  onSubmit() {
    this.carrosService.adicionarCarro(this.novoCarro);
    // Resetar o formulário após adicionar
    this.novoCarro = {
      id: 0,
      nome: '',
      marca: ''
    };
  }
  salvar(){
    // Implementar a inclusão
    Swal.fire({
      title: "Salvo com sucesso!",
      confirmButtonColor: "green",
      icon: "success"
    }).then((result) => {
      this.router.navigate(['admin/carros']);
    });
  }
}

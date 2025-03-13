import { Component, OnInit } from '@angular/core';
import { Carro } from '../../../models/carro';
import Swal from 'sweetalert2';
import { Router, RouterLink } from '@angular/router';
import { CarrosService } from '../../../services/carros.service';

@Component({
  selector: 'app-carroslist',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './carroslist.component.html',
  styleUrl: './carroslist.component.scss'
})
export class CarroslistComponent implements OnInit {
  route = new Router()
  carros: Carro[] = [];

  constructor(private carrosService: CarrosService) {};
  ngOnInit() {
    this.carrosService.carros$.subscribe(
        carros => {this.carros = carros;}
    );
  }
    excluir(id: number){
      // Implementar a exclusão
      const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
          confirmButton: "btn btn-success",
          cancelButton: "btn btn-danger",
        }
      });
      swalWithBootstrapButtons.fire({
        title: "Excluir?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonText: "Excluir",
        cancelButtonText: "Cancelar",
      }).then((result) => {
        if (result.isConfirmed) {
          swalWithBootstrapButtons.fire({
            title: "Deletado!",
            icon: "success"
          });
          this.carros = this.carros.filter(carro => carro.id !== id);
        } else if (
          result.dismiss === Swal.DismissReason.cancel
        ) {
          swalWithBootstrapButtons.fire({
            title: "Cancelado!",
            icon: "error"
          });
        }
      });
    }


}

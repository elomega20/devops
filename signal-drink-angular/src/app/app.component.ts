import { Component, computed, effect, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Drink } from "./drink.enum";
import { TitreComponent } from "./components/titre/titre.component";

const EMPTY_WATER_URL = 'https://cdn-icons-png.flaticon.com/512/3100/3100553.png';
const FILLED_WATER_URL = 'https://cdn-icons-png.flaticon.com/512/3100/3100566.png';
const EMPTY_COFFEE_URL = 'https://cdn-icons-png.flaticon.com/512/924/924412.png';
const FILLED_COFFEE_URL = 'https://cdn-icons-png.flaticon.com/512/924/924514.png';

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    imports: [CommonModule, TitreComponent]
})
export class AppComponent {
  Drink = Drink;
  indexes = [0, 1, 2, 3, 4];
  quantity = signal(2);
  type = signal(Drink.Water);
  emptyImageUrl = computed(() => this.type() === Drink.Water ? EMPTY_WATER_URL : EMPTY_COFFEE_URL);
  filledImageUrl = computed(() => this.type() === Drink.Water ? FILLED_WATER_URL : FILLED_COFFEE_URL);
  message = computed(() => `J'ai bu ${this.quantity()} ${this.type() === Drink.Water ? 'verre(s) d\'eau' : 'tasse(s) de café'}`);

  decrement() {
    this.quantity.update(quantity => quantity ? quantity - 1 : 0);
  }

  increment() {
    this.quantity.update(quantity => quantity < this.indexes.length ? quantity + 1 : this.indexes.length+1);
  }

  panierPleine = effect(() => {
      if(this.quantity()>this.indexes.length){
        alert('Tout les verres sont remplis!');
      }
    }
  )
}


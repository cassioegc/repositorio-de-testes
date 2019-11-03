import { Food } from './Food.model';

export class Order {
    food: Food;
    amount: number;

    constructor(food?: Food, amount: number = 1) {
        this.food = food;
        this.amount = amount;
    }
}

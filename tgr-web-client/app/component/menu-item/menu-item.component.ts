import { Component } from '@angular/core';
@Component({
    selector: 'menu-item-component',
    templateUrl: 'app/component/menu-item/menu-item.html'
})
export class MenuItemComponent {
    name: string;
    image; string;

    constructor(name: string, image: string) {
        this.name = name;
        this.image = image;
    }
}
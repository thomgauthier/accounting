import { Component } from '@angular/core';
import {MenuItemComponent} from 'app/component/menu-item/menu-item.component';
@Component({
    selector: 'menu-component',
    templateUrl: 'app/component/menu/menu.html'
})
export class MenuComponent {
    entries: Array<MenuItemComponent>;
    constructor() {

    }

    addEntry(entryComponent) {
        entries.push(entryComponent);
    }
}
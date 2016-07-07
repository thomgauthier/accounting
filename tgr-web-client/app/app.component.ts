import { Component } from '@angular/core';
import { MenuComponent } from 'app/component/menu/menu.component';
import { MenuItemComponent } from 'app/component/menu-item/menu-item.component';
@Component({
    selector: 'accounting-app',
    templateUrl: 'app/application.html',
    directives: [MenuComponent]
})
export class AppComponent {
    menu: MenuComponent;
    constructor() {
        menu = new MenuComponent();
        menu.addEntry(new MenuItemComponent('entry1', 'app/img/pulse.png'));
    }

}
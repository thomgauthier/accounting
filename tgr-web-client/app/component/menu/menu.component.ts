import { Component } from '@angular/core';
import {MenuItemComponent} from '../menu-item/menu-item.component';
import { ContentFrameComponent } from '../content/content-frame.component';
@Component({
    selector: 'menu-component',
    templateUrl: 'app/component/menu/menu.html',
    providers: [ContentFrameComponent]
})
export class MenuComponent {
    entries: Array<MenuItemComponent>;
    constructor(contentFrame: ContentFrameComponent) {
    	this.entries = new Array<MenuItemComponent>();
    	this.addEntry(new MenuItemComponent('statusComponent', 'status.html', 'app/img/pulse.png', contentFrame));
        this.addEntry(new MenuItemComponent('entryComponent', 'entry.html', 'app/img/add.png', contentFrame));
    }

    addEntry(entryComponent) {
        this.entries.push(entryComponent);
    }
}
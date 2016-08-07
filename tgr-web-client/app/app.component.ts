import { Component } from '@angular/core';
import { MenuComponent } from './component/menu/menu.component';
import { MenuItemComponent } from './component/menu-item/menu-item.component';
import { ContentFrameComponent } from './component/content/content-frame.component';
@Component({
    selector: 'accounting-app',
    templateUrl: 'app/application.html',
    directives: [MenuComponent, MenuItemComponent, ContentFrameComponent]
})
export class AppComponent {
    menu: MenuComponent;
    contentFrame: ContentFrameComponent;
    constructor() {
    	this.contentFrame = new ContentFrameComponent();
        this.menu = new MenuComponent(this.contentFrame);
    }

}
import { Component } from '@angular/core';
import { ContentFrameComponent } from '../content/content-frame.component';
import { EntryComponent } from '../entry/entry.component';
@Component({
    selector: 'menu-item-component',
    templateUrl: 'app/component/menu-item/menu-item.html',
    providers: [ContentFrameComponent]
})
export class MenuItemComponent {
    id: string;
    templateUrl: string;
    image: string;
    contentFrame: ContentFrameComponent;

    constructor(id: string, templateUrl: string, image: string, contentFrame: ContentFrameComponent) {
        this.id = id;
        this.templateUrl = templateUrl;
        this.image = image;
        this.contentFrame = contentFrame;
    }

    public onSelect() {
        this.contentFrame.display(new EntryComponent());
    }
}
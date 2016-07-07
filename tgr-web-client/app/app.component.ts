import { Component } from '@angular/core';
import { MenuComponent } from 'app/component/menu/menu.component.ts';
@Component({
    selector: 'accounting-app',
    templateUrl: 'app/application.html',
    directives: [MenuComponent]
})
export class AppComponent { }
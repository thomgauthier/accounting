"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var menu_component_1 = require('./component/menu/menu.component');
var menu_item_component_1 = require('./component/menu-item/menu-item.component');
var content_frame_component_1 = require('./component/content/content-frame.component');
var AppComponent = (function () {
    function AppComponent() {
        this.contentFrame = new content_frame_component_1.ContentFrameComponent();
        this.menu = new menu_component_1.MenuComponent(this.contentFrame);
    }
    AppComponent = __decorate([
        core_1.Component({
            selector: 'accounting-app',
            templateUrl: 'app/application.html',
            directives: [menu_component_1.MenuComponent, menu_item_component_1.MenuItemComponent, content_frame_component_1.ContentFrameComponent]
        }), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map